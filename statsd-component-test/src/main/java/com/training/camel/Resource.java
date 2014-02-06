package com.training.camel;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Resource {

    @Autowired
    private org.apache.camel.CamelContext camelContext;

    //@Autowired
    //private MyProxySender myProxySender;
    @Autowired
    private ProducerTemplate producerTemplate;

    public void doPost(String json) {
       // producerTemplate.sendBody("direct:start", "");
       // myProxySender.send(json);
       /* try {
            camelContext.startRoute("eventRoute");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
