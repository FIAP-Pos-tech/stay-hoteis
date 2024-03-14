package br.com.stayaway.hotel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Predio {
	
	@Id
	public String id;
	
	public String nomePredio;
	public String idHotel;
	public String idQuarto;

}	
