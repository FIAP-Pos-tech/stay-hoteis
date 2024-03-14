package br.com.stayaway.hotel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.Servico;
import br.com.stayaway.hotel.repository.ServicoRepository;
import br.com.stayaway.hotel.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

	
	//Mongo Template
	private final MongoTemplate mongoTemplate;
			
	public ServicoServiceImpl(MongoTemplate mongoTemplate) {
		super();
		this.mongoTemplate = mongoTemplate;
	}
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Override
	public List<Servico> buscarTodos() {
		return this.servicoRepository.findAll();
	}

	@Override
	public Servico obterPorCodigo(String id) {
		return this.servicoRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Serviço não existe")  );
	}

	@Override
	public Servico criar(Servico servico) {
		return this.servicoRepository.save(servico);
	}

	@Override
	public void atualizar(Servico servico) {
	    this.servicoRepository.save(servico);
	}

	@Override
	public void deleteById(String id) {
		this.servicoRepository.deleteById(id);
	}

	@Override
	public void deleteServicoById(String id) {
		Query query  = new Query( Criteria.where("id").is(id));
		this.mongoTemplate.remove(query, Servico.class);
	}

}
