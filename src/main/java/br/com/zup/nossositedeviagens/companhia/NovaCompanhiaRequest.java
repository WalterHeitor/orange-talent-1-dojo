package br.com.zup.nossositedeviagens.companhia;

import br.com.zup.nossositedeviagens.paises.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompanhiaRequest {

    @NotBlank
    private String nome;
    @NotNull
    private Long idPais;

    public Companhia toModel(EntityManager entityManager){
        Pais pais = entityManager.find(Pais.class, idPais);
        return new Companhia(nome, pais);
    }


}
