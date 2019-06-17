package de.hska.vslab;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ContentClient {
    private String categoryUri = "";
    private String productUri = "";
    private String userUri = "";

    public boolean createCategory(Category c) {

        RestTemplate rt = new RestTemplate();
        rt.postForEntity(categoryUri, c, Category.class );

        return true;
    }

    public Category[] getCategories() {

        RestTemplate rt = new RestTemplate();
        ResponseEntity<Category[]> entity = rt.getForEntity(categoryUri, Category[].class);

        return entity.getBody();
    }


    public Category getCategoryById(int id) {
        RestTemplate rt = new RestTemplate();
        ResponseEntity<Category> entity = rt.getForEntity(categoryUri+"/"+id, Category.class);

        return entity.getBody();
    }


    public boolean deleteCategory(int id) {

        RestTemplate rt = new RestTemplate();
        rt.delete(categoryUri+"/"+id);

        return true;
    }

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

    public User createUser(Registration r) {
    	 RestTemplate rt = new RestTemplate();
         rt.postForEntity(userUri, r, Registration.class );

         return null;
    }
    
    public User loginUser(User u) {
		return u;
    	
    }
    
    public User logoutUser(User u) {
   	 RestTemplate rt = new RestTemplate();
        rt.postForEntity(userUri+"/logout", u, User.class );

        return null;
   }
}
