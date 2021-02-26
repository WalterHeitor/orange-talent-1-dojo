package br.com.zup.nossositedeviagens.rota;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.zup.nossositedeviagens.validation.RotasIguaisValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.nossositedeviagens.validation.RotaUnicaValidator;

@RestController
public class RotaController {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private RotaUnicaValidator rotaUnicaValidator;

    @Autowired
    private RotasIguaisValidador rotasIguaisValidador;
    
    @InitBinder
    public void init(WebDataBinder bind) {
    	bind.addValidators(rotaUnicaValidator, rotasIguaisValidador);
    }

    @PostMapping("/api/rota")
    @Transactional
    public ResponseEntity<?> criarRota(@RequestBody @Valid NovaRotaFormRequest request,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Rota rota = request.toModel(entityManager);
        

        entityManager.persist(rota);

        URI location = uriComponentsBuilder.path("/api/rota/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }
}
