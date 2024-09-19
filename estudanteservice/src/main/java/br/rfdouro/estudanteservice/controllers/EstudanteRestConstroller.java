package br.rfdouro.estudanteservice.controllers;

import br.rfdouro.estudanteservice.models.Livro;
import br.rfdouro.estudanteservice.services.LivroRestConsumer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rfdouro
 */
@RestController
@RequestMapping("/estudante")
public class EstudanteRestConstroller {

 @Autowired
 private LivroRestConsumer consumer;

 @GetMapping("/data")
 public String getStudentInfo() {
  System.out.println(consumer.getClass().getName());  //prints as a proxy class
  return "Acessando de estudanteservice ==> " + consumer.getLivroData();
 }

 @GetMapping("/allLivros")
 public List getLivrosInfo() {
  return consumer.getAllLivros();
 }

 @GetMapping("/getOneLivro/{id}")
 public String getOneLivroForStd(@PathVariable Integer id) {
  return "Acessando de estudanteservice ==> " + consumer.getLivroById(id);
 }

 @GetMapping("/entityData")
 public String printEntityData() {
  ResponseEntity<String> resp = consumer.getEntityData();
  return "Acessando de estudanteservice ==> " + resp.getBody() + " , status é:" + resp.getStatusCode();
 }

 @DeleteMapping("/remove/{id}")
 public Livro addEntityData(@PathVariable Integer id) {
  return consumer.excluiLivroById(id);
 }

 @PostMapping("/entityData")
 public Livro addEntityData(Livro ivro) {
  return consumer.adicionaLivro(ivro);
 }
}
