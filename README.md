# Exemplo de Microserviço
Exemplo de microserviços com `SpringBoot`

&rarr; Serviço de estudantes com acesso a serviços de livros e agenda

> Também é usado um serviço com Node e [Express](https://expressjs.com/)

## Dados dos projetos

|projeto|plataforma|descrição|obs.|
|----|----|----|----|
|EurekaServer|Java / Spring|Gateway de microsserviços para Spring|opcional para o exemplo|
|livroservice|Java / Spring|Serviço de simulação de cadastro de livros||
|agendaservice|Javascript / Node|serviço de simulação de agenda||
|estudanteservice|Java / Spring|Serviço de simulação de cadastro de alunos com consumo do serviço de livros e de agenda||

Adaptado do artigo [How to Implement Feign Client in Spring Boot Microservices?](https://javatechonline.com/how-to-implement-feign-client-in-spring-boot-microservices/)

## Fontes de pesquisa e consulta
* [A Guide to Spring Boot Admin](https://www.baeldung.com/spring-boot-admin)
* [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
* [Feign simplifies the process of writing Java HTTP clients](https://github.com/OpenFeign/feign)
* [Swagger UI configuration for API-Gateway in Spring Boot](https://medium.com/@agayevilkin76/api-gateway-swagger-ui-config-for-spring-boot-6d51a0294a34)
* [Spring WebClient (with Hands-On Examples)](https://howtodoinjava.com/spring-webflux/webclient-get-post-example/)
