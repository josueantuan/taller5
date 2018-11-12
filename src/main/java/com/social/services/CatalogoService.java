package com.social.services;
import java.util.List;
import com.social.entities.Catalogo;
import com.social.dao.CatalogoRepository;
public class CatalogoService {
List<CatalogoRepository> findAll();
	
	/**
	 * 
	 * @param idfather
	 * @return gender
	 */
	List<CatalogoRepository> findGenderFromByIdFather(Long idfather);
	
	/**
	 * 
	 * @param idfather
	 * @return from
	 */
	List<CatalogoRepository> findFromByIdFather(Long idfather);
}
