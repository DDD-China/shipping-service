#!/bin/bash

export CIRCLE_BUILD_NUM_DOCKER=0.1.1
export AWS_ECR_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn

./gradlew docker
docker tag $AWS_ECR_REGISTRY/shipping-service:latest $AWS_ECR_REGISTRY/shipping-service:$CIRCLE_BUILD_NUM_DOCKER
docker push $AWS_ECR_REGISTRY/shipping-service:$CIRCLE_BUILD_NUM_DOCKER
docker push $AWS_ECR_REGISTRY/shipping-service:latest
