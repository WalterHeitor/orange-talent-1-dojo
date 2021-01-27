package br.com.zup.nossositedeviagens.paises;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    private String nome;

    public NovoPaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
