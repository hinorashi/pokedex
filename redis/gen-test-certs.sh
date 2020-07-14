#!/bin/bash
# pls refer https://redis.io/topics/encryption

# trust me, windows git bash needs this
export MSYS_NO_PATHCONV=1

mkdir -p tls
openssl genrsa -out tls/ca.key 4096
openssl req \
    -x509 -new -nodes -sha256 \
    -key tls/ca.key \
    -days 3650 \
    -subj '/C=VN/O=Hino Corp/CN=Fake Certificate Authority' \
    -out tls/ca.crt
openssl genrsa -out tls/redis.key 2048

# the name redis-cache will be use as domain name for DNS lookup
openssl req \
    -new -sha256 \
    -key tls/redis.key \
    -subj '/C=VN/O=Hino Corp/CN=redis-cache' | \
    openssl x509 \
        -req -sha256 \
        -CA tls/ca.crt \
        -CAkey tls/ca.key \
        -CAserial tls/ca.txt \
        -CAcreateserial \
        -days 365 \
        -out tls/redis.crt
openssl dhparam -out tls/redis.dh 2048
