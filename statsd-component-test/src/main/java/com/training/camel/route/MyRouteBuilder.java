package com.training.camel.route;


import com.training.camel.schedule.Event;
import com.training.camel.schedule.EventCreateProcessor;
import com.training.camel.schedule.EventProcessor;
import com.training.camel.schedule.EventRepository;
import com.training.camel.schedule.EventType;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Predicate;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends SpringRouteBuilder {

    @Value("${quartz.cron}")

    private String cronExpression;

    @Override
    public void configure() throws Exception {
        /*SimpleScheduledRoutePolicy policy = new SimpleScheduledRoutePolicy();
        long startTime = System.currentTimeMillis() + 5000L;
        policy.setRouteStartDate(new Date(startTime));
        policy.setRouteStartRepeatCount(2);
        policy.setRouteStartRepeatInterval(3000);*/
        //CronScheduledRoutePolicy startPolicy = new CronScheduledRoutePolicy();
        fromF("quartz://myTimer?cron=%s", cronExpression)
            .routeId("test")

                //.routePolicy(policy)
            .bean(EventRepository.class, "getLastEvents(ONE, 100)")
            .split().body()
            .choice()
            .when(new Predicate() {
                @Override
                public boolean matches(Exchange exchange) {
                    Message message = exchange.getIn();
                    Event event = (Event) message.getBody();
                    return event.getEventType().equals(EventType.CREATED);
                }
            })
            .bean(EventCreateProcessor.class, "process")
            .when(new Predicate() {
                @Override
                public boolean matches(Exchange exchange) {
                    Message message = exchange.getIn();
                    Event event = (Event) message.getBody();
                    return event.getEventType().equals(EventType.CHANGED);
                }
            }).to("direct:crePro");

        from("direct:crePro").bean(EventProcessor.class, "process");
        //from("bean:eventRepository?method=getLastEvent").routeId("test").routePolicy(policy).bean(EventProcessor.class, "process").setExchangePattern(ExchangePattern.InOnly);
        //from("direct:event").bean(EventRepository.class, "getLastEvent");
    }
}
