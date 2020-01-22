package com.adn.sistema.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TC_COUNT_MUTATION")
public class CountMutation {
	@Id
	@SequenceGenerator(name = "SEQ_TC_COUNT_MUTATION", sequenceName = "SEQ_TC_COUNT_MUTATION", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TC_COUNT_MUTATION")
	private Integer id;
	
	@Column(name = "COUNT_MUTATIONS")
	private Integer countMutations;
	
	@Column(name  ="COUNT_NO_MUTATION")
	private Integer countNoMutation;
	
	@Column(name = "RATIO")
	private Double ratio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCountMutations() {
		return countMutations;
	}

	public void setCountMutations(Integer countMutations) {
		this.countMutations = countMutations;
	}

	public Integer getCountNoMutation() {
		return countNoMutation;
	}

	public void setCountNoMutation(Integer countNoMutation) {
		this.countNoMutation = countNoMutation;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "CountMutation [id=" + id + ", countMutations=" + countMutations + ", countNoMutation=" + countNoMutation
				+ ", ratio=" + ratio + "]";
	}

	public CountMutation(Integer id, Integer countMutations, Integer countNoMutation, Double ratio) {
		super();
		this.id = id;
		this.countMutations = countMutations;
		this.countNoMutation = countNoMutation;
		this.ratio = ratio;
	}
	
	public CountMutation() {}

}
