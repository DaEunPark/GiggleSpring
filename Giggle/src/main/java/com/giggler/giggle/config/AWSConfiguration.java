package com.giggler.giggle.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("/WEB-INF/config/key.properties")
public class AWSConfiguration implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(AWSConfiguration.class);
	
	@Autowired
	private Environment env;
	
	@Value("{aws.accesskey}")
	private String accessKey;
	
	@Value("{aws.secretkey}")
	private String secretKey;
	
	@Bean
	public BasicAWSCredentials AwsCredentials( ) {
		logger.info("AWSConfiguration AwsCredentials() 실행");
		BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(getAWSProperty("aws.accesskey"), getAWSProperty("aws.secretkey"));
		return basicAWSCredentials;
	}
	
	@Bean
	public AmazonS3 AwsS3Client( ) {
		logger.info("AWSConfiguration AwsS3Client() 실행");
		
		AmazonS3 s3Builder = AmazonS3ClientBuilder.standard()
				.withRegion(Regions.AP_NORTHEAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(this.AwsCredentials()))
				.build();	

		return s3Builder;		
	}
	
	private String getAWSProperty(String property) {
		return env.getProperty(property);
	}

}
