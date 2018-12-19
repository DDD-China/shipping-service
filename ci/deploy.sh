#!/usr/bin/env bash

sudo kubectl --insecure-skip-tls-verify --kubeconfig $KUBE_CONFIG_FILE get node