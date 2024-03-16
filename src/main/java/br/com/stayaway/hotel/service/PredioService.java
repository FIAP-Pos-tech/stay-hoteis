package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Predio;

public interface PredioService {
	List<Predio> buscarTodos();
	Predio obterPorCodigo(String id);
	Predio criar(Predio predio);
	void deletePrediolById(String id);
	void atualizar(Predio predio);
}
