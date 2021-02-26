package br.com.zup.nossositedeviagens.rota;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.zup.nossositedeviagens.aeroporto.Aeroporto;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @NotNull
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    @NotNull
    private Aeroporto aeroportoDestino;

    private LocalDateTime duracao;

    private boolean rotaUnica = false;

    @Deprecated
    public Rota(){}

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, LocalDateTime duracao) {
        if (nome == null) {
            this.nome = aeroportoOrigem.getNome() +"-" + aeroportoDestino.getNome();
        }
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public LocalDateTime getDuracao() {
        return duracao;
    }

    public boolean isRotaUnica() {
        return rotaUnica;
    }

    public void setRotaUnica() {
        this.rotaUnica = true;
    }
}
