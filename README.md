# # Microservice inditex

- Package infrastructure\  son los elementos externos con los que se comunica la aplicación, tanto de entrada como de salida.
   -          adapters\
       -        input rest  
         -          controller\
       -        output  
         -          data\  
         -          mapper\  
         -          repository\  


- Package application\   En esta capa solemos tener los casos de uso, también llamados acciones o servicios de aplicación.
  -           impl\
  -           ports\       Interfaces de service\
- Package domain\  Aquí es donde se encuentra la lógica de negocio
  -           ports\        Interfaces de repository
  -           service\      Lógica de negocio
  -           model\        modelos de dominio

# Frameworks, Technologies

- Hexagonal Architecture
- Java 11
- Maven
- Spring Boot
- Spring Data Jpa
- Spring Validation
- Swagger
- Junit
- Mockito
- Lombok
- H2

# URLs Access

##  Swagger:
http://localhost:8082/swagger-ui.html

##  BD H2:
http://localhost:8082/h2-console

## IDE recommended
- IntelliJ

## Scrips
|                |                                  |                    
|----------------|----------------------------------|
|**run**		|`mvnw spring-boot:run `            |            
|**test**       |`mvnw test`            |    

