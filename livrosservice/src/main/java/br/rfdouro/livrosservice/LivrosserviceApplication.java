package br.rfdouro.livrosservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LivrosserviceApplication implements WebMvcConfigurer {

 public static void main(String[] args) {
  SpringApplication.run(LivrosserviceApplication.class, args);
 }

 @Override
 public void addCorsMappings(CorsRegistry registry) {
  registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
 }

 @Bean
 public OpenAPI dadosOpenAPI() {
  Contact contact = new Contact();
  contact.setEmail("rfdouro@gmail.com");
  contact.setName("Rômulo Douro");
  //contact.setUrl("https://www.bezkoder.com");

  License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

  Info info = new Info()
          .title("Serviço de Livros")
          .version("1.0")
          .contact(contact)
          .description("API de exposição do serviço de livros.")//.termsOfService("https://www.bezkoder.com/terms")
          .license(mitLicense);

  return new OpenAPI().info(info);//.servers(List.of(devServer, prodServer));
 }

}
