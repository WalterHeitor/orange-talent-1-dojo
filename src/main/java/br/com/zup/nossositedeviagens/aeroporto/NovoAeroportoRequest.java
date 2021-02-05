package br.com.zup.nossositedeviagens.aeroporto;

import br.com.zup.nossositedeviagens.paises.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoAeroportoRequest {

    @NotBlank
    private String nome;

    @NotNull
    private Long idPais;

    public NovoAeroportoRequest(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Aeroporto toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        return new Aeroporto(this.nome, pais);
    }
}
