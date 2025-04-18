# ITEA 22 - Monitoring / Logging

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture and home decoration in their stores.
You have been hired as a software developer to help them team implement new features.

Today you will have a look on a service you have never seen before.
And you should enforce the Coding Rules of the Team and Architecture of the software.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

## What does monitoring do

## Why logging is related to monitoring

### Exercise 1

Basic configuration of spring actuator is already activated for the itea-be

1. Start the application and try http://localhost:9000/actuator Does it work?
2. Correct the URL
3. What monitoring informations do you get in basic configurations?
4. Try to activate exposing more informations. Look a the documentation to find out how.  

5. **Discuss whit the group:**  
- Why can it be a security problem to use monitoring?
- What you can do to improve security?
6. Restrict the informations to just show general information and status of the application

### Exercise 2

Configuring one endpoint. We will look at the health monitoring

1. Can you get more detailed information about system health?
2. What sub statuses do we have in the application?

### Exercise 3

show metrics

1. Activate showing metrics in actuator
2. Browse the metrics. Select some and dive into its details.
3. Discuss the different types of metrics you found. 
4. What happens if you reload the page?
5. Try to make a api request and search for the metrics related to it.
5. Discuss in the group:  
- How can you use the metrics to monitor your application?
- Can you get statistics from only using Actuator or will it need more?

### Exercise 4

Monitoring Systems  
We will use the Prometheus adapter of Actuator because it is the only monitoring system
that uses pull principle. Therefor Actuator provides a web endpoint to read the metrics.

1. Enable Prometheus registry and expose the endpoint
2. Can you tell differences to the *metrics/* endpoint?
3. Try to make a api request again and search for the metrics related to it.
4. Discuss in the group:  
- What possibilities does a monitoring system give you to monitor your application

### Exercise 5

Actuator and logging

### Conclusion

