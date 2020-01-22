package com.adn.sistema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adn.sistema.dao.AdnDAO;
import com.adn.sistema.entity.Adn;
import com.adn.sistema.entity.CountMutation;
import com.adn.sistema.service.AdnService;

@Service
public class AdnServiceImpl implements AdnService{

	
	@Autowired
	private AdnDAO adnDAO;
	@Override
	public void save(Adn adn) {
		this.adnDAO.save(adn);
		
	}
	@Override
	public boolean validateMutation(Adn adn) {
		return this.adnDAO.validateMutation(adn);
	}
	@Override
	public CountMutation findById(Integer id) {
		// TODO Auto-generated method stub
		return adnDAO.findById(id);
	}

}
