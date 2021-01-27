package br.com.zup.nossositedeviagens.paises;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NovoPaisController {

    @PostMapping("/api/paises")
    public ResponseEntity<?> criar(@RequestBody @Valid NovoPaisRequest request,
                                   UriComponentsBuilder uriBuilder) {

        Pais pais = request.paraPais();

        URI location = uriBuilder.path("/api/paises")
                                 .buildAndExpand(3)
                                 .toUri();

        return ResponseEntity.created(location)
                             .build();
    }
}
