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

import br.com.stayaway.hotel.model.Item;
import br.com.stayaway.hotel.service.ItemService;

@RestController
@RequestMapping(value ="/item")
public class ItemController {

	@Autowired
	private ItemService  itemService ;
	
	@GetMapping
	public List<Item> obterTodos(){
		return this.itemService.buscarTodos();
	}
	
	@DeleteMapping("/delete")
	public void deleteById(@RequestParam("Id") String id) {
		this.itemService.deleteById(id);
	}
	
	@PostMapping
	public Item criar(@RequestBody Item item) {
		return this.itemService.criar(item);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Item item) {
		this.itemService.atualizar(item);
	}
	
	@GetMapping("/{id}")
	public Item obterPorCodigo(@PathVariable String id) {
		return this.itemService.obterPorCodigo(id);
	}
}
