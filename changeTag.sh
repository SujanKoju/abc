#!/bin/bash
# shellcheck disable=SC2094
sed "s/tagVersion/$1/g" deployment.yaml > deployment.yaml
