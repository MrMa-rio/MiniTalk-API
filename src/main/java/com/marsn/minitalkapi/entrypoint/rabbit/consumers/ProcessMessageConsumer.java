package com.marsn.minitalkapi.entrypoint.rabbit.consumers;

import com.marsn.minitalkapi.adapter.service.processMessage.ProcessMessageAdapter;
import com.marsn.minitalkapi.core.model.rabbit.QueueKey;
import com.marsn.minitalkapi.core.model.rabbit.RoutingKey;
import com.marsn.minitalkapi.core.model.shared.enums.TypeQueues;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Component;

@Component
public class ProcessMessageConsumer {

    private final ProcessMessageAdapter adapter;

    private final RabbitAdmin rabbitAdmin;
    private final ConnectionFactory connectionFactory;

    public ProcessMessageConsumer(ProcessMessageAdapter adapter, RabbitAdmin rabbitAdmin, ConnectionFactory connectionFactory) {
        this.adapter = adapter;
        this.rabbitAdmin = rabbitAdmin;
        this.connectionFactory = connectionFactory;
    }

    public void subscribeToQueue(QueueKey queueName, TopicExchange exchange, RoutingKey routingKey) {

        // Cria fila se não existir
        Queue queue = new Queue(queueName.toName(), false, true, true);
        rabbitAdmin.declareQueue(queue);

        // Faz o bind da fila à routing key específica
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(routingKey.toRoute()));

        // Inicia listener para a fila
//        startListener(queueName);
    }
}