package com.nttdata.domain.response;

import com.nttdata.domain.dao.util.ProfileType;
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


    private ProfileType profileType;
    /**
     * Guarda la fecha de crecion,
     * del registro
     * */
    private LocalDateTime createdAt;
}
