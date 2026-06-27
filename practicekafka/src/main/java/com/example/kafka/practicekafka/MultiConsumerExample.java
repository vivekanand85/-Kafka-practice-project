package com.example.kafka.practicekafka;

import java.util.*;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class MultiConsumerExample {
    public static void main(String[] args) {
        String groupId = "orders-group"; // all consumers share this group
        String consumerId = args.length > 0 ? args[0] : "consumer-1";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", groupId);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("orders"));

        System.out.println(consumerId + " started...");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(java.time.Duration.ofMillis(500));            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("%s consumed: partition=%d, offset=%d, key=%s, value=%s%n",
                        consumerId, record.partition(), record.offset(), record.key(), record.value());
            }
            
           
        }
    }
}
