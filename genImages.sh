#!/usr/bin/env bash

export BUILD_NUMBER=0.0.0

docker build -t 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:$BUILD_NUMBER .
docker tag 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:$BUILD_NUMBER 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:latest

docker push 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:$BUILD_NUMBER
docker push 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/shipping-service:latest

