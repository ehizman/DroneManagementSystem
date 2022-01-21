# Springboot-Drone-Management-Rest-Service

![Drone Image](https://geospatialmedia.s3.amazonaws.com/wp-content/uploads/2019/07/UAVs-help2.jpg)

[//]: # ([![Build Status]&#40;https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master&#41;]&#40;https://travis-ci.org/codecentric/springboot-sample-app&#41;)
[//]: # ([![Coverage Status]&#40;https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master&#41;]&#40;https://coveralls.io/github/codecentric/springboot-sample-app?branch=master&#41;)
[//]: # ([![License]&#40;http://img.shields.io/:license-apache-blue.svg&#41;]&#40;http://www.apache.org/licenses/LICENSE-2.0.html&#41;)

[Postman Documentation](https://documenter.getpostman.com/view/16202798/UVXokDje])

A Drone Management Rest Service built using Springboot Global Exception Handling Mechanism as described and implemented by [George Berar](https://medium.com/@georgeberar.contact/springboot-standardized-api-exception-handling-f31510861350).
Built using H2 in- memory database.
Built according to these [functional requirements](https://drive.google.com/file/d/11v2j2geymo6cPPHQl70Lhk8rIhHh0W0B/view?usp=sharing) 

## Requirements

For building and running the application you need:

- [JDK 16](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ehizman.drones.DroneApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Dependencies

- Spring Starter Web 
- Project Lombok
- Spring Data JPA
- Spring Validation
- MapStruct
- Hamcrest
- AssertJ
- Spring DevTools

[//]: # (## Deploying the application to OpenShift)

[//]: # ()
[//]: # (The easiest way to deploy the sample application to OpenShift is to use the [OpenShift CLI]&#40;https://docs.openshift.org/latest/cli_reference/index.html&#41;:)

[//]: # ()
[//]: # (```shell)

[//]: # (oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/springboot-sample-app)

[//]: # (```)

[//]: # (## Copyright)

[//]: # ()
[//]: # (Released under the Apache License 2.0. See the [LICENSE]&#40;https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE&#41; file.)
