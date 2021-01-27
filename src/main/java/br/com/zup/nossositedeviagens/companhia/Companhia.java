package br.com.zup.nossositedeviagens.companhia;

import br.com.zup.nossositedeviagens.paises.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private LocalDateTime instanteCriacao;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Companhia(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
        this.instanteCriacao = LocalDateTime.now();
    }
}
