package com.example.application.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class MessageDeSerializer implements Deserializer<Message> {
    ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Override
    public Message deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, Message.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
