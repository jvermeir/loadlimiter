FROM mygatling:latest

ENV BASE_URL "http://localhost:8123"
ENV ITERATIONS 10
ENV CONCURRENT_USERS 2

ENV SIMULATION "LoadTest"

ADD src/test/scala /opt/gatling/user-files/simulations
ADD wrapper.sh /wrapper.sh
WORKDIR /opt/gatling
ENTRYPOINT /wrapper.sh