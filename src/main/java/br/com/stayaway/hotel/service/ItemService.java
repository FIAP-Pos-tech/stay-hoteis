package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Item;

public interface ItemService {

	public List<Item> buscarTodos();
	public Item obterPorCodigo(String id);
	public Item criar(Item item);
	public void atualizar(Item item);
	public void deleteById(String id);
	public void deleteItemById(String id);
	
}
