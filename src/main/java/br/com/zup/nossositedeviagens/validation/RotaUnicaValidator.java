package br.com.zup.nossositedeviagens.validation;

import br.com.zup.nossositedeviagens.rota.NovaRotaFormRequest;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class RotaUnicaValidator implements Validator {

    @PersistenceContext
    EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaRotaFormRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	Query query = manager.createQuery("select 1 from Rota where aeroportoOrigem = :origem and aeroportoDestino = :destino");
    	query.setParameter("origem", null);
    	query.setParameter("destino", null);
    	List<?> lista = query.getResultList();
    	Assert.state(lista.size() <= 1, "Já existe uma rota com essa origem e destino");
    	return lista.isEmpty();
    }
}
