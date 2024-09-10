package com.jtrails.aws.travel.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jtrails.aws.exception.TravelServiceException;
import com.jtrails.aws.travel.model.TravelDestination;
import com.jtrails.aws.travel.repository.TravelDestinationRespository;

/**
 * @author Lejil
 *
 */
@Service
public class TravelDestinationServiceImpl implements TravelDestinationService {

	private final TravelDestinationRespository nationalParkRespository;

	public TravelDestinationServiceImpl(TravelDestinationRespository nationalParkRespository) {
		this.nationalParkRespository = nationalParkRespository;
	}

	@Override
	public TravelDestination addTravelDestination(TravelDestination travelDestination) {
		return nationalParkRespository.addTravelDestination(travelDestination);
	}

	@Override
	public TravelDestination findTravelDestinationById(String destinationId, String country) {
		TravelDestination destination = nationalParkRespository.findTravelDestinationById(destinationId, country);
		return Optional.ofNullable(destination)
				.orElseThrow(() -> new TravelServiceException(HttpStatus.NOT_FOUND.value(),
						"Travel Destination not found for id - " + destinationId));
	}

	@Override
	public String deleteTravelDestination(String destinationId, String country) {
		TravelDestination tDestination = new TravelDestination();
		tDestination.setDestinationId(destinationId);
		tDestination.setCountry(country);
		return nationalParkRespository.deleteTravelDestination(tDestination);
	}

	@Override
	public String updateTravelDestination(TravelDestination travelDestination) {
		return nationalParkRespository.updateTravelDestination(travelDestination);
	}

}
