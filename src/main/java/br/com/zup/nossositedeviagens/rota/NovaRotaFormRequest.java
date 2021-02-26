package br.com.zup.nossositedeviagens.rota;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import br.com.zup.nossositedeviagens.aeroporto.Aeroporto;

public class NovaRotaFormRequest {

	private String nome;
	
	@NotNull
	private Long idAeroportoOrigem;
	
	@NotNull
	private Long idAeroportoDestino;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDateTime duracao;

	public NovaRotaFormRequest(String nome, @NotNull Long idAeroportoOrigem, @NotNull Long idAeroportoDestino, @NotNull LocalDateTime duracao) {
		this.nome = nome;
		this.idAeroportoOrigem = idAeroportoOrigem;
		this.idAeroportoDestino = idAeroportoDestino;
		this.duracao = duracao;
	}

	public Rota toModel(EntityManager manager) {
		Aeroporto aeroportoOrigem = manager.find(Aeroporto.class, idAeroportoOrigem);
		Aeroporto aeroportoDestino = manager.find(Aeroporto.class, idAeroportoDestino);
		return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);
	}

	public String getNome() {
		return nome;
	}

	public Long getIdAeroportoOrigem() {
		return idAeroportoOrigem;
	}

	public Long getIdAeroportoDestino() {
		return idAeroportoDestino;
	}

	public LocalDateTime getDuracao() {
		return duracao;
	}
}
