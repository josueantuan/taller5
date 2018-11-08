package com.social.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Description of registro.
 * 
 * Antuan Barahona
 */
@Entity
@Table(name = "registro")
@Scope("session")
public class register implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static enum Role {
		USER
	}

	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Description of the property email.
	 */
	@Column(unique = true, nullable = false)
	@NotNull
	private String username;

	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 100, nullable = false)
	private String password;

	/**
	 * Description of the property role , to grant authority to the user .
	 */
	private String role;

	/**
	 * Description of the property full names.
	 */
	@Column(length = 70, nullable = false)

	private String names;

	/**
	 * Description of the property last names.
	 */
	@Column(length = 70, nullable = false)

	private String lastNames;

	/**
	 * Description of the property cellphone.
	 */
	@Column(length = 20, nullable = false)

	private String cellphone;

	/**
	 * Description of the property address.
	 */
	@Column(length = 500)
	
	private String address;
	/**
	 * Description of the property cedula.
	 */
	@Column(length = 10, nullable = false)

	private String cedula;
	/**
	 * Description of the property genero.
	 */
	@Column(length = 20, nullable = true)

	private Integer genero;
	/**
	 * Description of the property nacionalidad.
	 */
	@Column(length = 20, nullable = true)

	private Integer nacionalidad;

	@Transient
	@JsonProperty
	private String profileStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date registerDate;

	/**
	 * Constructor.
	 * 
	 * @param username
	 * @param password
	 */
	public register(final String username, final String password) {
		super();
		this.username = username;
		this.password = password;

	}

	public register() {
		super();
		registerDate = new Date();
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ",]";
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the lastNames
	 */
	public String getLastNames() {
		return lastNames;
	}

	/**
	 * @param lastNames the lastNames to set
	 */
	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return genero
	 */
	public Integer getgenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Integer genero) {
		this.genero = genero;
	}
	/**
	 * @return nacionalidad
	 */
	public Integer getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setNacionalidad(Integer nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	

}
