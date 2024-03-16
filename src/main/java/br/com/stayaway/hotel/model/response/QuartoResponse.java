package br.com.stayaway.hotel.model.response;


import br.com.stayaway.hotel.model.domain.Hotel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuartoResponse {

    private String id;
    private String tipo;
    private Integer quantidade;
    private String totalPessoas;


}
