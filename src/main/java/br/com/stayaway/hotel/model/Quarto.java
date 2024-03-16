package br.com.stayaway.hotel.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    @Id
    private String id;
    private String tipo;
    private Integer quantidade;
    private String totalPessoas;
    private Hotel hotel;
}