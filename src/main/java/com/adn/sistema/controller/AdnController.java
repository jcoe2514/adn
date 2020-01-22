package com.adn.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adn.sistema.entity.Adn;
import com.adn.sistema.entity.CountMutation;
import com.adn.sistema.service.AdnService;

@RestController
public class AdnController {

	@Autowired
	private AdnService adnService;

	@RequestMapping(value = "/mutation", method = RequestMethod.POST)
	public String hasMutation(@RequestBody Adn adn) {
		boolean bandera = this.adnService.validateMutation(adn);
		return bandera ? "HTTP 200-OK" : "403-Forbidden";
	}

	@RequestMapping(value = "/stats/{id}", method = RequestMethod.GET)
	public CountMutation getStats(@PathVariable("id") Integer id) {
		return this.adnService.findById(id);
	}

}
