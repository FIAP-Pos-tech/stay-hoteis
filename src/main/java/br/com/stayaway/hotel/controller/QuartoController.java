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

import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.service.QuartoService;

@RestController
@RequestMapping(value ="/quarto")
public class QuartoController {

	
	@Autowired
	private QuartoService  quartoService ;
	
	@GetMapping
	public List<Quarto> obterTodos(){
		return this.quartoService.buscarTodos();
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam("Id") String id) {
		this.quartoService.deleteById(id);
	}
	
	@PostMapping
	public Quarto criar(@RequestBody Quarto quarto) {
		return this.quartoService.criar(quarto);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Quarto quarto) {
		this.quartoService.atualizar(quarto);
	}
	
	@GetMapping("/{id}")
	public Quarto obterPorCodigo(@PathVariable String id) {
		return this.quartoService.obterPorCodigo(id);
	}
}
