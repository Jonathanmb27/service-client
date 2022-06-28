package com.nttdata.service.impl;

import com.nttdata.domain.dao.ClientYanqui;
import com.nttdata.domain.response.ClientYanquiResponse;
import com.nttdata.repository.ClientYanquiRepository;
import com.nttdata.service.ClientYanquiService;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientYanquiServiceImpl implements ClientYanquiService {

    private final ClientYanquiRepository clientYanquiRepository;
    public ClientYanquiServiceImpl(ClientYanquiRepository clientYanquiRepository){
        this.clientYanquiRepository=clientYanquiRepository;
    }
    @Override
    public ClientYanqui create(ClientYanqui clientYanqui) {
        return clientYanquiRepository.save(clientYanqui);
    }

    @CachePut(value = "yanquiCache")
    @Override
    public ClientYanqui update(ClientYanqui clientYanqui) {
        return null;
    }

    @Cacheable(value = "yanquiCache", key = "#clientYanqui.id")
    @Override
    public List<ClientYanqui> findAll() {
        return clientYanquiRepository.findAll();
    }

    @CacheEvict(value = "yanquiCache")
    @Override
    public Optional<ClientYanqui> delete(ClientYanqui clientYanqui) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientYanquiResponse> findYanquiByDni(Long dni) {
        Optional<ClientYanqui> yanqui=clientYanquiRepository
                .findAll()
                .stream()
                .filter(s->s.getDni().equals(dni)).findFirst();

        ClientYanquiResponse clientYanquiResponse=new ClientYanquiResponse();
        if(yanqui.isPresent()){

            clientYanquiResponse.setExist(true);
        }else clientYanquiResponse.setExist(false);
        return Optional.of(clientYanquiResponse);
    }
}
