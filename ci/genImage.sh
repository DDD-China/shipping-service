#!/usr/bin/env bash

IMAGE_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn
IMAGE_REPO=shipping-service

$(aws ecr get-login --no-include-email --region cn-north-1)

docker build -t $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER .
docker tag $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER
