#!/usr/bin/env bash

git submodule foreach git checkout master
git submodule foreach git pull