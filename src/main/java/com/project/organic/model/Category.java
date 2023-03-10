package com.project.organic.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id ;
    @Column(name = "Code")
    private String code ;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private boolean status;
    @OneToMany(mappedBy = "categoryID")
    private List<Product> listPro;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String code, String name, String description, boolean status, List<Product> listPro) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.status = status;
		this.listPro = listPro;
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
