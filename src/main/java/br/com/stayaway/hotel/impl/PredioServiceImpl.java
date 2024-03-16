package br.com.stayaway.hotel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.domain.Predio;
import br.com.stayaway.hotel.repository.PredioRepository;
import br.com.stayaway.hotel.service.PredioService;

@Service
public class PredioServiceImpl implements PredioService {

	//Mongo Template
	private final MongoTemplate mongoTemplate;
		
	public PredioServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private PredioRepository predioRepository;
	
	@Override
	public List<Predio> buscarTodos() {
		return this.predioRepository.findAll();
	}

	@Override
	public Predio obterPorCodigo(String id) {
		return this.predioRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Predio não existe")  );
	}

	@Override
	public Predio criar(Predio predio) {
		return this.predioRepository.save(predio);
	}

	@Override
	public void deletePrediolById(String id) {
		Query query  = new Query( Criteria.where("id").is(id));
		this.mongoTemplate.remove(query,Predio.class);
		
	}
	@Override
	public void atualizar(Predio predio) {
		this.predioRepository.save(predio);	
	}
}