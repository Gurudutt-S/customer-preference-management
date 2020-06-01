# CUSTOMER PREFERENCE-SuperStore

## Desciption



This is a project used for updating customer preference.

```bash
Representative submits communication preference by getting the details from Customer or Customer can directly access the self-service Kiosks.
```

## Technical Specification

```basic
This project is build using Java Framework 'SpringBoot'.
```



| Title                      | Specification                                                |
| :------------------------- | :----------------------------------------------------------- |
| Architecture               | Microservices  `a.get-customer-id-service` ` b.customer-preference-service` `c.generate-report-service` |
| Database                   | MySQL                                                        |
| Database Framework         | Hibernate                                                    |
| Front-end Framework        | Angular                                                      |
| API                        | REST                                                         |
| Testing Tool               | Junit                                                        |
| Security                   | Spring Security                                              |
| Microservice Registry      | Eureka Server                                                |
| API Gateway                | Zuul Server                                                  |
| Load Balancer              | Ribbon                                                       |
| MIcroservice communication | Feign                                                        |

```bash
Other Dependencies are 
-1.Actuator
-2.Lombok
-3.Swagger
-4.JPA
-5.Hystrix
-6.Sleuth
-7.Sonar
-8.Config server 
```

To run angular application run the commands in the terminal:

1. `npm install` - for installing node modules.
2. `ng add @angular/material` - for adding angular material.
3. `npm install bootstrap --save` - for installing bootstrap.
4. `npm install jquery --save` -for installing jquery.
5. Reference the path in `angular.json` file:

```json
"styles": ["node_modules/bootstrap/dist/css/bootstrap.min.css",
              "src/styles.scss"
            ],
            "scripts": [
              "node_modules/jquery/dist/jquery.min.js",
              "node_modules/bootstrap/dist/js/bootstrap.min.js"
            ]
          },
```



For running all the microservices

* open eclipse IDE
* import the microservices as `maven` project

`customer-preference-service`

```java
Right click on the project
    -Run as spring boot app
    -using post mapping update the values in database
    -The port number used is 8002
```

`get-customer-id-service`

```jav
Right click on the project
	-Run as spring boot app	
	-the port number used is 8000
```

`generate-report-service`

```java
Right click on the project
    -Run as spring boot app
    -the port number used is 8001
```
