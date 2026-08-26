#!/bin/bash

set -euo pipefail

source ./.ci/util.sh

checkForVariable "GITHUB_OUTPUT"

if [[ "$#" != "2" ]]; then
  echo "not all parameters are set"
  echo "Usage: $BASH_SOURCE <variable name> <variable value>"
  exit 1
fi

NAME=$1
VALUE=$2

# Select random value for EOF as a delimiter.
EOF=$(dd if=/dev/urandom bs=15 count=1 status=none | base64)
{
  echo "$NAME<<$EOF"
  echo "$VALUE"
  echo "$EOF"
} >> "$GITHUB_OUTPUT"
