FROM java:8-jdk-alpine

# Gatling log level
ENV LOG_LEVEL INFO

ENV PATH /opt/gatling/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
ENV GATLING_HOME /opt/gatling

# working directory for gatling
WORKDIR /opt

# gating version
ENV GATLING_VERSION 2.2.4

# create directory for gatling install
RUN mkdir -p gatling

# install gatling
RUN apk add --update wget python && \
    mkdir -p /tmp/downloads && \
    wget -q -O /tmp/downloads/gatling-$GATLING_VERSION.zip https://repo1.maven.org/maven2/io/gatling/highcharts/gatling-charts-highcharts-bundle/$GATLING_VERSION/gatling-charts-highcharts-bundle-$GATLING_VERSION-bundle.zip && \
    mkdir -p /tmp/archive && cd /tmp/archive && \
    unzip /tmp/downloads/gatling-$GATLING_VERSION.zip && \
    mv /tmp/archive/gatling-charts-highcharts-bundle-$GATLING_VERSION/* /opt/gatling/ && \
    rm -rf /tmp/*

# Clean up example simulations so they won't be run by accident
RUN rm -rf /opt/gatling/user-files/*

# change context to gatling directory
WORKDIR  /opt/gatling

COPY logback.xml /opt/gatling/conf/logback.xml

# set directories below to be mountable from host
VOLUME ["/opt/gatling/conf", "/opt/gatling/results", "/opt/gatling/user-files"]

# Copy lines like the ones below to your derived container
# The simulation to run.
ENV SIMULATION "None"
# This refers to the simulation files and whatever else you need in your project folder
# ADD user-files /opt/gatling/user-files
# Define your test container based on this one and set it's entrypoint to run the test
# ENTRYPOINT gatling.sh --simulation "$SIMULATION"