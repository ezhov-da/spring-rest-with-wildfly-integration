package ru.ezhov.document.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
@ComponentScan("example.jms")
public class Config {

//    @Bean
//    public ActiveMQConnectionFactory connectionFactory(){
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        return connectionFactory;
//    }

//    @Bean
//    @Autowired
//    public DefaultMessageListenerContainer listenerContainer(SimpleMessageListener messageListener){
//        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setDestinationName("prospring4");
//        container.setMessageListener(messageListener);
//        return container;
//    }

    @Bean
    @Autowired
    public DefaultMessageListenerContainer listenerContainer(@Autowired ConnectionFactory connectionFactory, SimpleMessageListener messageListener) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestinationName("testQueue");
        container.setMessageListener(messageListener);
        return container;
    }

    @Bean
    public JmsTemplate jmsTemplate(@Autowired ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
//        jmsTemplate.setDefaultDestinationName("prospring4");
        return jmsTemplate;
    }
}