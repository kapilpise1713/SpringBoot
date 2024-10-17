package com.flights.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flights.model.Flights;
import com.flights.service.FlightsService;

@RestController
@RequestMapping("/flights")
public class FlightsController {
	
	@Autowired
	private FlightsService flightsService;
	
	@GetMapping("/allflights")
	public List<Flights> getAllFlights(){
		return flightsService.getAllFlights();
	}
	
	@GetMapping("/{id}")
	public Optional<Flights> getFlightById(@PathVariable Integer id){
		return flightsService.getFlightById(id);
	}
	
	@PostMapping("/addFlight")
	public Flights saveFlights(@RequestBody Flights flight) {
		return flightsService.saveFlight(flight);
	}
	
	@PutMapping("/updateflight/{id}")
	public Flights updateById(@PathVariable Integer id, @RequestBody Flights flightdata)
	{
		Flights flight = flightsService.getFlightById(id).orElseThrow();
		
		flight.setName(flightdata.getName());
		flight.setSource(flightdata.getSource());
		flight.setDestiination(flightdata.getDestiination());
		flight.setPrice(flightdata.getPrice());
		
		return flightsService.saveFlight(flight);
	}
	
	@DeleteMapping("/deleteflight/{id}")
	public void deleteFlight(@PathVariable Integer id) {
		flightsService.deleteFlightById(id);
	}
	
	
	
	

}

