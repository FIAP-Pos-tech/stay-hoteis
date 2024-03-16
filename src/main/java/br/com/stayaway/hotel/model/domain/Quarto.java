package br.com.stayaway.hotel.model.domain;

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
    private String tipo;
    private Integer quantidade;
    private String totalPessoas;
    private String hotelId;

}