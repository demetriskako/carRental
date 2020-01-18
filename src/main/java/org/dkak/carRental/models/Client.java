package org.dkak.carRental.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Path;

@Entity
@Table(name = "client")
@Path("client")
public class Client {
	
	@Id
	@Column(name="CLIENT_ID")
	private String id;
	@Column(name="CLIENT_NAME")
	private String name;
	@Column(name="CLIENT_SURNAME")
	private String surname;
	@Column(name="CLIENT_DRIVING_LICENSE")
	private String license;
	@Column(name="CLIENT_ADDRESS")
	private String address;
	@Column(name="CLIENT_EMAIL")
	private String email;
	@Column(name="CLIENT_TELEPHONE_NO")
	private String tel;
		
	public Client() {
	
	}

	public Client(String id, String name, String surname, String license, String email, String tel, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.license = license;
		this.address = address;
		this.email = email;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
