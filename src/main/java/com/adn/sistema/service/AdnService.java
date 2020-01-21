package com.adn.sistema.service;

import com.adn.sistema.entity.Adn;

public interface AdnService {
	void save(Adn adn);
	
	boolean validateMutation(Adn adn);
}
