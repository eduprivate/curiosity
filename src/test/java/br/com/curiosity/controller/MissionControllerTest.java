package br.com.curiosity.controller;


import static org.junit.Assert.assertNotNull;

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
import br.com.curiosity.entity.Direction;
import br.com.curiosity.entity.Ground;
import br.com.curiosity.entity.Mission;
import br.com.curiosity.entity.Position;
import br.com.curiosity.entity.Rover;

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
		Ground ground = new Ground(5,5);
        Position position1 = new Position(1,2);
        Position position2 = new Position(1,2);
        String instruction1 = "R";
        String instruction2 = "L";
        Rover rover1 = new Rover( Direction.N, position1, instruction1);
        Rover rover2 = new Rover( Direction.S, position2, instruction2);
		
        List<Rover> rovers = new ArrayList<Rover>();
		rovers.add(rover1);
		rovers.add(rover2);
		Mission mission = new Mission(ground, rovers);
		
		// When
		@SuppressWarnings({ "unchecked" })
		List<Rover> responseMission = restTemplate.postForObject(
				"http://localhost:8080/mission/", mission, List.class);
		
		// Then
		assertNotNull(responseMission);
	}

}
