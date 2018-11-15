package com.social.ServiceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.dao.CamaraRepository;
import com.social.entities.Camara;
import com.social.services.CamaraService;
@Service
public class CamaraSeviceImpl implements CamaraService {
	@Autowired
	private CamaraRepository camaraRepository;
	@Override
	@Transactional (readOnly = true)
	public List<Camara> findAll() {
		
		return (List<Camara>) camaraRepository.findAll();
	}
	@Override
	@Transactional
	public Camara save(Camara camara) {
		// TODO Auto-generated method stub
		return camaraRepository.save(camara);
	}

}
