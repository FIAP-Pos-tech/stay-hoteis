package br.com.stayaway.hotel.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "hotel")
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
    private List<Adicional> adicionais;

    @DBRef
    private Predio predio;

    public void addQuarto(Quarto quarto) {
        if (this.quartos == null) {
            this.quartos = new ArrayList<>();
        }
        this.quartos.add(quarto);
    }

    public void addAdicional(Adicional adicional) {
        if (this.adicionais == null) {
            this.adicionais = new ArrayList<>();
        }
        this.adicionais.add(adicional);
    }

    public void removeQuarto(Quarto quarto) {
        if (this.quartos != null) {
            this.quartos.stream()
                    .filter(q -> q.getId().equals(quarto.getId()))
                    .findFirst()
                    .ifPresent(q -> this.quartos.remove(q));
        }
    }

    public void removeAdicional(Adicional adicional) {
        if (this.adicionais != null) {
            this.adicionais.stream()
                    .filter(a -> a.getId().equals(adicional.getId()))
                    .findFirst()
                    .ifPresent(a -> this.adicionais.remove(a));
        }
    }
}
