package de.hska.iwi.vslab.contentmanagementservice;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductController {

	
	@PostMapping
	public Response createProduct() {
		//TODO add new category
		
		return Response.ok().build();
	}
	
	@GetMapping
	public Response getProduct() {
		// Login user
		// TODO return category
		return Response.ok().build();
	}
	
	@GetMapping("{id}")
	public Response getProductById(@PathVariable String id) {
		// Logout user
		return Response.ok("ID"+id).build();
		//return Response.ok().build();
	}
	
	@DeleteMapping("{id}")
	public Response deleteProductById(@PathVariable String id) {
		// Logout user
		return Response.ok("Delete "+id).build();
		//return Response.ok().build();
	}
	
	@RequestMapping(value = "/search", params = "text", method = RequestMethod.GET)
	public Response searchProducts(@RequestParam("text") String search) {
		// Logout user
		return Response.ok("Search Products "+search).build();
		//return Response.ok().build();
	}
	
}
