package de.hska.iwi.vslab.contentmanagementservice;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.contentmanagementservice.clients.CategoryClient;
import de.hska.iwi.vslab.contentmanagementservice.clients.ProductClient;

@RestController
@RequestMapping(value="/categories/")
public class CategoryController {

	private CategoryClient categoryClient = new CategoryClient(); 
	private ProductClient productClient = new ProductClient();
	@PostMapping
	public Response createCategory(@RequestBody Category c ) {
		//TODO add new category
		boolean created = categoryClient.createCategory(c);
		if(created) {
			return Response.ok().build();
		}else {
			return Response.serverError().build();
		}
		
	}
	
	@GetMapping
	public Response getCategory() {
		// Login user
		// TODO return category
		return Response.ok(categoryClient.getCategories()).build();
	}
	
	@GetMapping("{id}")
	public Response getCategoryById(@PathVariable int id) {
		// Logout user
		
		Category c = categoryClient.getCategoryById(id);
		if(c != null) {
			return Response.ok(c).build();
		}else {
			return Response.noContent().build();
		}
		
		//return Response.ok().build();
	}
	
	@DeleteMapping("{id}")
	public Response deleteCategoryById(@PathVariable int id) {
		boolean deleted = categoryClient.deleteCategory(id);
		if(deleted) {
			return Response.ok().build();
		}else {
			return Response.serverError().build();
		}
		
	}
	
	@GetMapping("{id}/products")
	public Response getProducts(@PathVariable int id) {
		// Logout user
		Product[] p = productClient.getProductsByCategoryId(id);
		return Response.ok(p).build();
		
	}
	
	

	
}
