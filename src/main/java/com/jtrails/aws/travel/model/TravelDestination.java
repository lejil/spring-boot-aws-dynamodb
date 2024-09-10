package com.jtrails.aws.travel.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * @author Lejil
 *
 */


@DynamoDBTable(tableName = "TravelDestination")
public class TravelDestination {

	// Partition Key
	@DynamoDBHashKey(attributeName = "destinationId")
	private String destinationId;

	//sort order
	@DynamoDBRangeKey(attributeName = "country")
	private String country;
	
	@DynamoDBAttribute
	private String name;

	@DynamoDBAttribute
	private String city;

	@DynamoDBAttribute
	private String description;

	@DynamoDBAttribute
	private String category;

	@DynamoDBAttribute
	private String bestSeasonToVisit;
	
	@DynamoDBAttribute
	private String attractions;

	public String getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBestSeasonToVisit() {
		return bestSeasonToVisit;
	}

	public void setBestSeasonToVisit(String bestSeasonToVisit) {
		this.bestSeasonToVisit = bestSeasonToVisit;
	}

	public String getAttractions() {
		return attractions;
	}

	public void setAttractions(String attractions) {
		this.attractions = attractions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}