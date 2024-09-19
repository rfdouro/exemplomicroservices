package br.rfdouro.livrosservice.controllers;

import br.rfdouro.livrosservice.models.Livro;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rfdouro
 */
@RestController
@RequestMapping("/livro")
public class LivroRestController {

 public static List<Livro> livros = new ArrayList<>(Arrays.asList(new Livro(501, "Head First Java", 439.75),
         new Livro(502, "Spring in Action", 340.75),
         new Livro(503, "Hibernate in Action", 355.75)));

 @Autowired
 Environment environment;

 @GetMapping("/data")
 public String getLivroData() {
  return "dados de livroservice, rodando na porta: "
          + environment.getProperty("local.server.port");
 }

 @GetMapping("/{id}")
 public Livro getLivroById(@PathVariable Integer id) {
  return livros.stream().filter(l -> l.getIdLivro().equals(id)).findFirst().get();
 }

 @GetMapping("/all")
 public List<Livro> getAll() {
  return livros;
 }

 @GetMapping("/entity")
 public ResponseEntity<String> getEntityData() {
  return new ResponseEntity<String>(
          "Olá de LivroRestController",
          HttpStatus.OK);
 }

 @PostMapping("/add")
 public Livro addLivro(@RequestBody Livro livro) {
  livros.add(livro);
  return livro;
 }

 @DeleteMapping("/{id}")
 public Livro deleteLivroById(@PathVariable Integer id) {
  Livro livro = livros.stream().filter(l -> l.getIdLivro().equals(id)).findFirst().get();
  livros.remove(livro);
  return livro;
 }
}
