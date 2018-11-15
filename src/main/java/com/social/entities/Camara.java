package com.social.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="camara")
public class Camara implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 100, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Boolean abrir;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getAbrir() {
		return abrir;
	}

	public void setAbrir(Boolean abrir) {
		this.abrir = abrir;
	}
}
