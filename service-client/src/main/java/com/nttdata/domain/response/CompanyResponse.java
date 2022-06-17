package com.nttdata.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private String id;
    /**
     * Nombre de la empresa o de la persona
     */
    String name;
    private String ruc;
    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;
}
