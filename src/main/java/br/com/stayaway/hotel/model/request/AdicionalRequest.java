package br.com.stayaway.hotel.model.request;

import br.com.stayaway.hotel.model.domain.TipoAdicional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdicionalRequest {

    private String id;
    private Integer quantidade;

}
