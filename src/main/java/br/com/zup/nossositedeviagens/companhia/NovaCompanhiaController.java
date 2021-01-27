package br.com.zup.nossositedeviagens.companhia;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;

@RestController
public class NovaCompanhiaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/companhias")
    public ResponseEntity<?> criar(NovaCompanhiaRequest request, UriComponentsBuilder uriBuilder){
        System.out.println();
        Companhia companhia = request.toModel(entityManager);
        entityManager.persist(companhia);
        URI location = uriBuilder.path("/api/companhias").buildAndExpand(3).toUri();
        return ResponseEntity.created(location).build();
    }

}
