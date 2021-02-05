package br.com.zup.nossositedeviagens.aeroporto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class AeroportoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/aeroportos")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoAeroportoRequest request){
        Aeroporto aeroporto = request.toModel(entityManager);

        return ResponseEntity.ok(aeroporto.toString());
    }
}
