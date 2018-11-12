package com.social.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.services.MailService;
//
import com.social.services.UserService;
import com.social.util.CustomErrorType;
import com.social.entities.User;
import com.social.controller.MailController;

/** 
 * @author kamal berriga
 *
 */
@RestController
@RequestMapping("account")
public class AccountController {
	

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;
	@Autowired
	
	public MailService mailSender;

	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		//ResponseObject<User> resp = new ResponseObject<>();
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}else if (userService.countByCellphone(newUser.getCellphone()) > 01) {
			logger.error("Cellphone Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with Cellphone " + newUser.getCellphone() + "already exist "),
					HttpStatus.CONFLICT);
		}else if (userService.countByCedula(newUser.getCedula()) > 01) {
			logger.error("Cedula Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with Cedula " + newUser.getCellphone() + "already exist "),
					HttpStatus.CONFLICT);
		}
		
		newUser.setRole("USER");
	
		/*mailSender.sendMail("antawa@info.com", newUser.getUsername(), "AntawaGo - Documento no válido",
				"Estimado " + newUser.getNames() + " " + newUser.getLastNames() + ",  El documento '"
						);*/
		
		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
		
	}

	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}

	
	
}
