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

import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.service.HotelService;



@RestController
@RequestMapping(value ="/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	
	@GetMapping
	public List<Hotel> obterTodos(){
		return this.hotelService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public Hotel obterPorCodigo(@PathVariable String id) {
		return this.hotelService.obterPorCodigo(id);
	}
	
	@PostMapping
	public Hotel criar( @RequestBody Hotel hotel ) {
		
		System.out.println("HOTEL "+ hotel.getNome());
		
		
		return this.hotelService.criar(hotel);
	}
	
	@DeleteMapping("/delete")
	public void deleteHotelById(@RequestParam("Id") String id) {
		this.hotelService.deleteHotelById(id);
	}
	
	@PutMapping
	public void atualizar(@RequestBody Hotel hotel) {
		this.hotelService.atualizar(hotel);
	}
}
