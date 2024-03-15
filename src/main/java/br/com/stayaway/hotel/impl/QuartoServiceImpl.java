package br.com.stayaway.hotel.impl;

import java.util.List;

import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.repository.QuartoRepository;
import br.com.stayaway.hotel.service.QuartoService;

@Service
public class QuartoServiceImpl implements QuartoService {

	@Autowired
    private final MongoTemplate mongoTemplate;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private QuartoRepository quartoRepository;

	public QuartoServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

    @Override
    public List<Quarto> buscarTodos() {
        return this.quartoRepository.findAll();
    }

    @Override
    public Quarto obterPorCodigo(String id) {
        return this.quartoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(" Quarto não existe"));
    }

    @Override
    public Quarto criar(Quarto quarto, String hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("Hotel não encontrado!"));
        quarto.setHotel(hotel);
        return this.quartoRepository.save(quarto);
    }

    @Override
    public void atualizar(Quarto quarto) {
        this.quartoRepository.save(quarto);
    }


    @Override
    public void deleteById(String id) {
        this.quartoRepository.deleteById(id);
    }

    @Override
    public void deleteQuartoById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        this.mongoTemplate.remove(query, Quarto.class);
    }


}
