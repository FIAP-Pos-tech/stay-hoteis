package br.com.stayaway.hotel.controller;


import br.com.stayaway.hotel.model.domain.Quarto;
import br.com.stayaway.hotel.service.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/quarto")
public class QuartoController {


    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public List<Quarto> obterTodos() {
        return this.quartoService.buscarTodos();
    }

    @DeleteMapping
    public void deleteById(@RequestParam("Id") String id) {
        this.quartoService.deleteById(id);
    }

    @PostMapping("/{hotelId}")
    public Quarto criar(@RequestBody Quarto quarto, @PathVariable String hotelId) {
        return this.quartoService.criar(quarto, hotelId);
    }

    @PutMapping
    public void atualizar(@RequestBody Quarto quarto) {
        this.quartoService.atualizar(quarto);
    }

    @GetMapping("/{id}")
    public Quarto obterPorCodigo(@PathVariable String id) {
        return this.quartoService.obterPorCodigo(id);
    }
}
