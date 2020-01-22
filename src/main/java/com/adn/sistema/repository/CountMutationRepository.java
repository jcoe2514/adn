package com.adn.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.sistema.entity.CountMutation;

@Repository
public interface CountMutationRepository extends JpaRepository<CountMutation, Integer> {
	
	CountMutation findFirstById(Integer id);

}
