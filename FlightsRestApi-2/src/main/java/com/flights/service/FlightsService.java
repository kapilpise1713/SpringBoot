package com.flights.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flights.model.Flights;
import com.flights.repository.FlightsRepository;

@Service
public class FlightsService {
	
	@Autowired
	private FlightsRepository flightsRepository;
	
	public List<Flights> getAllFlights()
	{
		return flightsRepository.findAll();
	}
	
	public Optional<Flights> getFlightById(Integer id){
		return flightsRepository.findById(id);
	}
	
	public Flights saveFlight(Flights flight) {
		return flightsRepository.save(flight);
	}
	
	public void deleteFlightById(Integer id) {
		flightsRepository.deleteById(id);
	}

}
