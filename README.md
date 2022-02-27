# online-food-order-micro


Auth Service => Authenticate User and set roles<br>
Apigw Service => Authentication Filter and Routing<br>
Config Serivce => Centralized Config Server<br>
Naming Service => Service Registry<br>
Kafka Binders are used for messaging, Zipkin used for tracing<br>

Demostrate for online food system using async and sync messaging between microservices. <br>
Authorization seperated to individual microservices, authentication is central 