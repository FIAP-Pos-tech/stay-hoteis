package br.com.stayaway.hotel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdicionalResponse {

    private String id;
    private Integer quantidade;
    private String obs;
    private String valor;

}