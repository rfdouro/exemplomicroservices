package br.rfdouro.estudanteservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableFeignClients
@SpringBootApplication
public class EstudanteserviceApplication implements WebMvcConfigurer {

 @Value("${agendaservice.base.url}")
 private String agendasBaseUrl;

 public static void main(String[] args) {
  SpringApplication.run(EstudanteserviceApplication.class, args);
 }

 @Override
 public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
 }

 @Bean
 public RestClient.Builder restClientBuilder(){
  return RestClient.builder().baseUrl(agendasBaseUrl);
 }

 @Bean
 public OpenAPI dadosOpenAPI() {
  Contact contact = new Contact();
  contact.setEmail("rfdouro@gmail.com");
  contact.setName("Rômulo Douro");
  //contact.setUrl("https://www.bezkoder.com");

  License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

  Info info = new Info()
          .title("Serviço de Estudantes")
          .version("1.0")
          .contact(contact)
          .description("API de exposição do serviço de estudantes.")//.termsOfService("https://www.bezkoder.com/terms")
          .license(mitLicense);

  return new OpenAPI().info(info);//.servers(List.of(devServer, prodServer));
 }

}
