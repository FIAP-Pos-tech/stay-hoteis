package br.com.stayaway.hotel.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.stayaway.hotel.model.AdicionalResponse;
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

import br.com.stayaway.hotel.model.Adicional;
import br.com.stayaway.hotel.service.AdicionalService;

@RestController
@RequestMapping(value ="/servico")
public class AdicionalController {

	@Autowired
	private AdicionalService adicionalService;

	@PostMapping("/lista")
	public List<AdicionalResponse> obterPorListaIdEQuantidade(@RequestBody List<Adicional> lista) {
		List<AdicionalResponse> respostas = new ArrayList<>();
		for (Adicional request : lista) {
			Adicional adicional = this.adicionalService.obterPorCodigo(request.getId());
			respostas.add(new AdicionalResponse(adicional.getId(), request.getQuantidade(),
					adicional.getObs(), adicional.getValor()));
		}
		return respostas;
	}

	@GetMapping
	public List<Adicional> obterTodos(){
		return this.adicionalService.buscarTodos();
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam("Id") String id) {
		this.adicionalService.deleteById(id);
	}
	
	@PostMapping
	public Adicional criar(@RequestBody Adicional adicional) {
		return this.adicionalService.criar(adicional);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Adicional adicional) {
		this.adicionalService.atualizar(adicional);
	}
	
	@GetMapping("/{id}")
	public Adicional obterPorCodigo(@PathVariable String id) {
		return this.adicionalService.obterPorCodigo(id);
	}

}
