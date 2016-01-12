package br.com.curiosity.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.curiosity.entity.Position;

public interface PositionRepository extends CrudRepository<Position, Long> {

}