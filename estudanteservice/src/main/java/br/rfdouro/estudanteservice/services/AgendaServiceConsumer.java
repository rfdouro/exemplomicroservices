package br.rfdouro.estudanteservice.services;

import br.rfdouro.estudanteservice.models.AgendaResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 *
 * @author rfdouro
 */
@Service
public class AgendaServiceConsumer {

 @Autowired
 private RestClient.Builder restClientBuilder;

 public List<AgendaResponse> getAgendas() {
  List<AgendaResponse> agendasResponse = restClientBuilder
          .build()
          .get()
          .uri("/agendas").
          retrieve()
          .toEntity(List.class)
          .getBody();
  return agendasResponse;
 }

 public Object addAgenda(AgendaResponse agenda) {
  var response = restClientBuilder
          .build()
          .post()
          .uri("/agendas")
          .body(agenda)
          .retrieve()
          .toEntity(List.class)
          .getBody();
  return response;
 }

}
