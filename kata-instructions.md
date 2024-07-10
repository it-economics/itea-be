# ITEA 17 - Docker Container

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

## Open Question
- Dockerfile: how to retrieve current version (SNAPSHOT) from maven project
- Jib Plugin: how to integrate in Maven Lifecycle

## The task

Download and install Docker Desktop
https://www.docker.com/products/docker-desktop/

### via Dockerfile and terminal commands

in project root "Dockerfile"
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

Builds and deploys to docker according to the Dockerfile
> docker build -t itea-be .

Starts the docker container with mapped port
> docker run -d -p 8099:9000 --name itea-be itea-be

### via jib maven plugin
build:
> mvn jib:dockerBuild

run:
> docker run -d -p 8099:9000 --name itea-be itea-be:0.0.1-SNAPSHOT

```
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.1.4</version> 
    <configuration>
        <from>
            <image>openjdk:17</image> 
            <platforms>
                <platform>
                    <architecture>arm64</architecture>
                    <os>linux</os>
                </platform>
            </platforms>
        </from>
        <to>
            <image>itea-be:${project.version}</image> 
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

### exec maven  plugin
execution via:
> mvn package -Pdockerfile-build

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
Or move the "plugin /plugin" part into plugins section to run it automatically with maven lifecycle 

### Some more
jib google plugin

shows the different available docker jdk artefacts
> https://hub.docker.com/_/openjdk

maven lifecycle
> https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#lifecycle-reference
