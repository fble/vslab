package de.hska.iwi.vslab.contentmanagementservice.clients;

import de.hska.iwi.vslab.contentmanagementservice.Category;
import de.hska.iwi.vslab.contentmanagementservice.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductClient {

	private String productUri = "http://products/products/";

	public boolean createProduct(Product p) {
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(productUri, p, Product.class );

		return true;
	}
	
	public Product[] getProducts() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Product[]> entity = rt.getForEntity(productUri, Product[].class);

		return entity.getBody();
	}
	
	public Product[] getProductsByCategoryId(int catId) {
	return null;
	}
	
	public Product getProductById(int id) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Product> entity = rt.getForEntity(productUri+"/"+id, Product.class);

		return entity.getBody();
	}
	
	public boolean deleteProduct(int id) {
		RestTemplate rt = new RestTemplate();
		rt.delete(productUri+"/"+id);



		return true;
	}
	
	public Product[] searchProduct(String searchText) {
		return null;
	}
	
	
}
