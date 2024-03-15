package br.com.stayaway.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	private List<Quarto> quartos;
	
	@DBRef
	private Predio predio;


}
