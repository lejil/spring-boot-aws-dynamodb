package com.jtrails.aws.travel.service;

import com.jtrails.aws.travel.model.TravelDestination;
/**
 * @author Lejil
 *
 */
public interface TravelDestinationService {

	public TravelDestination addTravelDestination(TravelDestination travelDestination);

	public TravelDestination findTravelDestinationById(String id,String country);

	public String deleteTravelDestination(String id,String country);

	public String updateTravelDestination(TravelDestination travelDestination);

}
