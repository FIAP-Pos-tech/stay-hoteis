package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.Servico;

public interface ServicoRepository extends MongoRepository<Servico, String> {

}
