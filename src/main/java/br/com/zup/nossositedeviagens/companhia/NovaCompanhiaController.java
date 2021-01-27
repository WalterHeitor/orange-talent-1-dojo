package br.com.zup.nossositedeviagens.companhia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class NovaCompanhiaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/companhias")
    public ResponseEntity<?> criar(NovaCompanhiaRequest request){
        Companhia companhia = request.toModel(entityManager);
        entityManager.persist(companhia);
        return ResponseEntity.created();
    }

}
