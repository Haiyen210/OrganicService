package com.project.organic.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "Favorite")
public class Favorite {
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

    public Favorite() {
    }

    public Favorite(int id, Product productId, Account accountId) {
        this.id = id;
        this.productId = productId;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
