package com.social.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.social.entities.User;
/** 
 * @author kamal berriga
 *
 */
/* this the user  Repository interface  */ 
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * This method find an user by username.
	 * 
	 * @param username String
	 * @return {@link User}
	 */
	User findOneByUsername(String username);
	
	Long countByCellphone(String cellphone);
	
	Long countByUsername(String username);
	
	Long countByCedula(String cedula);
}
