package br.com.stayaway.br.com.stayaway.hotel.service;

import br.com.stayaway.hotel.impl.HotelServiceImpl;
import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.model.Predio;
import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.repository.HotelRepository;
import br.com.stayaway.hotel.repository.PredioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HotelServiceImplTest {

    @InjectMocks
    private HotelServiceImpl hotelService;

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private PredioRepository predioRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarTodos() {
        Hotel hotel1 = new Hotel();
        Hotel hotel2 = new Hotel();
        when(hotelRepository.findAll()).thenReturn(Arrays.asList(hotel1, hotel2));

        List<Hotel> result = hotelService.buscarTodos();

        assertEquals(2, result.size());
        verify(hotelRepository, times(1)).findAll();
    }

    @Test
    public void testObterPorCodigo() {
        Hotel hotel = new Hotel();
        when(hotelRepository.findById("123")).thenReturn(Optional.of(hotel));

        Hotel result = hotelService.obterPorCodigo("123");

        assertEquals(hotel, result);
        verify(hotelRepository, times(1)).findById("123");
    }

    @Test
    public void testCriar() {
        Hotel hotel = new Hotel();
        Predio predio = new Predio();
        predio.setId("123");
        hotel.setPredio(predio);
        when(predioRepository.findById("123")).thenReturn(Optional.of(predio));
        when(hotelRepository.save(any(Hotel.class))).thenReturn(hotel);

        Hotel result = hotelService.criar(hotel);

        assertEquals(hotel, result);
        verify(predioRepository, times(1)).findById("123");
        verify(hotelRepository, times(1)).save(any(Hotel.class));
    }

    @Test
    public void testDeleteHotelById() {
        doNothing().when(mongoTemplate).remove(any(Query.class), eq(Hotel.class));

        hotelService.deleteHotelById("123");

        verify(mongoTemplate, times(1)).remove(any(Query.class), eq(Hotel.class));
    }

    @Test
    public void testAtualizar() {
        Hotel hotel = new Hotel();
        when(hotelRepository.save(any(Hotel.class))).thenReturn(hotel);

        hotelService.atualizar(hotel);

        verify(hotelRepository, times(1)).save(any(Hotel.class));
    }

    @Test
    public void testBuscarPorCidade() {
        Hotel hotel = new Hotel();
        when(hotelRepository.findByCidade("TestCity")).thenReturn(Arrays.asList(hotel));

        List<Hotel> result = hotelService.buscarPorCidade("TestCity");

        assertEquals(1, result.size());
        verify(hotelRepository, times(1)).findByCidade("TestCity");
    }

    @Test
    public void testBuscarQuartosPorHotel() {
        Hotel hotel = new Hotel();
        Quarto quarto = new Quarto();
        hotel.setQuartos(List.of(quarto));
        when(hotelRepository.findById("123")).thenReturn(Optional.of(hotel));

        List<Quarto> result = hotelService.buscarQuartosPorHotel("123");

        assertEquals(1, result.size());
        verify(hotelRepository, times(1)).findById("123");
    }
}