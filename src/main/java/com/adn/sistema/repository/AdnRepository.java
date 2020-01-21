package com.adn.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adn.sistema.entity.Adn;

@Repository
public interface AdnRepository extends JpaRepository<Adn, Integer> {

}
