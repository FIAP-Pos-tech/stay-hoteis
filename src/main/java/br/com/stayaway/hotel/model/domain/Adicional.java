package br.com.stayaway.hotel.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adicional {

	@Id
	private String id;
	private TipoAdicional tipo;
	private Double valor;
	private Integer quantidade;
	private String obs;
	
	
}
