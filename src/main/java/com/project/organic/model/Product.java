package com.project.organic.model;

import lombok.*;

import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id ;
	@Column(name = "Code")
	private String code ;
	@Column(name = "Name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "CategoryID", referencedColumnName = "ID")
	private Category categoryID;
	@Column(name = "Description")
	private String description;
	@Column(name = "Images")
	private String images;
	@Column(name = "Price")
	private float price;
	@Column(name = "SALEPRICE")
	private float salePrice;
	@Column(name = "Status")
	private boolean status;
    @OneToMany(mappedBy = "productId")
    private List<OrderDetail> listOrderDetail;
    @OneToMany(mappedBy = "productId")
    private List<Favorite> listFavorite;
//    @OneToMany(mappedBy = "productId")
//    private List<Rating> listRating;
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
	public Category getCategoryId() {
		return categoryID;
	}
	public void setCategoryId(Category categoryId) {
		this.categoryID = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Product(int id, String code, String name,  Category categoryID, String description, String images,
			float price, float salePrice, boolean status) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.categoryID = categoryID;
		this.description = description;
		this.images = images;
		this.price = price;
		this.salePrice = salePrice;
		this.status = status;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public Category getCategoryID() {
//		return categoryID;
//	}
//	public void setCategoryID(Category categoryID) {
//		this.categoryID = categoryID;
//	}
//	
//	public List<Favorite> getListFavorite() {
//		return listFavorite;
//	}
//	public void setListFavorite(List<Favorite> listFavorite) {
//		this.listFavorite = listFavorite;
//	}
	
}