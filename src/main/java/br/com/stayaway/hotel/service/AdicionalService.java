package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Adicional;

public interface AdicionalService {

	public List<Adicional> buscarTodos();
	public Adicional obterPorCodigo(String id);
	public Adicional criar(Adicional adicional);
	public void atualizar(Adicional adicional);
	public void deleteById(String id);
	public void deleteServicoById(String id);
}
