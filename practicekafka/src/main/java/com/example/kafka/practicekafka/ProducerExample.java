package com.example.kafka.practicekafka;

import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class ProducerExample {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for (int i = 1; i <= 5; i++) {
            producer.send(new ProducerRecord<>("test-topic", "key-" + i, "message-" + i));
        }

        producer.close();
        System.out.println("Messages sent successfully!");
    }
}