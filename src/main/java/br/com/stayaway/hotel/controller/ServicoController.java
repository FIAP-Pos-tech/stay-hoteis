package br.com.stayaway.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.stayaway.hotel.model.Servico;
import br.com.stayaway.hotel.service.ServicoService;

@RestController
@RequestMapping(value ="/servico")
public class ServicoController {

	@Autowired
	private ServicoService  servicoService ;
	
	@GetMapping
	public List<Servico> obterTodos(){
		return this.servicoService.buscarTodos();
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam("Id") String id) {
		this.servicoService.deleteById(id);
	}
	
	@PostMapping
	public Servico criar(@RequestBody Servico servico) {
		return this.servicoService.criar(servico);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Servico servico) {
		this.servicoService.atualizar(servico);
	}
	
	@GetMapping("/{id}")
	public Servico obterPorCodigo(@PathVariable String id) {
		return this.servicoService.obterPorCodigo(id);
	}
	
	
	
}
