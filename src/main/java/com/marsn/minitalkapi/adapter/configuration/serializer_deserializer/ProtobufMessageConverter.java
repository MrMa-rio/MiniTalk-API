package com.marsn.minitalkapi.adapter.configuration.serializer_deserializer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;

import java.lang.reflect.Method;

public class ProtobufMessageConverter implements MessageConverter {

    private final Class<? extends Message> messageType;

    public ProtobufMessageConverter(Class<? extends Message> messageType) {
        this.messageType = messageType;
    }

    @Override
    public Message toMessage(Object object, MessageProperties messageProperties) throws MessageConversionException {
        if (!(object instanceof com.google.protobuf.Message proto)) {
            throw new MessageConversionException("Objeto não é um Protobuf Message válido");
        }
        byte[] bytes = proto.toByteArray();
        messageProperties.setContentType("application/x-protobuf");
        return new Message(bytes, messageProperties);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        try {
            Method parseMethod = messageType.getMethod("parseFrom", byte[].class);
            return parseMethod.invoke(null, message.getBody());
        } catch (Exception e) {
            throw new MessageConversionException("Erro ao desserializar Protobuf", e);
        }
    }
}
