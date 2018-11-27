#!/bin/bash
export CIRCLE_BUILD_NUM_DOCKER=0.1.1
sed "s/BUILD_VERSION/$CIRCLE_BUILD_NUM_DOCKER/g" shipping-service-kube.yaml > build/shipping-service-kube.yaml
kubectl apply -f build/shipping-service-kube.yaml
