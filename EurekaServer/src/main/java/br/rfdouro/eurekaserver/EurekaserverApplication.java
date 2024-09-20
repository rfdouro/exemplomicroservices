package br.rfdouro.eurekaserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
@EnableDiscoveryClient
public class EurekaserverApplication {

 public static void main(String[] args) {
  SpringApplication.run(EurekaserverApplication.class, args);
 }
 
 
 @Bean
 public OpenAPI dadosOpenAPI() {
  Contact contact = new Contact();
  contact.setEmail("rfdouro@gmail.com");
  contact.setName("Rômulo Douro");
  //contact.setUrl("https://www.bezkoder.com");

  License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

  Info info = new Info()
          .title("Serviços")
          .version("1.0")
          .contact(contact)
          .description("API de exposição do serviços.")//.termsOfService("https://www.bezkoder.com/terms")
          .license(mitLicense);

  return new OpenAPI().info(info);//.servers(List.of(devServer, prodServer));
 }

}
