package br.com.stayaway.br.com.stayaway.hotel.service;

import br.com.stayaway.hotel.impl.QuartoServiceImpl;
import br.com.stayaway.hotel.model.Hotel;
import br.com.stayaway.hotel.model.Quarto;
import br.com.stayaway.hotel.repository.HotelRepository;
import br.com.stayaway.hotel.repository.QuartoRepository;
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

public class QuartoServiceImplTest {

    @InjectMocks
    private QuartoServiceImpl quartoService;

    @Mock
    private QuartoRepository quartoRepository;

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarTodos() {
        Quarto quarto1 = new Quarto();
        Quarto quarto2 = new Quarto();
        when(quartoRepository.findAll()).thenReturn(Arrays.asList(quarto1, quarto2));

        List<Quarto> result = quartoService.buscarTodos();

        assertEquals(2, result.size());
        verify(quartoRepository, times(1)).findAll();
    }

    @Test
    public void testObterPorCodigo() {
        Quarto quarto = new Quarto();
        when(quartoRepository.findById("123")).thenReturn(Optional.of(quarto));

        Quarto result = quartoService.obterPorCodigo("123");

        assertEquals(quarto, result);
        verify(quartoRepository, times(1)).findById("123");
    }

    @Test
    public void testCriar() {
        Quarto quarto = new Quarto();
        Hotel hotel = new Hotel();
        hotel.setId("123");
        quarto.setHotel(hotel);
        when(hotelRepository.findById("123")).thenReturn(Optional.of(hotel));
        when(quartoRepository.save(any(Quarto.class))).thenReturn(quarto);

        Quarto result = quartoService.criar(quarto, "123");

        assertEquals(quarto, result);
        verify(hotelRepository, times(1)).findById("123");
        verify(quartoRepository, times(1)).save(any(Quarto.class));
    }

    @Test
    public void testDeleteQuartoById() {
        doNothing().when(mongoTemplate).remove(any(Query.class), eq(Quarto.class));

        quartoService.deleteQuartoById("123");

        verify(mongoTemplate, times(1)).remove(any(Query.class), eq(Quarto.class));
    }

    @Test
    public void testAtualizar() {
        Quarto quarto = new Quarto();
        when(quartoRepository.save(any(Quarto.class))).thenReturn(quarto);

        quartoService.atualizar(quarto);

        verify(quartoRepository, times(1)).save(any(Quarto.class));
    }
}