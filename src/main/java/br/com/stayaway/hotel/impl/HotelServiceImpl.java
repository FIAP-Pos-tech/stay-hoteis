package br.com.stayaway.hotel.impl;

import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.model.Predio;
import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.repository.HotelRepository;
import br.com.stayaway.hotel.repository.PredioRepository;
import br.com.stayaway.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService{
	
	//Mongo Template
	private final MongoTemplate mongoTemplate;
	
	public HotelServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private PredioRepository predioRepository;
	
	@Override
	public List<Hotel> buscarTodos() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel obterPorCodigo(String id) {
		return this.hotelRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Hotel não existe")  );
	}

	@Override
	public Hotel criar(Hotel hotel) {
		if(hotel.getPredio().getId().length() != 0) {
			Predio predio = this.predioRepository.findById(hotel.getPredio().getId() )
					.orElseThrow( ()-> new IllegalArgumentException(" Predio não existe")  );
			hotel.setPredio(predio);
		} else {
			hotel.setPredio(null);
		}
		return this.hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotelById(String id) {
		Query query  = new Query( Criteria.where("codigo").is(id));
		this.mongoTemplate.remove(query,Hotel.class);
		
	}

	@Override
	public void atualizar(Hotel hotel) {
		this.hotelRepository.save(hotel);	
	}

	@Override
	public List<Hotel> buscarPorCidade(String cidade) {
		return hotelRepository.findByCidade(cidade);
	}

	public List<Quarto> buscarQuartosPorHotel(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));
		return hotel.getQuartos();
	}

}
