package com.project.organic.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@ManyToOne
	@JoinColumn(name = "ProductID", referencedColumnName = "ID")
	private Product productId;
	@ManyToOne
	@JoinColumn(name = "AccountID", referencedColumnName = "ID")
	private Account accountId;
	@Column(name = "Star")
	private float star;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private boolean status;

	public Rating() {
	}

	public Rating(int id, Product productId, Account accountId, float star, String description, boolean status) {
		this.id = id;
		this.productId = productId;
		this.accountId = accountId;
		this.star = star;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Account getAccountId() {
		return accountId;
	}

	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}

	public float getStar() {
		return star;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
