package br.com.stayaway.hotel.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

@Document
@Data
public class Hotel {
	
	@Id
	private String id;
	
	private String nome;
	private String endereco;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	@DBRef
	private Predio predio;
	

}
