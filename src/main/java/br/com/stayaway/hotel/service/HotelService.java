package br.com.stayaway.hotel.service;

import java.util.List;

import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.model.Quarto;


public interface HotelService {

	List<Hotel> buscarTodos();
	Hotel obterPorCodigo(String id);
	Hotel criar(Hotel hotel);
	void deleteHotelById(String id);
	void atualizar(Hotel hotel);
	List<Hotel> buscarPorCidade(String cidade);
	List<Quarto> buscarQuartosPorHotel(String hotelId);


}