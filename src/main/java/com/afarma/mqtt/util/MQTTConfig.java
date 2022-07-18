package com.afarma.mqtt.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.afarma.mqtt.dto.EquipamentMessage;
import com.afarma.mqtt.dto.PublishMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.iotdata.model.PublishRequest;
import com.afarma.mqtt.dto.AppConfig;

@Configuration
public class MQTTConfig {

	@Autowired
	private AwsConfig iotClient;
	
	@Autowired
	private AppConfig appConfig;


	public void publishToShadow(EquipamentMessage payload) throws IOException {
		
		String topic = "device_in";

		PublishMsg msg = new PublishMsg(payload.getSlotId());

		ByteBuffer bb = StandardCharsets.UTF_8.encode(msg.toString());
		PublishRequest publishRequest = new PublishRequest();
		publishRequest.withPayload(bb);
		publishRequest.withTopic(topic);
		publishRequest.setQos(0);
		iotClient.getIotDataClient(appConfig).publish(publishRequest);
		System.out.println("message Published successfully");
	}



}
