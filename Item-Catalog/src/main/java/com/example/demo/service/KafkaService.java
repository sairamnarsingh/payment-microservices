package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaService;
	
	String kafka_service="kafka_tutorial";
	public void sendMessage(String message) {
		kafkaService.send(kafka_service, message);
	}
}
