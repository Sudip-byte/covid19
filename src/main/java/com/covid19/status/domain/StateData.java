package com.covid19.status.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateData {
	
	@Id
	private String id;
	private String code;
	private String name;
	private String active;
	private String deaths;
	private String confirmed;
	private String newdeaths;
	private String recovered;
	private String newconfirmed;
	private String newrecovered;
	private String lastupdatedtime;

}
