package com.nttdata.domain.dao;

import com.nttdata.domain.dao.util.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document
public class Client {
    @Id
    private String id;

    /**
     * Nombre de la empresa o de la persona
     */
    private String name;

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

    /**
     * Funcionalidad agregada para
     * para el proyecto II
     * VIP
     * PYME
     * */
    private ProfileType profileType;


    public Client(){
        createdAt=LocalDateTime.now();
        modifiedAt=LocalDateTime.now();
        state=1;
    }


}
