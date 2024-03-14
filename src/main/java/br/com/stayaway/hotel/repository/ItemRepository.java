package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

}
