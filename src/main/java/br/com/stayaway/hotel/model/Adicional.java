package br.com.stayaway.hotel.model;

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
	private tipoAdicional tipo;
	private String valor;
	private Integer quantidade;
	private String obs;
	
	
}
