package com.nttdata.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    private String id;
    private String dni;
    private String name;
    private String lastName;
    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;

    /**
     * Registra la modificaion del producto
     * */
    private LocalDateTime modifiedAt;
    /**
     * 0: inactivo
     * 1: activo
     * */
    private int state;
}
