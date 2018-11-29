#!/bin/bash
if [ "$#" -ne 1 ]; then
    echo "You must enter build version (e.g. 0.1.2) as argument! Usage example: 'genImages.sh 0.1.2'"
    exit 1
fi

export REPO_NAME=shipping-service
export ORG_NAME=com.dmall
export AWS_ECR_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn

./gradlew docker

docker tag $ORG_NAME/$REPO_NAME:latest $AWS_ECR_REGISTRY/$REPO_NAME:$1
docker push $AWS_ECR_REGISTRY/$REPO_NAME:$1

docker tag $ORG_NAME/$REPO_NAME:latest $AWS_ECR_REGISTRY/$REPO_NAME:latest
docker push $AWS_ECR_REGISTRY/$REPO_NAME:latest
