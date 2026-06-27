package com.example.kafka.practicekafka;

import java.util.*;

import org.apache.kafka.clients.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerOrders {

	public static void main(String[] args) {
		Properties props=new Properties();
		props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 1; i <= 30; i++) {
            producer.send(new ProducerRecord<>("orders", "order-" + i, "OrderID-" + i));
        }
        producer.close();
        System.out.println("30 orders sent successfully!");
	}
	
}
