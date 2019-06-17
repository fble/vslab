package de.hska.iwi.vslab.contentmanagementservice;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.contentmanagementservice.clients.ProductClient;

@RestController
@RequestMapping(value="/products/")
public class ProductController {

	private ProductClient productClient = new ProductClient();
	
	@PostMapping
	public Response createProduct(@RequestBody Product p) {
		
		boolean created = productClient.createProduct(p);
		//TODO add new category
		if(created) {
			return Response.ok().build();
		}else {
			return Response.serverError().build();
		}
		
	}
	
	@GetMapping
	public Response getProduct() {
		// Login user
		// TODO return category
		return Response.ok(productClient.getProducts()).build();
	}
	
	@GetMapping("{id}")
	public Response getProductById(@PathVariable int id) {
		Product p = productClient.getProductById(id);
		if(p != null) {
			return Response.ok(p).build();
		}else {
			return Response.noContent().build();
		}
		
	}
	
	@DeleteMapping("{id}")
	public Response deleteProductById(@PathVariable int id) {
		boolean deleted = productClient.deleteProduct(id);
		if(deleted) {
			return Response.ok().build();
		}else {
			return Response.serverError().build();
		}
	}
	
	@RequestMapping(value = "/search", params = "text", method = RequestMethod.GET)
	public Response searchProducts(@RequestParam("text") String search) {
			Product[] found = productClient.searchProduct(search);
			return Response.ok(found).build();
	}
	
}
