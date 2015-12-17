package br.com.curiosity.services;

import org.springframework.stereotype.Service;

import br.com.curiosity.model.Mission;

@Service
public class MissionControllService {

	public void execute(Mission mission) {
		System.out.println(mission);
	}

}
