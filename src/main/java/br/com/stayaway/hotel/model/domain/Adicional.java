package br.com.stayaway.hotel.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "adicional")
public class Adicional {

    @Id
    private String id;
    private TipoAdicional tipo;
    private Double valor;
    private Integer quantidade;
    private String obs;
    private String hotelId;


}
