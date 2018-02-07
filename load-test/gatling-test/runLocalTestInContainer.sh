#!/usr/bin/env sh
mkdir -p tmp/results

TEST_HOSTNAME=$1
TEST_PORT=$2

if [ "$#" != "2" ]; then
    echo "Usage: ./runLocalTestInContainer.sh [hostname-of-host-to-be-tested port-of-host-to-be-tested]"
    exit -1
fi

docker run -it --rm \
                    -e BASE_URL="http://${TEST_HOSTNAME}:${TEST_PORT}" \
                    -e ITERATIONS=10 \
                    -e CONCURRENT_USERS=2 \
                    -v ${PWD}/tmp/results:/opt/gatling/results \
                 load-test:1
