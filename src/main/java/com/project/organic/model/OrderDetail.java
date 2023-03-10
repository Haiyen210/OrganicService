package com.project.organic.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "OrderDETAIL")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ID")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "OrderID", referencedColumnName = "ID")
    private Order orderId;
    @Column(name = "Price")
    private float price;
    @Column(name = "Quantity")
    private int quantity;
    
    
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
	public Order getOrderId() {
		return orderId;
	}
	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int id, Product productId, Order orderId, float price, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", productId=" + productId + ", orderId=" + orderId + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

}

