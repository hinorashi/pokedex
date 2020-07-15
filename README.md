# Pokedex
Let's see what can we do with our Pokedex!
- We use `Spring boot cache` for caching frequently Pokedex queries, backed by `Redis`
- `Redis` cache is configured with `ACL` to improve security (available from Redis 6), for more detail pls refer its [topic](https://redis.io/topics/acl).
- `Redis` cache secure connection is also enabled with one-way TLS.

## Build and Run
```
mvn spring-boot:run
```
or
```
mvn clean package && java -jar target/*.jar
```

## Deploy with docker-compose
```
docker-compose up -d --build
```

## API Document via Swagger 2.0
```
http://localhost:8080
http://localhost:8080/swagger
http://localhost:8080/swagger-ui.html
```

## How to rock it up
### 1. ACL
- redis ACL example:
```
user hino on ~* +@all >hino123
```
- connect to `redis` from `redis-cli`:
```
redis-cli -u redis://localhost:6379 --user pokedex -a pikachu -n 1
```

### 2. One-way TLS
- create new working dir to work with `TLS`, don't be lazy:
```
mkdir tls
```
- create private key and CA cert: (*private key will be git ignored for security reason xD*)
```
MSYS_NO_PATHCONV=1 openssl req -x509 -keyout hino-root-CA.key -out hino-root-CA.crt -nodes -sha256 -newkey rsa:2048 -days 36500 -subj '/C=VN/CN=Hino Fake Certificate Authority'
openssl x509 -text -noout -in hino-root-CA.crt
openssl rsa -check -in hino-root-CA.key
```
- create private key and CSR for redis-cache:
```
MSYS_NO_PATHCONV=1 openssl req -keyout redis-cache.key -out redis-cache.csr -nodes -sha256 -newkey rsa:2048 -subj '/C=VN/CN=redis-cache'
openssl req -text -noout -verify -in redis-cache.csr
openssl rsa -check -in redis-cache.key
```
- sign the CSR with our CA:
```
openssl x509 -req -CA hino-root-CA.crt -CAkey hino-root-CA.key -in redis-cache.csr -out redis-cache.crt -days 3650 -CAcreateserial
openssl x509 -text -noout -in redis-cache.crt
```
- verify cert was signed by CA:
```
openssl verify -verbose -CAfile hino-root-CA.crt redis-cache.crt
```
- generate `PKCS12` truststore with JDK keytool:
```
keytool -importcert -trustcacerts -noprompt -keystore hino-truststore.p12 -file hino-root-CA.crt -alias hino-root-ca -storepass hino123
keytool -list -keystore hino-truststore.p12 -storepass hino123
```
- move stuffs to redis cache server:
```
mv redis-cache.key redis-cache.crt ../redis/tls/
cp hino-root-CA.crt ../redis/tls/
```
- refer redis.conf and docker-compose.yaml for more detail

- if test without docker, pls change the redis host into `redis-cache` instead of `localhost`, and update hosts config:
```
127.0.0.1 localhost redis-cache
```
### 3. Two-way TLS (mutual TLS)
- let's generate new private key and CSR for our pokedex server:
```
MSYS_NO_PATHCONV=1 openssl req -keyout pokedex.key -out pokedex.csr -nodes -sha256 -newkey rsa:2048 -subj '/C=VN/CN=pokedex'
```
- sign them with our CA:
```
openssl x509 -req -CA hino-root-CA.crt -CAkey hino-root-CA.key -in pokedex.csr -out pokedex.crt -days 3650 -CAcreateserial
openssl verify -verbose -CAfile hino-root-CA.crt pokedex.crt
```
- create keystore:
```
openssl pkcs12 -export -in pokedex.crt -inkey pokedex.key -out pokedex-keystore.p12 -name pokedex -password pass:hino123
keytool -list -keystore hino-truststore.p12 -storepass hino123
```
- move stuffs:
```
mv pokedex-keystore.p12 ../src/main/resources/
cp hino-truststore.p12 ../src/main/resources/
```
