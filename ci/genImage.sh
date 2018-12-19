#!/usr/bin/env bash

IMAGE_REPO=shipping-service

$(aws ecr get-login --no-include-email --region cn-north-1)


docker build -t $IMAGE_REPO:$BUILD_NUMBER .
docker tag $IMAGE_REPO:$BUILD_NUMBER $IMAGE_REPO:latest
docker push 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/$IMAGE_REPO:latest
docker push 955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn/$IMAGE_REPO:$BUILD_NUMBER
