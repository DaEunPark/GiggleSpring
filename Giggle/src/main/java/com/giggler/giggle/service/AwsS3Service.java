package com.giggler.giggle.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@Service("awsS3Service")
@PropertySource("/WEB-INF/config/key.properties")
public class AwsS3Service {
	@Autowired
	private AmazonS3 s3Client;
	
	@Autowired
	private Environment env;
	
//	@Value("{aws.bucketname}")
//	private String bucketName;
	
	public boolean uploadObject(MultipartFile multipartFile, String storedFileName) throws IOException {
		String filePath = "raw/" + storedFileName;
		String bucket = env.getProperty("aws.bucketname");
//		FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(multipartFile.getSize());
		
		s3Client.putObject(new PutObjectRequest(bucket, filePath, multipartFile.getInputStream(), metadata));
		boolean isExist = s3Client.doesObjectExist(bucket, filePath);
		return isExist;
//		return s3Client.getUrl(bucket, filePath).toString();
	}
	
	public void deleteObject(String storedFileName) throws AmazonServiceException {
		String bucket = env.getProperty("aws.bucketname");
		s3Client.deleteObject(new DeleteObjectRequest(bucket + "/raw/", storedFileName));
	}
	
	/*
	 * 파일명 UUID로 바꾸기 
	 */
//	private String getUUIDFileName(String original) {
//	return UUID.randomUUID().toString() + "_" + original;
//	}
}
