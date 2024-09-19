package br.rfdouro.livrosservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rfdouro
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

 private Integer idLivro;
 private String nomeLivro;
 private Double custoLivro;
}
