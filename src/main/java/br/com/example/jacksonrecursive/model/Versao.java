package br.com.example.jacksonrecursive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Versao {

    @Id
    @GeneratedValue
    private Long codigo;

    private String nomeVersao;

    @OneToMany(mappedBy = "versao", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("versao")
    private List<EfetividadeGrupo> efetividadeGrupo;

}
