package br.com.stayaway.hotel.model.request;

import br.com.stayaway.hotel.model.domain.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuartoRequest {

    private String id;
    private String tipo;
    private Integer quantidade;
    private String totalPessoas;
    private Hotel hotel;


}
