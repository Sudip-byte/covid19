package com.covid19.status.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.covid19.status.domain.StateData;
import com.covid19.status.domain.CovidData;

@Repository
public interface StateRepository extends MongoRepository<StateData, String>{
	
	@Query(value = "{'name': ?0}")
	public List<StateData> findByStateName(String stateName);


}
