package com.adn.sistema.service;

import com.adn.sistema.entity.Adn;
import com.adn.sistema.entity.CountMutation;

public interface AdnService {
	void save(Adn adn);
	
	boolean validateMutation(Adn adn);
	
	CountMutation findById(Integer id);
}
