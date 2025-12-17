package com.equipo_c24_38.backend.infra.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TipoUsuarioInvalidoException.class)
    public ResponseEntity<String> handleTipoUsuarioInvalidoException(TipoUsuarioInvalidoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NombreMedicoNoEncontradoException.class)
    public ResponseEntity<String> handleTNombreMedicoNoEncontradoException(NombreMedicoNoEncontradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
