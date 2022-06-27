package com.nttdata.events;


import com.nttdata.domain.dao.ClientYanqui;
import com.nttdata.service.ClientYanquiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventHandler {

    private final ClientYanquiService clientYanquiService;
    public EventHandler(ClientYanquiService clientYanquiService){
        this.clientYanquiService=clientYanquiService;
    }
    private final Logger LOGGER= LoggerFactory.getLogger("EventHandler");
    @KafkaListener(topics = "product", containerFactory = "kafkaListenerContainerFactory",groupId = "grupo1")
    public void consumer(Event<?> event){
        if(event.getClass().isAssignableFrom(ProductCreatedEvent.class)){
            ProductCreatedEvent productCreatedEvent=(ProductCreatedEvent)event;
            LOGGER.info("# Received Customer created event .... with Id={}, data={}",
                    productCreatedEvent.getId(),productCreatedEvent.getData());
            ClientYanqui clientYanqui=new ClientYanqui();
            clientYanqui.setDni(productCreatedEvent.getData().getDni());
            clientYanqui.setEmail(productCreatedEvent.getData().getEmail());
            clientYanqui.setPhoneNumber(productCreatedEvent.getData().getPhoneNumber());
            clientYanqui.setPhoneImei(productCreatedEvent.getData().getPhoneImei());
            clientYanquiService.create(clientYanqui);
        }
    }

}
