# Application base microservices (suite3)
  
  ## description

- application base microservices: **addresses**, **companies**, **employees** and **project**.
- technique architecture of business microservices: **clean-architecture**.
- **kafka infrastructure**, **avro**, **schema-registry**: define kafka events schema, serialize and distribute events.
- **configuration server**: centralize and distribute microservices configurations.
- **gateway service**: bridge between http user on front side and microservices on back side.

## NEW

- **(NEW feature)**: **nginx-ingress contoller**
- **(NEW feature)**: **ingress-rules** added
- **(NEW fix)**: all k8s services are **ClusterIP**

##

the whole application is divided into: 
- business microservices define the business the functionnality of the application
- utility services: serving business microservices for a good interoperability
- database for each business microservice for persisting generated data

# 1. business microservices
- address
- employee
- company
- project
  ## modeling
  ![AEPC](https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-aepc-back/assets/124048212/ee999c04-d0cb-4fab-885e-1be141992c49)


# 2. utility services

## 2.1. configuration server
spring cloud configuration server to centralizig into a git repository and distribute microservices configurations

## 2.2. kafka infrastructure
- **zookeeper**: to manage kafka servers (brokers)
- **3 kafka-servers**: publish events into topics and disbribute them to consumers
- **schema-registry**: defines and register a common schema for all kafka events
- **avro-schema**: serializes kafka events
- **kafdrop-ui**: a ui to manage kafka topics and events

### kafka architecture inside business microservices
- a model is a java bean that is sent as payload using a REST api, 
- a spring service build a kafka message with java model,
- a spring service uses kafka producer to send the kafka message to kafka topic,
- a spring service uses kafka consumer to subscribe to the kafka topic and consumes events that it sends to another spring service,
- the final spring service can handle received event as it wants, either to persist it in db or do anything with it.

### kafka infra summary
![kafka-infrastructure](https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-back/assets/124048212/88c95aa7-3837-4750-9593-592ebfd66544)

- the schemaregistry defines a common schema for all events to publish into kafka topics,
- avro-schema uses that defined and registered schema to serialize avents,
- after events serialized, kafka producer send them into kafka topics.


## 2.3. gateway-service
  
  **spring-cloud-gateway-service**: a unique entrypoint (proxy) to backend, serving as bridge between http user on front side and microservices on back side.

# 3. databases

**mysql db** docker image for peristing data generated by business microservices

