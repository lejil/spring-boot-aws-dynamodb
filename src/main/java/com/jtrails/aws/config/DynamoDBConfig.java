package com.jtrails.aws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * @author Lejil
 *
 */
@Configuration
public class DynamoDBConfig {

	@Value("${aws.dynamodb.acc-key}")
	private String awsAccessKey;

	@Value("${aws.dynamodb.sec-key}")
	private String awsSecretKey;

	@Value("${aws.dynamodb.endpoint}")
	private String dynamoDbServiceEndPoint;

	@Value("${aws.dynamodb.region}")
	private String awsRegion;

	@Bean
	DynamoDBMapper mapper() {
		return new DynamoDBMapper(amazonDynamoDBConfig());
	}

	private AmazonDynamoDB amazonDynamoDBConfig() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(dynamoDbServiceEndPoint, awsRegion))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
				.build();
	}
}
