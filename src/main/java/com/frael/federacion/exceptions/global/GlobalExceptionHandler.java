package com.frael.federacion.exceptions.global;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.frael.federacion.controllers.ArbitroController;
import com.frael.federacion.exceptions.UserException;
import com.frael.federacion.model.ApiResponse;

@RestControllerAdvice(basePackageClasses = ArbitroController.class)
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones si no se envian los parametros
     * obligatorios
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    /**
     * Implementacion de prueba respuesta personalizada con
     * clase ApiResponse
     * @param ex
     * @return ApiResponse
     */
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiResponse<?>> handlerExceptionArbitro(UserException ex) {
        ApiResponse<?> response = new ApiResponse<>(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
