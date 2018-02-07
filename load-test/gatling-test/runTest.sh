#!/usr/bin/env sh

export ITERATIONS=10
export BASE_URL=http://localhost:8123
export CONCURRENT_USERS=2

mvn gatling:test
