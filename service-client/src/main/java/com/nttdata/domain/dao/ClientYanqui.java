package com.nttdata.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientYanqui extends Client{
    private Long dni;
    private String email;
    private Long phoneNumber;
    private String phoneImei;
}
