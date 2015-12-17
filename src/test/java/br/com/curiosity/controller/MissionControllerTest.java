package br.com.curiosity.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import br.com.curiosity.Application;

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
		Map<String, Object> requestMissionData = new HashMap<String, Object>();
		requestMissionData.put("lowLandSize", "{\"xPosition\": \"5\", \"yPosition\": \"5\"}");
		requestMissionData.put("rovers", "[{\"xPosition\":\"1\",\"yPosition\":\"2\",\"direction\":\"M\",\"instructions\":\"LMLMLMLMM\"},{\"xPosition\":\"3\",\"yPosition\":\"3\",\"direction\":\"E\",\"instructions\":\"MMRMMRMRRM\"}]}");

		// When
		@SuppressWarnings({ "unchecked" })
		ResponseEntity<List> responseCreate = restTemplate.postForEntity(
				"http://localhost:8080/mission/", requestMissionData,
				List.class, Collections.EMPTY_MAP);

		// Then
		assertNotNull(responseCreate);
		assertEquals(HttpStatus.OK, responseCreate.getStatusCode());

	}

}
