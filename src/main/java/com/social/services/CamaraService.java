package com.social.services;

import java.util.List;

import com.social.entities.Camara;

public interface CamaraService {

	
	public List<Camara> findAll();
	public Camara save(Camara camara);
}
