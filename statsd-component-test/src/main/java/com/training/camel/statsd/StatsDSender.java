package com.training.camel.statsd;


import static java.text.MessageFormat.format;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.StatsDOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StatsDSender {

    public static final String ROUTE_TEMPLATE = "statsd:{0}:{1}?value={2}";
    private ProducerTemplate producerTemplate;

    @Autowired
    public StatsDSender(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void doSend(String statsDKey, int value) {
        producerTemplate.sendBody(createCounterRoute(statsDKey, value), ExchangePattern.InOnly, "");
    }

    private String createCounterRoute(String key, int value) {
        return format(ROUTE_TEMPLATE, StatsDOperation.COUNTER.getName(), key, value);
    }
}
