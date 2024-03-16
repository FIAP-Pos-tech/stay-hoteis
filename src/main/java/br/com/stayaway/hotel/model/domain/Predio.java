package br.com.stayaway.hotel.model.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "predio")
public class Predio {
	
	@Id
	public String id;
	
	public String nomePredio;
	public String idHotel;
	public String idQuarto;

}	
