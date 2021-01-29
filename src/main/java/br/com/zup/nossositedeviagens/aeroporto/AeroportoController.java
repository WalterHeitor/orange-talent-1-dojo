package br.com.zup.nossositedeviagens.aeroporto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AeroportoController {

    @PostMapping("/api/aeroportos")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoAeroportoRequest request){
        request.toModel();
        return ResponseEntity.ok().build();
    }
}
