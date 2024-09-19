package br.rfdouro.estudanteservice.services;

import br.rfdouro.estudanteservice.models.Livro;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author rfdouro
 */
@FeignClient(name = "livrosservice")
public interface LivroRestConsumer {

 @GetMapping("/livro/data")
 public String getLivroData();

 @GetMapping("/livro/{id}")
 public Livro getLivroById(@PathVariable Integer id);

 @GetMapping("/livro/all")
 public List<Livro> getAllLivros();

 @GetMapping("/livro/entity")
 public ResponseEntity<String> getEntityData();

 @PostMapping("/livro/add")
 public Livro adicionaLivro(Livro livro);

 @DeleteMapping("livro/{id}")
 public Livro excluiLivroById(@PathVariable Integer id);

}
