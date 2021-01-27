package br.com.zup.nossositedeviagens.paises;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Deprecated
    public Pais(){

    }

    public Pais(String nome){
        this.nome = nome;
    }
}