# tests
- each code unit of business microservices is tested with **JUnit5**
- **Mockito** is used to mock external unit dependency.
- **KafkaContainer** to mock kafka objects containers (producer/consumer). **doc** [Testcontainers for Java](https://java.testcontainers.org/modules/kafka/).
- all java/spring services of the application are deployed in **docker image,** using a **docker-compose** template
- **Jenkins** to automate jobs. at each git commit, Jenkins launch automatically jobs defined into **./Jenkinsfile**:
  - build, package each microservice and publish a related jar file : **mvn clean install**, **archiveArtifacts '/target/*.jar'**.
  - test all code units of all business microservices and published a report of tests: **mvn test**, **junit '/target/surefire-reports/TEST-*.xml**
  - build a docker image of each microservice refering to a dockerfile defined inside microservice: **sh 'docker compose -f compose-file.yaml build'**
  - publish docker images in docker registry: 
    - create Jenkins credentials: **dashboard>Manage Jenkins>credentials**: under global add new credential
    - take docker username and token from personal dockerhub and add them respectively in username and password fields of the displayed form
    - add in the ID field the id of your credentials
    - in Jenkins pipeline (see **Jenkinsfile**), add the docker publish stage 
    ```
    stage ('Publish appli stack docker images') {
            steps {
                echo 'Starting to publish docker images into docker registry'
                script {
                    withDockerRegistry([ credentialsId: 'dockerhub-credentials', url: '' ]) {
                        sh 'docker compose -f compose-file.yaml push'
                    }
                }
            }
        }
    ```
     
## ci-cd overview
  ![my-ci-cd-flow](https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-back/assets/124048212/517cf618-71d6-4009-80d3-ccc7d052d0b1)

# docker images deployment
 All the services of the application are deployed into docker images: 
- **kafka infra**: zookeeper, 3 kafka-servers (kafka-broker-1, kafka-broker-2, kafka-broker-3), schema-registy-service, kafdrop-ui
- **microservices config server**: k8s-ingress-microservices-config-service
- **spring cloud gateway**: k8s-ingress-gateway-service
- **business microservices**:
  - k8s discovery service dependency for microservices registration and discovery
  - k8s-ingress-kafka-avro-bs-ms-address
  - k8s-ingress-kafka-avro-bs-ms-employee
  - k8s-ingress-kafka-avro-bs-ms-company
  - k8s-ingress-kafka-avro-bs-ms-project

# k8s docker container deploy
all the docker containers of the application are deployed into a k8s minikube **pn cluster**.
- **K8s-Container-Orch** contains all k8s containers deployments of the application.
- each k8s deployment (pods) is exposed using a k8 Service of type **ClusterIP**
- **ingress-rules** defines **dns** for 3 cluster ip services: **kafdrop-ui**, **microservices-config-server** (just for test) and **gateway-service**
    - business microservices are accessed throuth the **gateway-service**, then no need to define their dns (Figure: global architecture)
- **ingress-rules** defines **dns** of k8s services: ***./K8s-Container-Orch/7k8s-nginx-ingress/k8s-nginx-ingress.yaml***
- **nginx-ingress-controller** is activated into **pn** cluster: ```>minikube addons enable ingress -p pn```

# expoded endpoints by microservices

- kafka kafdrop ui: **htt://pn-kafdrop-ui.com**: managing kafka objects
- configuration server: **http://pn-config-svc-api.com/ms-config-svc**: for test
- gateway dns: **http://pn-gateway-api.com/**: front-back gateway

## address-microservice

list of exposed endpoints by **k8s-ingress-kafka-avro-bs-ms-address** pod:  
  - [GET] http://pn-gateway-api.com/bs-ms-address  
  - [POST] http://pn-gateway-api.com/bs-ms-address/addresses    
    ***payload***:  
      ```
      {
        num:int value
        street: string value
        poBox: int value
        city: string value
        coutry: string value
      }
      ```  
  - [GET] http://pn-gateway-api.com/bs-ms-address/addresses  
  - [GET] http://pn-gateway-api.com/bs-ms-address/addresses/id/{value of address id}   
  - [DELETE] http://pn-gateway-api.com/bs-ms-address/addresses/id/{value of address id}
  **Note**: address cannot be removed when it is aleardy assigned  employee or company   
  - [PUT] http://pn-gateway-api.com/bs-ms-address/addresses/id/{value of address id}  
    ***payload***:  
     ```
     {
      num:int value
      street: string value
      poBox: int value
      city: string value
      coutry: string value
     }
     ```  
## company-microservice
list of exposed endpoints by **k8s-ingress-kafka-avro-bs-ms-company** pod:  
  - [GET] http://pn-gateway-api.com/bs-ms-company 
  - [POST] http://pn-gateway-api.com/bs-ms-company/companies  
      ***payload***:
      ```
      {
        name: string value
        agency: int value
        type: string value
        address-id: string value
      }
      ```  
  **Note**: cannot create company on address that already holds another company  
  - [GET] http://pn-gateway-api.com/bs-ms-company/companies  
  - [GET] http://pn-gateway-api.com/bs-ms-company/addresses/id/{address-id}  
  - [GET] http://pn-gateway-api.com/bs-ms-company/addresses/city/{city}  
  - [DELETE] http://pn-gateway-api.com/bs-ms-company/companies/id/{company-id}   
  **Note**: cannot delete company holds project(s)  
  - [GET] http://pn-gateway-api.com/bs-ms-company/companies/name/{company-name}
  - [GET] http://pn-gateway-api.com/bs-ms-company/companies/agency/{company-agency}
  - [PUT] http://pn-gateway-api.com/bs-ms-company/companies/id/{company-id}  
    ***payload***:
    ```
    {
      name: string value
      agency: int value
      type: string value
      address-id: string value
    }
    ```  
  **Note**: cannot update company on address holding another company  
## employee-microservice 
list of exposed endpoints by **k8s-ingress-kafka-avro-bs-ms-employee** pod:  
  - [GET] http://pn-gateway-api.com/bs-ms-employee  
  - [POST] http://pn-gateway-api.com/bs-ms-employee/employees  
  ***payload***:  
  ```
  {
    firstname: string value
    lastname: string value
    state: string value
    type: string value
    address-id: string value
  }
  ```  
  - [GET] http://pn-gateway-api.com/bs-ms-employee/employees  
  - [GET] http://pn-gateway-api.com/bs-ms-employee/employees/id/{employee-id}  
  - [GET] http://pn-gateway-api.com/bs-ms-employee/employees/lastname/{lastname}  
  - [DELETE] http://pn-gateway-api.com/bs-ms-employee/employees/id/{employee-id}  
  **Note**: cannot delete employee already assigned project(s)  
  - [PUT] http://pn-gateway-api.com/bs-ms-employee/employees/id/{employee-id}   
  ***payload:***  
  ```
  {
    firstname: string value
    lastname: string value
    state: string value
    type: string value
    address-id: string value
  }
  ```  
  - [GET] http://pn-gateway-api.com/bs-ms-employee/employees/addresses/id/{address-id}: employees living at given address  
  - [GET] http://pn-gateway-api.com/bs-ms-employee/employees/addresses/city/{address-id}: employees living at given address city  

**Note:** for [POST] and [PUT], ***address-id***, employee ms sends request to address ms to ask address related to address-id. a resilience is managed if address ms is down
## project-microservice
list of exposed endpoints by **k8s-ingress-kafka-avro-bs-ms-project** pod:  
  - [GET] http://pn-gateway-api.com/bs-ms-project  
  - [POST] http://pn-gateway-api.com/bs-ms-project/projects    
  ***payload:***  
  ```
  {
    name: string value
    description: string value
    priority: string value
    state: string value
    employee-id: string value
    company-id: string value
  }
  ```  
  **Note**: cannot create project for archived employee  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects/{project-id}  
  - [DELETE] http://pn-gateway-api.com/bs-ms-project/projects/{value of project id}  
  **Note**: cannot delete project aleardy assigned to employee or company  
  - [PUT] ```http://pn-gateway-api.com/bs-ms-project/projects/{value of project id}  
  **Note**: cannot update project on archived employee  
  ***payload:***  
  ```
  {
    name: string value
    description: string value
    priority: string value
    state: string value
    employee-id: string value
    company-id: string value
  }
  ```  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects/employees/id/{employee-id}: list of projects assigned to a given unique employee  
  - [GET] http://pn-gateway-api.com/bs-ms-project/employees/lastname/{employee-lastname}: list of projects assigned to given employees lastname  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects/companies/id/{company-id}: list of projects assigned to a given unque company  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects/companies/name/{company-name}: list of projects assigned to a given company name with all agencies  
  - [GET] http://pn-gateway-api.com/bs-ms-project/projects/companies/agency/{company-agency}: list of projects assigned to a given company's agency  

**Note:** for [POST] and [PUT], ***employee-id, company-id***, project ms sends request to eployee and company ms to ask employee and company related to employee-id and company-id. a resilience is managed if theses ms are down

# global architecture of the project
- To access to backend, the http user goes through gateway dns ```pn-gateway-api.com```
![nginx-ingress-aepc](https://github.com/placidenduwayo1/k8s-ingress-kafka-avro-back/assets/124048212/6139a9c2-f8ea-400c-8f58-c45a58265e9b)

