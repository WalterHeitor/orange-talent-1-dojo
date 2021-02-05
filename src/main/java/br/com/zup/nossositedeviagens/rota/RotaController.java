package br.com.zup.nossositedeviagens.rota;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class RotaController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/api/rota")
    @Transactional
    public ResponseEntity<?> criarRota(@RequestBody @Valid NovaRotaFormRequest request,
                                       UriComponentsBuilder uriComponentsBuilder){
    //Rota rota = request.toModel();
    return ResponseEntity.ok().body(request);

    }
}
