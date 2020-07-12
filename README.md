# Pokedex
Let's see what can we do with our Pokedex!
- We use `Spring boot cache` for caching frequently Pokedex queries, backed by `Redis`
- `Redis` cache is configured with `ACL` to improve security (available from Redis 6), for more detail pls refer its [topic](https://redis.io/topics/acl).

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

## Tips and tricks
- redis ACL example:
```
user hino on ~* +@all >hino123
```
- connect to `redis` from `redis-cli`:
```
redis-cli -u redis://localhost:6379 --user pokedex -a pikachu -n 1
```
- generate private key and CSR: (with Linux drop the part `MSYS_NO_PATHCONV=1`)
```
MSYS_NO_PATHCONV=1 openssl req -newkey rsa:2048 -nodes -keyout redis-cache.key -days 365 -out redis-cache.csr -subj '/C=VN/CN=redis-cache/emailAddress=sinhngay3110@gmail.com'
```
- generate private key and self-signed x509 certificate: (with Linux drop the part `MSYS_NO_PATHCONV=1`)
```
MSYS_NO_PATHCONV=1 openssl req -newkey rsa:2048 -nodes -keyout redis-cache.key -x509 -days 365 -out redis-cache.crt -subj '/C=VN/CN=redis-cache/emailAddress=sinhngay3110@gmail.com'
```
- check the certificate:
```
openssl x509 -text -noout -in redis-cache.crt
```
