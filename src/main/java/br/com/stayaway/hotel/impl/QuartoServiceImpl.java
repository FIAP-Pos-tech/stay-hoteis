package br.com.stayaway.hotel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.repository.QuartoRepository;
import br.com.stayaway.hotel.service.QuartoService;

@Service
public class QuartoServiceImpl implements QuartoService {

	//Mongo Template
	private final MongoTemplate mongoTemplate;
		
	public QuartoServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	//Mongo Repository
		@Autowired
		private QuartoRepository quartoRepository;
		
		
		@Override
		public List<Quarto> buscarTodos() {
			return this.quartoRepository.findAll();
		}

		@Override
		public Quarto obterPorCodigo(String id) {
			return this.quartoRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Quarto não existe")  );
		}

		@Override
		public Quarto criar(Quarto quarto) {
			return this.quartoRepository.save(quarto);
		}

	
		@Override
		public void atualizar(Quarto quarto) {
			this.quartoRepository.save(quarto);		
		}

		
		@Override
		public void deleteById(String id) {
			this.quartoRepository.deleteById(id);
		}

		@Override
		public void deleteQuartoById(String id) {
			Query query  = new Query( Criteria.where("id").is(id));
			this.mongoTemplate.remove(query, Quarto.class);
		}

		
}
