package com.project.organic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "Code")
	private String code;
	@Column(name = "Name")
	private String name;
	@Column(name = "Email")
	private String email;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Password")
	private String password;
	@Column(name = "Address")
	private String address;
	@Column(name = "Birthday")
	private String birthday;
	@Column(name = "Role")
	private boolean role;
	@Column(name = "Gender")
	private boolean gender;
	@Column(name = "Images")
	private String images;
	@OneToMany(mappedBy = "accountId")
	private List<Order> listOrder;
	@Column(name = "token")
	private String token;
//	@OneToMany(mappedBy = "account")
//	private List<Favorite> listFavorite;
//	@OneToMany(mappedBy = "accountId")
//	private List<Rating> listRating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
		this.role = role;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String code, String name, String email, String phone, String password, String address,
			String birthday, boolean role, boolean gender, String images,String token) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.birthday = birthday;
		this.role = role;
		this.gender = gender;
		this.images = images;
		this.token = token;
	}

}