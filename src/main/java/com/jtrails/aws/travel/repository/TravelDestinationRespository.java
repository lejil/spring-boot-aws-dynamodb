package com.jtrails.aws.travel.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.jtrails.aws.exception.TravelServiceException;
import com.jtrails.aws.travel.model.TravelDestination;

/**
 * @author Lejil
 *
 */

@Repository
public class TravelDestinationRespository {

	private final DynamoDBMapper mapper;

	public TravelDestinationRespository(DynamoDBMapper mapper) {
		this.mapper = mapper;
	}

	public TravelDestination addTravelDestination(TravelDestination travelDestination) {

		try {
			mapper.save(travelDestination, buildSaveExpression(travelDestination));
		} catch (Exception ex) {
			throw new TravelServiceException(HttpStatus.CONFLICT.value(),
					"Failed to create the TravelDestination id  - " + travelDestination.getDestinationId() + " --"
							+ ex.getMessage());
		}
		return travelDestination;

	}

	public TravelDestination findTravelDestinationById(String destinationId, String country) {
		return mapper.load(TravelDestination.class, destinationId, country);
	}

	public String deleteTravelDestination(TravelDestination travelDestination) {
		try {
			mapper.delete(travelDestination, buildDeleteExpression(travelDestination));
		} catch (Exception ex) {
			throw new TravelServiceException(HttpStatus.NOT_FOUND.value(),
					"Failed to delete the TravelDestination id  - " + travelDestination.getDestinationId() + " --"
							+ ex.getMessage());
		}
		return "Travel destination deleted ";
	}

	public String updateTravelDestination(TravelDestination travelDestination) {
		try {
			mapper.save(travelDestination, buildSaveExpression(travelDestination));
		} catch (Exception ex) {
			throw new TravelServiceException(HttpStatus.NOT_FOUND.value(),
					"Failed to update the TravelDestination id  - " + travelDestination.getDestinationId() + " --"
							+ ex.getMessage());
		}
		return "Travel destination updated ...";
	}

	private DynamoDBDeleteExpression buildDeleteExpression(TravelDestination travelDestination) {
		DynamoDBDeleteExpression dynamoDBDeleteExpression = new DynamoDBDeleteExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("destinationId",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getDestinationId())));
		expectedMap.put("country",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getCountry())));
		dynamoDBDeleteExpression.setExpected(expectedMap);
		return dynamoDBDeleteExpression;
	}

	private DynamoDBSaveExpression buildSaveExpression(TravelDestination travelDestination) {
		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
		expectedMap.put("destinationId",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getDestinationId())));
		expectedMap.put("country",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getCountry())));
		expectedMap.put("attractions",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getAttractions())));
		expectedMap.put("bestSeasonToVisit",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getBestSeasonToVisit())));
		expectedMap.put("category",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getCategory())));
		expectedMap.put("city", new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getCity())));
		expectedMap.put("description",
				new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getDescription())));
		expectedMap.put("name", new ExpectedAttributeValue(new AttributeValue().withS(travelDestination.getName())));

		dynamoDBSaveExpression.setExpected(expectedMap);
		return dynamoDBSaveExpression;
	}

}
