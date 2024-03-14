package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Hotel;



public interface HotelService {

	public List<Hotel> buscarTodos();
	public Hotel obterPorCodigo(String id);
	public Hotel criar(Hotel hotel);
	public void deleteHotelById(String id);
	public void atualizar(Hotel hotel);
	public void deleteById(String id);

}