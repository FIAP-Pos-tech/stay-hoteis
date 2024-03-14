package br.com.stayaway.hotel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.Item;
import br.com.stayaway.hotel.repository.ItemRepository;
import br.com.stayaway.hotel.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	//Mongo Template
	private final MongoTemplate mongoTemplate;
				
	public ItemServiceImpl(MongoTemplate mongoTemplate) {
			super();
			this.mongoTemplate = mongoTemplate;
	}
		
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public List<Item> buscarTodos() {
		return this.itemRepository.findAll();
	}

	@Override
	public Item obterPorCodigo(String id) {
		return this.itemRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Item não existe")  );
	}

	@Override
	public Item criar(Item item) {
		return this.itemRepository.save(item);
	}

	@Override
	public void atualizar(Item item) {
		this.itemRepository.save(item);
	}

	@Override
	public void deleteById(String id) {
		this.itemRepository.deleteById(id);
	}

	@Override
	public void deleteItemById(String id) {
		Query query  = new Query( Criteria.where("id").is(id));
		this.mongoTemplate.remove(query, Item.class);
	}

}
