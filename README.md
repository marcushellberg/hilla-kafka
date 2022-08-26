# Full-stack reactive Spring Kafka app using Hilla

This is an example application showing how to produce and consume Kafka messages in a Spring Boot application using [Spring Kafka](https://spring.io/projects/spring-kafka) and [Hilla}(https://hilla.dev).

## Requirements

- Java 11 +
- A Kafka broker

## Installing Kafka

The application is configured to use a local Kafka broker. 
You can use a managed solution like Confluent by updating `application.properties` appropriately. 

1. Download Kafka from [the Kafka website](https://kafka.apache.org/quickstart)
2. Extract the archive
3. Start Zookeeper with `bin/zookeeper-server-start.sh config/zookeeper.properties`
4. Start the Kafka broker with `bin/kafka-server-start.sh config/server.properties`

## Running the application

1. Make sure you have Kafka running (see above)
2. Run the app with the included Maven wrapper `./mvnw`, or by running the `Application` Java class.
