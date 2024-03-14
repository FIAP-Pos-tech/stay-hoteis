package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Quarto;

public interface QuartoService {

	public List<Quarto> buscarTodos();
	public Quarto obterPorCodigo(String id);
	public Quarto criar(Quarto quarto);
	public void atualizar(Quarto quarto);
	public void deleteById(String id);
	public void deleteQuartoById(String id);
}
