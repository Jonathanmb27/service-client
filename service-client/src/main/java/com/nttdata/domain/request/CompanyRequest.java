package com.nttdata.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    /**
     * Nombre de la empresa o de la persona
     */
    private String id;
    private String name;
    private String ruc;
    private int state;


}
