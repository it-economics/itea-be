# ITEA 17 - Docker Container

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

## What you need upfront to get started
Download and install Docker Desktop
https://www.docker.com/products/docker-desktop/

# The task
## Build and Run a Container

1.) Discussion: why docker is useful? Where and Why it is needed?
some buzzwords:
- Test H2 vs. production Database
- development environment vs. production environment 
- bundle a complex application
- ...

2.) Create a docker image and run it in a container 

### via Dockerfile and terminal commands

in project root "Dockerfile"
<details>
<summary>Dockerfile</summary>

```
# Step 1: Use a base image with Java (adopting an OpenJDK image for compatibility)
FROM openjdk:17

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the built jar file from your target directory to the container
COPY target/itea-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your application uses, default Spring Boot port is 8080
EXPOSE 9000

# Step 5: Run your application
ENTRYPOINT ["java", "-jar", "app.jar"]
```
</details>

Builds the image to docker according to the Dockerfile
> docker build -t itea-be:0.0.1-SNAPSHOT -t itea-be:latest .

Creates the docker container
> docker create -p 8099:9000 --name itea-be itea-be:latest

Starts/Stops the docker container
> docker start itea-be
> docker stop itea-be

OR: Runs a newly created docker container  (docker create + docker start)
> docker run -d -p 8099:9000 --name itea-be itea-be:latest

- own management of versioning

### How to integrate into a CI/CD pipeline?
Discussion: how to integrate

### via jib maven plugin

build:
> mvn jib:dockerBuild

run:
> docker run -d -p 8099:9000 --name itea-be itea-be:0.0.1-SNAPSHOT


<details>
<summary>Jib plugin for pom.xml</summary>

```
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.1.4</version> 
    <configuration>
        <from>
            <image>openjdk:17-alpine</image> 
            <platforms>
                <platform>
                    <architecture>arm64</architecture>
                    <os>linux</os>
                </platform>
            </platforms>
        </from>
        <to>
            <image>itea-be:latest</image>
            <tag>${project.version}</tag> 
        </to>
        <container>
            <ports>
                <port>9000</port> 
            </ports>
            <environment>
                <JAVA_OPTS>-Xms512m -Xmx512m</JAVA_OPTS> 
            </environment>
        </container>
    </configuration>
</plugin>
```
</details>

### exec maven  plugin
execution via:
> mvn package -Pdockerfile-build

<details>
<summary>execution plugin for pom.xml</summary>

```
<profiles>
    <profile>
        <id>dockerfile-build</id>
        <build>
            <plugins>
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>exec-maven-plugin</artifactId>
                    <version>3.0.0</version>
                    <executions>
                        <execution>
                            <id>docker-build</id>
                            <phase>package</phase>
                            <goals>
                                <goal>exec</goal>
                            </goals>
                            <configuration>
                                <executable>docker</executable>
                                <arguments>
                                    <argument>build</argument>
                                    <argument>-t</argument>
                                    <argument>itea-be:${project.version}</argument>
                                    <argument>.</argument>
                                </arguments>
                            </configuration>
                        </execution>
                        <execution>
                            <id>docker-run</id>
                            <phase>package</phase>
                            <goals>
                                <goal>exec</goal>
                            </goals>
                            <configuration>
                                <executable>docker</executable>
                                <arguments>
                                    <argument>run</argument>
                                    <argument>-d</argument>
                                    <argument>-p</argument>
                                    <argument>8099:9000</argument>
                                    <argument>--name</argument>
                                    <argument>itea-be</argument>
                                    <argument>itea-be:${project.version}</argument>
                                </arguments>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>
    </profile>
</profiles>
```
</details>

Or move the "plugin /plugin" part into plugins section to run it automatically with maven lifecycle

### via Docker Compose

- create the backend image (see above)
- create the frontend image (https://github.com/it-economics/itea-fe-angular)
- run docker compose file (/itea-be/src/main/resources/docker/docker-compose.yml)

run via:
> docker-compose up -d

### Some more
shows the different available docker jdk artefacts
> https://hub.docker.com/_/openjdk

maven lifecycle
> https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#lifecycle-reference

## TestContainer
we prepared three different ways of implementation

### static container
- all properties are overwritten in the test class
- not recommended (we will explain this ;) )
- see: itea-be/src/test/java/com/itea/ecommerce/docker/PostgresStaticContainerTest.java

### dynamically created
- with own test profile
- see: itea-be/src/test/java/com/itea/ecommerce/docker/PostgresContainerProfileTest.java

### with test annotation
- with a simple annotation
- see: itea-be/src/test/java/com/itea/ecommerce/docker/PostgresContainerAnnotationTest.java 
- see: itea-be/src/test/java/com/itea/ecommerce/docker/WithPostgresContainer.java
