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

import br.com.stayaway.hotel.model.Predio;
import br.com.stayaway.hotel.service.PredioService;

@RestController
@RequestMapping(value ="/predio")
public class PredioController {

	@Autowired
	private PredioService predioService;
	
	
	@GetMapping
	public List<Predio> obterTodos(){
		return this.predioService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Predio obterPorCodigo(@PathVariable String id) {
		return this.predioService.obterPorCodigo(id);
	}
	
	@PostMapping
	public Predio criar( @RequestBody Predio predio ) {
		return this.predioService.criar(predio);
	}
	
	@DeleteMapping("/delete")
	public void deleteHotelById(@RequestParam("Id") String id) {
		this.predioService.deletePrediolById(id);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Predio predio) {
		this.predioService.atualizar(predio);
	}
	
	
	
	
}
