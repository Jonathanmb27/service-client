package com.nttdata.service;

import com.nttdata.domain.dao.ClientYanqui;
import com.nttdata.domain.response.ClientYanquiResponse;

import java.util.Optional;

public interface ClientYanquiService extends AbstractService<ClientYanqui>{


       Optional<ClientYanquiResponse> findYanquiByDni(Long dni);
}
