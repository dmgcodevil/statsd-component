package com.training.camel.statsd;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: dmgcodevil
 * Date: 28.09.13
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class Starter {


    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:spring/camel-context.xml");
       // StatsDSender statsDSender = applicationContext.getBean(StatsDSender.class);
        //statsDSender.doSend("test", 1);


   /*     try {
            synchronized(Starter.class) {
                Starter.class.wait();
            }
        } catch(InterruptedException e) {

        }*/
    }
}
