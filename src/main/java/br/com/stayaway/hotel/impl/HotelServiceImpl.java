package br.com.stayaway.hotel.impl;

import br.com.stayaway.hotel.model.domain.Hotel;
import br.com.stayaway.hotel.model.domain.Quarto;
import br.com.stayaway.hotel.repository.AdicionalRepository;
import br.com.stayaway.hotel.repository.HotelRepository;
import br.com.stayaway.hotel.repository.PredioRepository;
import br.com.stayaway.hotel.repository.QuartoRepository;
import br.com.stayaway.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepository;
	private final QuartoRepository quartoRepository;

	private final AdicionalRepository adicionalRepository;
	
	public HotelServiceImpl(HotelRepository hotelRepository,
							QuartoRepository quartoRepository,
							AdicionalRepository adicionalRepository) {
        this.hotelRepository = hotelRepository;
        this.quartoRepository = quartoRepository;
        this.adicionalRepository = adicionalRepository;
    }
	
	@Override
	public List<Hotel> buscarTodos() {
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel obterPorCodigo(String id) {
		return this.hotelRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException(" Hotel não existe"));
	}

	@Override
	public Hotel criar(Hotel hotel) {
		return this.hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotelById(String id) {
		Hotel hotel = this.hotelRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" Hotel não existe"));
		hotel.getAdicionais().forEach(adicional -> adicionalRepository.deleteById(adicional.getId()));
		hotel.getQuartos().forEach(quarto -> quartoRepository.deleteById(quarto.getId()));
		hotelRepository.deleteById(id);
	}

	@Override
	public void atualizar(Hotel hotel) {
		this.hotelRepository.save(hotel);	
	}

	@Override
	public List<Hotel> buscarPorCidade(String cidade) {
		return hotelRepository.findByCidade(cidade);
	}

	public List<Quarto> buscarQuartosPorHotel(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));
		return hotel.getQuartos();
	}

}
