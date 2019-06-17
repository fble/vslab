package de.hska.vslab;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import de.hska.vslab.dataobjects.Category;
import de.hska.vslab.dataobjects.Product;
import de.hska.vslab.dataobjects.Registration;
import de.hska.vslab.dataobjects.User;

@Component
public class ContentClient {
	private String categoryUri = "http://content-mgmt/categories/";
	private String productUri = "http://content-mgmt/products/";
	private String userUri = "http://user-service/users/";

	public boolean createCategory(final String name) {

		RestTemplate rt = new RestTemplate();
		rt.postForEntity(categoryUri, name, String.class);

		return true;
	}

	public Category[] getCategories() {

		RestTemplate rt = new RestTemplate();
		ResponseEntity<Category[]> entity = rt.getForEntity(categoryUri, Category[].class);

		return entity.getBody();
	}

	public Category getCategoryById(int id) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Category> entity = rt.getForEntity(categoryUri + id, Category.class);

		return entity.getBody();
	}

	public boolean deleteCategory(int id) {

		RestTemplate rt = new RestTemplate();
		rt.delete(categoryUri + id);

		return true;
	}

	public boolean createProduct(Product p) {
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(productUri, p, Product.class);

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
		ResponseEntity<Product> entity = rt.getForEntity(productUri + id, Product.class);

		return entity.getBody();
	}

	public boolean deleteProduct(int id) {
		RestTemplate rt = new RestTemplate();
		rt.delete(productUri + id);

		return true;
	}

	public Product[] searchProduct(String searchText) {
		return null;
	}

	public User createUser(Registration r) {
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(userUri, r, Registration.class);

		return null;
	}

	public User loginUser(User u) {
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(userUri + "login", u, User.class);

		return null;
	}

	public User logoutUser(User u) {
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(userUri + "logout", u, User.class);

		return null;
	}
}
