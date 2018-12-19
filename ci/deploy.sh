#!/usr/bin/env bash

IMAGE_REGISTRY=955065381857.dkr.ecr.cn-north-1.amazonaws.com.cn
IMAGE_REPO=shipping-service
IMAGE_URI=$IMAGE_REGISTRY/$IMAGE_REPO:$BUILD_NUMBER

sed "s/IMAGE_URI/$IMAGE_URI/g" ci/kube-deploy.yaml | sudo kubectl --insecure-skip-tls-verify --kubeconfig $KUBE_CONFIG_FILE apply -f -