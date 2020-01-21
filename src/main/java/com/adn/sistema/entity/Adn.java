package com.adn.sistema.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_ADN")
public class Adn {

	@Id
	@SequenceGenerator(name = "SEQ_ADN", sequenceName = "SEQ_ADN", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADN")
	private Integer id;

	@Column(name = "ADN_ORIGIN")
	private String[] adnOrigin;

	@Column(name = "LAST_ADN")
	private char[][] lastAdn;

	@Column(name = "IS_MUTATION")
	private boolean isMutation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Adn() {
	}

	public Adn(Integer id, String[] adnOrigin, char[][] lastAdn, boolean isMutation) {
		super();
		this.id = id;
		this.adnOrigin = adnOrigin;
		this.lastAdn = lastAdn;
		this.isMutation = isMutation;
	}

	public String[] getAdnOrigin() {
		return adnOrigin;
	}

	public void setAdnOrigin(String[] adnOrigin) {
		this.adnOrigin = adnOrigin;
	}

	public char[][] getLastAdn() {
		return lastAdn;
	}

	public void setLastAdn(char[][] lastAdn) {
		this.lastAdn = lastAdn;
	}

	public boolean isMutation() {
		return isMutation;
	}

	public void setMutation(boolean isMutation) {
		this.isMutation = isMutation;
	}

}
