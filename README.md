# Kafka Practice Project

This repository contains a hands-on Kafka learning setup using **Docker Compose** and **Java**.

## 🚀 Features
- Multi-broker Kafka cluster with Zookeeper (via Docker Compose).
- Java Producer and Consumer examples.
- Multi-consumer group experiment to demonstrate partition distribution and rebalancing.
- Replication factor setup to test durability and broker failover.
- Retention policies (time-based, size-based, log compaction) explained.



## 🛠️ Setup
1. Start Kafka cluster:
   ```bash
   docker-compose up -d
Create-topics:
   kafka-topics --create --topic orders --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
Run producer:
   java com.example.kafka.ProducerOrders
Run consumers:
java com.example.kafka.MultiConsumerExample consumer-1
java com.example.kafka.MultiConsumerExample consumer-2

