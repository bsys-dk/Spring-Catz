Spring-Catz
===========
A concept app written in Spring Boot 4 and Java 25

<img alt="catz.png" height="200" src="images/catz.png" width="150"/>

[![Build](https://github.com/bsys-dk/Spring-Catz/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/bsys-dk/Spring-Catz/actions/workflows/gradle.yml)

This a will be showing all the basic features of 

- Spring boot 4

base tooling:
- .gitattributes
- .gitignore
- .sdkmanrc 
- .editorconfig
- direnv

gradle tooling:
- build.gradle
- gradle.properties
- settings.gradle
- libs.version.toml
- wrapper

Spring tooling:
- JPA
- Spring Web
- Lombok
- And more

devops tooling:
- Github actions
- Test containers
- Docker image



Notes:

To avoid JDK warning:
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended"
```
JAVA_TOOL_OPTIONS="-Xshare:off" ./gradlew run
```