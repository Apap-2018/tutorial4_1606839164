package com.apap.tutorial4.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial4.model.FlightModel;
import com.apap.tutorial4.repository.FlightDB;

@Service("flightService")
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDB flightDB;
	
	@Override
	public void addFlight(FlightModel flight) {
		flightDB.save(flight);
	}
	
	public void deleteFlight(long id) {
		flightDB.deleteById(id);
	}
	
	public FlightModel findFlight(long id) {
		return flightDB.findById(id).get();	
	}
	
	public void updateFlight(long id, String flightNumber, String origin, String destination, Date time) {
		FlightModel flightModel = flightDB.findById(id).get();
		flightModel.setFlightNumber(flightNumber);
		flightModel.setOrigin(origin);
		flightModel.setDestination(destination);
		flightModel.setTime(time);
	}
	
	public List<FlightModel> findAllFlight(){
		return flightDB.findAll();
	}

}