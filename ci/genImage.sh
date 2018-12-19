#!/usr/bin/env bash

$(aws ecr get-login --no-include-email --region cn-north-1)

docker build -t shipping-service .

docker push 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:latest
