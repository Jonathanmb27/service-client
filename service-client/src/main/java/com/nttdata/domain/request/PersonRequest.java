package com.nttdata.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PersonRequest {

    /**
     * el id solo lo usamos para
     * hace update
     * */
    private String id;
    private String dni;
    private String name;
    private String lastName;

    private int state;

    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;

    /**
     * Registra la modificaion del producto
     * */
    private LocalDateTime modifiedAt;
    public PersonRequest(){
        createdAt=LocalDateTime.now();
        modifiedAt=LocalDateTime.now();
    }

}
