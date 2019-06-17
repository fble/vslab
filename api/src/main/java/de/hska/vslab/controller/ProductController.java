package de.hska.vslab.controller;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.vslab.ContentClient;
import de.hska.vslab.dataobjects.Product;

@RestController
@RequestMapping(value = "/products/")
public class ProductController {

	private final ContentClient client;

	@Autowired
	public ProductController(final ContentClient client) {
		this.client = client;
	}

	@PostMapping
	public Response create(@RequestBody Product product) {
		boolean success = client.createProduct(product);

		if (success)
			return Response.ok().build();

		return Response.serverError().build();
	}

	@GetMapping
	public Response getProducts() {
		Product[] products = client.getProducts();

		return Response.ok(products).build();
	}
	
	@GetMapping("{id}")
	public Response getProduct(@PathVariable final int id) {
		Product p = client.getProductById(id);
		
		return Response.ok(p).build();
	}
	
	@DeleteMapping("{id}")
	public Response deleteProduct(@PathVariable final int id) {
		boolean success = client.deleteProduct(id);
		
		if (success)
			return Response.ok().build();

		return Response.serverError().build();
	}

}
