package com.covid19.status.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.status.domain.StateData;
import com.covid19.status.repository.StateRepository;
import com.covid19.status.service.CovidService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CovidController {
	
	@Autowired
	private CovidService covidService;
	
	@Autowired
	StateRepository stateRepository;
	
	StateData data = null;
	
	@GetMapping(value="/getCovidData")
	public String getCovidData() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		
		List<StateData> stateData = new ArrayList<>();
		stateData = covidService.getCovidData();
		stateData.forEach(state -> stateRepository.save(state));
		
		log.info("State Data :: "+stateData);
		return stateData.toString();
		
		
	}
	
	@GetMapping(value="/getStateStats")
	public List<StateData> getStateStats(@RequestParam String stateName) throws JsonMappingException, JsonProcessingException, UnirestException {
		
		return stateRepository.findByStateName(stateName);
	}
	

}
