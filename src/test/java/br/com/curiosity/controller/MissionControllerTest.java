package br.com.curiosity.controller;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import br.com.curiosity.Application;
import br.com.curiosity.model.Mission;
import br.com.curiosity.model.Rover;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
@IntegrationTest
public class MissionControllerTest {

	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void executeMissionTest() throws JsonProcessingException {
		// Give
		Rover rover1 = new Rover(1, 2, 'N', "LMLMLMLMM");
		Rover rover2 = new Rover(3, 3, 'E', "MMRMMRMRRM");
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(rover1);
		rovers.add(rover2);
		Mission mission = new Mission(5, 5, rovers);
		// When
		@SuppressWarnings({ "unchecked" })
		List<Rover> responseMission = restTemplate.postForObject(
				"http://localhost:8080/mission/", mission, List.class);
		
		// Then
		assertNotNull(responseMission);
	}
	
	@Test
	public void executeWrongMissionTest() throws JsonProcessingException {
		// Give
		Rover rover1 = new Rover(1, 2, 'N', "LMLMLMLMM");
		Rover rover2 = new Rover(6, 5, 'E', "MMRMMRMRRM");
		List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(rover1);
		rovers.add(rover2);
		Mission mission = new Mission(5, 5, rovers);
		// When
		@SuppressWarnings({ "unchecked" })
		List<Rover> responseMission = restTemplate.postForObject(
				"http://localhost:8080/mission/", mission, List.class);
		
		// Then
		assertTrue(responseMission.size() == 0);
	}

}
