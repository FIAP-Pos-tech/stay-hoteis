package br.com.stayaway.hotel.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    @Id
    private String id;
    private String idPredio;
    private String idHotel;
    private String tipo;
    private String totalPessoas;
    private Hotel hotel;
}