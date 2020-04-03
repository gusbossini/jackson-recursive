
package br.com.example.jacksonrecursive.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class EfetividadeGrupo {

    @Id
    @GeneratedValue
    private Long codigo;

    private String nomeGrupo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("efetividadeGrupo")
    private Versao versao;

}