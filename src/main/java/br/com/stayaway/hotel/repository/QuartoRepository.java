package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.domain.Quarto;

public interface QuartoRepository extends MongoRepository<Quarto, String> {

}
