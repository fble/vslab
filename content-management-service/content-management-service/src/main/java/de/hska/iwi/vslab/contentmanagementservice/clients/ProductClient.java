package de.hska.iwi.vslab.contentmanagementservice.clients;

import de.hska.iwi.vslab.contentmanagementservice.Product;

public class ProductClient {

	public boolean createProduct(Product p) {
		return true;
	}
	
	public Product[] getProducts() {
		return new Product[0];
	}
	
	public Product[] getProductsByCategoryId(int ctaId) {
		return new Product[0];
	}
	
	public Product getProductById(int id) {
		return new Product();
	}
	
	public boolean deleteProduct(int id) {
		return true;
	}
	
	public Product[] searchProduct(String searchText) {
		return null;
	}
	
	
}
