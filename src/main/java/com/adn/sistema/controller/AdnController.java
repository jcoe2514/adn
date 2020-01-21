package com.adn.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adn.sistema.entity.Adn;
import com.adn.sistema.service.AdnService;

@RestController
public class AdnController {

	@Autowired
	private AdnService adnService;
	
	

	@RequestMapping(value = "/mutation", method = RequestMethod.POST)
	public boolean hasMutation(@RequestBody Adn adn) {
		return this.adnService.validateMutation(adn);
	}

}
