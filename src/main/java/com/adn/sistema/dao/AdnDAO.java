package com.adn.sistema.dao;

import com.adn.sistema.entity.Adn;
import com.adn.sistema.entity.CountMutation;

public interface AdnDAO {
	
	void save(Adn adn);
	
	boolean validateMutation(Adn adn);
	
	CountMutation findById(Integer id);
	
	

}
