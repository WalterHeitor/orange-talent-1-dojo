package br.com.zup.nossositedeviagens.rota;

import br.com.zup.nossositedeviagens.aeroporto.Aeroporto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Aeroporto aeroportoOrigem;

    private Aeroporto aeroportoDestino;

    private LocalDateTime duracao;

    @Deprecated
    public Rota(){}

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, LocalDateTime duracao) {
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
    }
}
