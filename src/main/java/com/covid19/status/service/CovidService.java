package com.covid19.status.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.covid19.status.domain.CovidData;
import com.covid19.status.domain.StateData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CovidService {
	
	private RestTemplate restTemplate;

	
	public List<StateData> getCovidData() throws UnirestException, JsonMappingException, JsonProcessingException
	{
		HttpResponse<String> response = Unirest.get("https://covid-19-india-data-by-zt.p.rapidapi.com/GetIndiaStateWiseData")
				.header("x-rapidapi-host", "covid-19-india-data-by-zt.p.rapidapi.com")
				.header("x-rapidapi-key", "7e1baade37msh4ca4da74e1a4545p183f1fjsn27549cc4056f")
				.asString();
		
		ObjectMapper objectMapper = new ObjectMapper(); 
		
		CovidData covidData = objectMapper.readValue(response.getBody().toString(), CovidData.class);
		log.info("Covid data :: "+covidData.getStatusMsg());
		return covidData.getData();
	}
	
	
	
}
