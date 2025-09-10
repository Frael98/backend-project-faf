package com.frael.federacion.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    
    private String status;
    private String message;
    private T data;

    // Constructor para respuestas de éxito con datos
    public ApiResponse(T data) {
        this.status = "exito";
        this.message = "Operación realizada con éxito";
        this.data = data;
    }

    // Constructor para respuestas de error
    public ApiResponse(String message) {
        this.status = "error";
        this.message = message;
    }
    
    // Getters
    /* public String getStatus() { return status; }
    public String getMessage() { return message; }
    public T getData() { return data; } */
}
