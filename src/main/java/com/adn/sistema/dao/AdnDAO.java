package com.adn.sistema.dao;

import com.adn.sistema.entity.Adn;

public interface AdnDAO {
	
	void save(Adn adn);
	
	boolean validateMutation(Adn adn);
	
	

}
