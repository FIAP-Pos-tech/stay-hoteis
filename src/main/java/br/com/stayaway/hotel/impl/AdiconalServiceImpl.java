package br.com.stayaway.hotel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.domain.Adicional;
import br.com.stayaway.hotel.repository.AdicionalRepository;
import br.com.stayaway.hotel.service.AdicionalService;

@Service
public class AdiconalServiceImpl implements AdicionalService {

	
	//Mongo Template
	private final MongoTemplate mongoTemplate;
			
	public AdiconalServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private AdicionalRepository adicionalRepository;
	
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
		return this.adicionalRepository.save(adicional);
	}

	@Override
	public void atualizar(Adicional adicional) {
	    this.adicionalRepository.save(adicional);
	}

	@Override
	public void deleteById(String id) {
		this.adicionalRepository.deleteById(id);
	}

	@Override
	public void deleteServicoById(String id) {
		Query query  = new Query( Criteria.where("id").is(id));
		this.mongoTemplate.remove(query, Adicional.class);
	}

}
