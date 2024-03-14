package br.com.stayaway.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Servico {

	@Id
	private String id;
	private String tipo;
	private String valor;
	private String obs;
	
	
}
