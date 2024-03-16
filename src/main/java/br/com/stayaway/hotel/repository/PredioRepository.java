package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.domain.Predio;

public interface PredioRepository extends MongoRepository<Predio, String> {

}
