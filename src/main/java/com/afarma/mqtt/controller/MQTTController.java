package com.afarma.mqtt.controller;

import java.io.IOException;

import com.afarma.mqtt.service.CreateThingService;
import com.amazonaws.services.iot.client.AWSIotException;
import com.afarma.mqtt.dto.EquipamentMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afarma.mqtt.util.MQTTConfig;

@RestController
public class MQTTController {
	
	@Autowired 
	MQTTConfig mqttConfig;
	
	@Autowired
    CreateThingService createThingService;
	
	@PostMapping("/publish")
	public String publishMessaged(@RequestBody EquipamentMessage payload) throws IOException, AWSIotException {
		
		mqttConfig.publishToShadow(payload);

		return "message Published Successfully";
	}

	@PostMapping("/register/{thingName}")
	public String createThing(@PathVariable String thingName) {
		return createThingService.createThingAutomatically(thingName);
	}
}
