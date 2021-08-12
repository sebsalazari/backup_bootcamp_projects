package com.meli.obtenerdiploma.exception;


import com.meli.obtenerdiploma.model.ErrorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ObtenerDiplomaException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}