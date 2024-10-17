# ITEA 18 - SOAP

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

### What is SOAP?

S imple  
O bject  
A ccess  
P rotocol

Soap is a format for API protocol based on messages with XML payload (document) for so-called "web services".  
Unless REST, SOAP is not bound to HTTP. Messages can also be sent over other protocols or directly through a TCP/UPD socket 
connection. 
When HTTP or HTTPS is used for a SOAP connection it is a must to make use of the POST method because the XML can get very 
big in size.  
To be independent of the HTTP protocol all endpoints of an API use just one single URL path or port to connect. 
This also means the definition of the endpoint the request wants to use is inside the request and not detectable from 
the metadata of the transport protocol.

Each message (request AND response) consist of three basic and non-optional parts:
- SOAP envelope: wraps the whole message and is XML root tag. In most cases also contains XML specific information like the namespaces used. 
Normally the XML tag \<soapenv:Envelope\> is used
- SOAP header: written inside the envelope. It can contain additional information about the message. It is allowed to leave it empty.
Normally the XML tag \<soapenv:Header\> is used.
- SOAP body: written inside the envelope and contains the message itself. Normally the XML tag \<soapenv:Body\> is used.  
The message format of the body's inner must necessarily be declared with a user defined XML schema (XSD). 

Inside a response the SOAP Envelope optionally can contain a SOAP fault part to submit error information from the server.
When not using HTTP the \<soapenv:Fault\> can be the only possibility to send any qualified error information to the requester.

A typical request SOAP XML can look like this:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
              xmlns:itea="http://de.soprasteria.css/itea/itea-soap-service">
   <soapenv:Header/>
   <soapenv:Body>
      <itea:ProductsRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```
A typical response XML can look like this:
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ProductsResponse xmlns:itea="http://de.soprasteria.css/itea/itea-soap-service">
         <product>
            <id>1</id>
            <name>Picture "Finland"</name>
            <imageName>pictureFinland.png</imageName>
            <description>Picture "Finland"</description>
         </product>
         ...
      </ProductsResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
The API description for SOAP is defined to be an extended XML schema called WSDL. 
Typically, the WSDL describes the endpoints of an API with their request and response message formats. It can contain the 
XML schema for the messages directly or link additional XML schemas files.


## Exercises

⚠️ *Make sure everyone has IntelliJ Community Edition (or equivalent) installed.  
For this Exercise it is also required to have one of SoapUI or Postman installed.  
Now is the time to start the download/installation so that it can be installed during the discussion exercise.  
Also create an account for Postman if necessary*

### Exercise 1: Discussion

- Did you already use SOAP? 
- What could be the reason to use SOAP instead REST?
- Do you see disadvantages in using SOAP?

### Exercise 2: Implementation

*Recommended: The group works as an ensemble.*

We want to extend our application with a SOAP endpoint to deliver the product list.  
The XML-schema is already provided in the project.

You can use the Spring quickstart for SOAP web service: https://spring.io/guides/gs/producing-web-service

1. Add the `jaxb2-maven-plugin` to the Maven build
```
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>jaxb2-maven-plugin</artifactId>
    <version>3.1.0</version>
    <executions>
        <execution>
            <id>xjc</id>
            <goals>
                <goal>xjc</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <sources>
            <source>${project.basedir}/src/main/resources/itea.xsd</source>
        </sources>
    </configuration>
</plugin>
```
2. Run the Maven goal `mvn jaxb2:xjc`.
Maybe you want to modify the plugin configuration to skip points 3 and 4 ;-)
<details>
<summary>see config</summary>

```
    <configuration>
        <sources>
            <source>${project.basedir}/src/main/resources/itea.xsd</source>
        </sources>
        <outputDirectory>${project.basedir}/src/main/java/com/ite/itea/ecommerce/usecase/soapmodel/</outputDirectory>
    </configuration>
```
</details>

3. Find the generated model classes in  `target/generated-sources/`.
4. Copy the generated classes into the classpath or link the folder into the classpath
5. The SOAP configuration for the spring application has already been provided in the project but was not activated. Do this now.  
*Discuss:* - What is configured there? 
6. Now create a new SOAP endpoint class and the method to deliver the product list. Use existing functionality if possible.  
*Discuss:* 
  - What ist the difference to implementations of REST methods?
  - Why is "namespace" and "localPart" important?
  - Can we reuse the classes from the REST methods?
7. Download the WSDL from the running Application http://localhost:9000/soap/products.wsdl (Yes it is available if configuration is correct)
Can you compare it to the OpenAPI description http://localhost:9000/v3/api-docs? 
8. Import the WSDL into SoapUI/Postman and try to send a request to the application.


### Exercise 3: Advanced discussion

*Recommended: The group works as an ensemble.*

- Look at the request "payloads". (generated code / WSDL / XML schema)
- Why do we have to have a request and a response object defined even the request has no parameters?
- What is your opinion - REST or SOAP?
