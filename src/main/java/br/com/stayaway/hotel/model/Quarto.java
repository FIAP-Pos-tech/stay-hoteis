package br.com.stayaway.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Quarto {

	@Id
	 private String id;
	 private String idPredio;
	 private String idHotel;
	 private String tipo;
	 private String totalPessoas;
	
	
}
