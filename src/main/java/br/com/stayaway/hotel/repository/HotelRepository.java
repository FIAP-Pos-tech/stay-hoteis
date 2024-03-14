package br.com.stayaway.hotel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.stayaway.hotel.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, String> {

}
