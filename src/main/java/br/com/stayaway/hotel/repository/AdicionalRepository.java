package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.domain.Adicional;

public interface AdicionalRepository extends MongoRepository<Adicional, String> {

}
