package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Predio;

public interface PrediolService {
	public List<Predio> buscarTodos();
	public Predio obterPorCodigo(String id);
	public Predio criar(Predio predio);
	public void deletePrediolById(String id);
	public void atualizar(Predio predio);
}
