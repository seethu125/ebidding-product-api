package com.casestudy.eauction.configurations.activemq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.topic}")
    private String topic;

    public void sendMessage(Object message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
           log.error("Recieved Exception during send Message: ", e);
        }
    }
}
