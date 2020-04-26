package com.covid19.status.domain;

import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "covid")
@EntityScan
public class CovidData {

	@Id
	private String id;
	private String statusMsg;
	private List<StateData> data;

}
