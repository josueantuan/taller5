package com.social.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.entities.Camara;
import com.social.services.CamaraService;

@RestController
@RequestMapping("/camara")
public class CamaraController {
	
	@Autowired
	private CamaraService camaraService;
	
	@GetMapping("/camaras")
public List<Camara> index(){
	return camaraService.findAll();
}
}
