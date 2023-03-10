package com.project.organic.model;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {
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
	@Column(name = "Address")
	private String address;
	@Column(name = "TotalQUANTITY")
	private int totalQuantity;
	@Column(name = "TotalPRICE")
	private float totalPrice;
	@Column(name = "Status")
	private short status;
	@ManyToOne
	@JoinColumn(name = "ACCOUNTID", referencedColumnName = "ID")
	private Account accountId;
	@Column(name = "Note")
	private String note;
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "MODIREDDATE")
	private Date modiredDate;
	@OneToMany(mappedBy = "orderId")
	private List<OrderDetail> listOrderDetail;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int id, String code, String name, String email, String phone, String address, int totalQuantity,
			float totalPrice, short status, Account accountId,String note,Date createdDate,Date modiredDate) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.accountId = accountId;
		this.note = note;
		this.createdDate = createdDate;
		this.modiredDate = modiredDate;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedDate() {
		
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
	}
	public Date getModiredDate() {
		return modiredDate;
	}
	public void setModiredDate(Date modiredDate) {
		this.modiredDate = modiredDate;
	}
	


	
	
	
	
	
}


