package de.hska.iwi.vslab.productservice.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class contains details about products.
 */
@Entity
@Table(name = "product")
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID", nullable = false)
	private int id;

	@Column(name = "PRODUCT_NAME")
	private String name;

	@Column(name = "PRODUCT_PRICE")
	private double price;

	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private int categoryId;

	@Column(name = "PRODUCT_DETAILS")
	private String details;

	public Product() {
	}

	public Product(String name, double price, int categoryId) {
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
	}

	public Product(String name, double price, int categoryId, String details) {
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.details = details;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

