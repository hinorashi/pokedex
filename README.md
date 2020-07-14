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

### 2. One-way TLS/SSL
- generate fake certificate stuffs:
```
cd redis
./gen-test-certs.sh
```
- create trust store:
```
keytool -importcert -trustcacerts -noprompt \
    -keystore ./truststore.p12 \
    -file ./redis/tls/ca.crt \
    -alias redis-cache-ca \
    -storepass hino123
``` 
- if test without docker, pls change the redis host into `redis-cache` instead of `localhost`, and update hosts config:
```
127.0.0.1 localhost redis-cache
```
