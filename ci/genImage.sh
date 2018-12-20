#!/usr/bin/env bash

IMAGE_REPO=shipping-service

$(aws ecr get-login --no-include-email --region cn-north-1)

./gradlew docker
docker tag com.dmall/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER
docker tag com.dmall/$IMAGE_REPO:latest $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:latest
docker push $IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER
