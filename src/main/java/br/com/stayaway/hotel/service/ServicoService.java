package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Servico;

public interface ServicoService {

	public List<Servico> buscarTodos();
	public Servico obterPorCodigo(String id);
	public Servico criar(Servico servico);
	public void atualizar(Servico servico);
	public void deleteById(String id);
	public void deleteServicoById(String id);
}
