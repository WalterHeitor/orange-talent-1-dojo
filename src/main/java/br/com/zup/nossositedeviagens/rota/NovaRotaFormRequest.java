package br.com.zup.nossositedeviagens.rota;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import br.com.zup.nossositedeviagens.aeroporto.Aeroporto;

public class NovaRotaFormRequest {

	private String nome;
	
	@NotNull
	private Long idAeroportoOrigem;
	
	@NotNull
	private Long idAeroportoDestino;
	
	@NotNull
	private LocalDateTime duracao;

	public Rota toModel(EntityManager manager) {
		Aeroporto aeroportoOrigem = manager.find(Aeroporto.class, idAeroportoOrigem);
		Aeroporto aeroportoDestino = manager.find(Aeroporto.class, idAeroportoDestino);
		return new Rota(nome, aeroportoOrigem, aeroportoDestino, duracao);
	}
	
	
}
