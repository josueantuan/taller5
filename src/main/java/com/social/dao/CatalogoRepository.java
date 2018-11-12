package com.social.dao;
import com.social.entities.Catalogo;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogoRepository extends JpaRepository<Catalogo,Long>{
List<Catalogo> findAll();
	
	/**
	 * 
	 * @param id_father
	 * @return gender
	 */
	@Query("SELECT id, name FROM CatalogGenderAndFrom WHERE id_father=:idfather")
	List<Catalogo> findGenderByIdFather(@Param("idfather") Long idfather);
	
	/**
	 * 
	 * @param id_father
	 * @return from
	 */
	@Query("SELECT id, name FROM CatalogGenderAndFrom WHERE id_father=:idfather")
	List<Catalogo> findFromByIdFather(@Param("idfather") Long idfather);
}
