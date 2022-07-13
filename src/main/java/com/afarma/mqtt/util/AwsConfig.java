package com.afarma.mqtt.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.iot.AWSIot;
import com.amazonaws.services.iot.AWSIotClientBuilder;
import com.amazonaws.services.iotdata.AWSIotDataClient;
import com.amazonaws.services.iotdata.AWSIotDataClientBuilder;
import com.afarma.mqtt.dto.AppConfig;

@Configuration
public class AwsConfig{
	
	@Bean
	public AWSIot getIotClient(AppConfig appConfig){
			return AWSIotClientBuilder.standard()
					.withCredentials(new AWSStaticCredentialsProvider
							(new BasicAWSCredentials(appConfig.getAccessKeyId(),appConfig.getSecretKeyId())))
					.withRegion(Regions.SA_EAST_1)
					.build();
	}
	
	@Bean
	public AWSIotDataClient getIotDataClient( final AppConfig appConfig){

	return (AWSIotDataClient) AWSIotDataClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(new AWSCredentials(){
			
			public String getAWSSecretKey(){
				return appConfig.getSecretKeyId();
				
				}
			public String getAWSAccessKeyId(){
				return appConfig.getAccessKeyId();
				}
			}))
			.withRegion(Regions.SA_EAST_1)
			.build();
			}
}