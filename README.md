# loadlimiter

Find out how to limit the load on a webservice based on responsetimes.

TODO

- set up a dummy service, maybe a simple Python http service that accepts requests and then responds after a set interval.
- add a put method to set the response time so we can simulate failure
- set up Gatling test to put the service under load
- check if test fails when wait time is increased. the failure cause should be responsse time
- add a rate limiter so the response times remain constant for successful requests or 40X for requests that arrive when the max number of requests is reached
- limit the load based on server response times; if the response time increases a larger percentage of requests should fail.
