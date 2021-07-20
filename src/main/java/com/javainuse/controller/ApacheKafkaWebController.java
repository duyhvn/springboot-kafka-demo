package com.javainuse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.service.ProducerService;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class ApacheKafkaWebController {
	private static final Logger logger = LoggerFactory.getLogger(ApacheKafkaWebController.class);
	@Autowired
	ProducerService kafkaSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		logger.info("78899");
		kafkaSender.sendMessage(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
}