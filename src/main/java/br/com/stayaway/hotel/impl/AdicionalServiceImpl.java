package br.com.stayaway.hotel.impl;

import java.util.List;

import br.com.stayaway.hotel.model.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.domain.Adicional;
import br.com.stayaway.hotel.repository.AdicionalRepository;
import br.com.stayaway.hotel.service.AdicionalService;

@Service
public class AdicionalServiceImpl implements AdicionalService {

	private final MongoTemplate mongoTemplate;
	private final AdicionalRepository adicionalRepository;
	private final HotelServiceImpl hotelService;
			
	public AdicionalServiceImpl(MongoTemplate mongoTemplate,
								AdicionalRepository adicionalRepository,
								HotelServiceImpl hotelService) {
		this.mongoTemplate = mongoTemplate;
        this.adicionalRepository = adicionalRepository;
        this.hotelService = hotelService;
    }

	@Override
	public List<Adicional> buscarTodos() {
		return this.adicionalRepository.findAll();
	}

	@Override
	public Adicional obterPorCodigo(String id) {
		return this.adicionalRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Serviço não existe")  );
	}

	@Override
	public Adicional criar(Adicional adicional) {
		Hotel hotel = this.hotelService.obterPorCodigo(adicional.getHotelId());
		adicional = this.adicionalRepository.save(adicional);
		hotel.addAdicional(adicional);
		this.hotelService.atualizar(hotel);
		return adicional;
	}

	@Override
	public void atualizar(Adicional adicional) {
		criar(adicional);
	}

	@Override
	public void deleteById(String id) {
		Adicional adicional = this.adicionalRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Serviço não existe")  );
		Hotel hotel = this.hotelService.obterPorCodigo(adicional.getHotelId());
		hotel.removeAdicional(adicional);
		this.hotelService.atualizar(hotel);
		this.adicionalRepository.deleteById(id);
	}

	@Override
	public void deleteServicoById(String id) {
		Query query  = new Query( Criteria.where("id").is(id));
		this.mongoTemplate.remove(query, Adicional.class);
	}

}
