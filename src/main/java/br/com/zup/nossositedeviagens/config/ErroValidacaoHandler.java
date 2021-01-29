package br.com.zup.nossositedeviagens.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException error){
        List<ErroDeFormularioDto> erros = new ArrayList<>();
        List<FieldError> fieldErrors = error.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError -> {
            String mensagem = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto(fieldError.getField(),fieldError.getDefaultMessage());
            erros.add(erroDeFormularioDto);
        });

        return erros;
    }
}
