package com.jtrails.aws.travel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jtrails.aws.travel.model.TravelDestination;
import com.jtrails.aws.travel.service.TravelDestinationService;

/**
 * @author Lejil
 *
 */
@RestController
@RequestMapping("/travelDestinationService")
public class TravelDestinationController {

	
	private final TravelDestinationService travelDestinationService;
	
	TravelDestinationController(TravelDestinationService travelDestinationService){
		this.travelDestinationService =travelDestinationService;
	}

	@PostMapping("/travelDestination")
	public ResponseEntity<TravelDestination> createNationalPark(@RequestBody TravelDestination travelDestination) {
		TravelDestination savedNationalPark = travelDestinationService.addTravelDestination(travelDestination);
		return new ResponseEntity<>(savedNationalPark, HttpStatus.CREATED);
	}

	@GetMapping("/travelDestination")
	public ResponseEntity<TravelDestination> getNationaParkById(@RequestParam String destinationId,@RequestParam String country) {
		TravelDestination savedNationalPark = travelDestinationService.findTravelDestinationById(destinationId,country);
		return new ResponseEntity<>(savedNationalPark, HttpStatus.OK);
	}

	@PutMapping("/travelDestination")
	public ResponseEntity<String> updateEmployee(@RequestBody TravelDestination travelDestination) {
		String status = travelDestinationService.updateTravelDestination(travelDestination);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/travelDestination")
	public ResponseEntity<String> deleteEmployee(@RequestParam String destinationId,@RequestParam String country) {
		String status = travelDestinationService.deleteTravelDestination(destinationId,country);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}
}
