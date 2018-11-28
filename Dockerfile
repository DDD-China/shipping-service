FROM openjdk:8-jdk-alpine

ADD build/libs/shipping-service-0.1.0.jar /work/app.jar
ADD run.sh /

ENTRYPOINT ["/run.sh"]