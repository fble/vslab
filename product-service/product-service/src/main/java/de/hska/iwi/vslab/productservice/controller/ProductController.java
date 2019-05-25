package de.hska.iwi.vslab.productservice.controller;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.productservice.dataobject.Product;
import de.hska.iwi.vslab.productservice.manager.ProductManager;

@RestController
@RequestMapping(value = "products/")
public class ProductController {
	
	private final ProductManager productManager;
	
	public ProductController(final ProductManager productManager) {
		this.productManager = productManager;
	}
// changed the product to have int categoryId instead of Category category
	@PostMapping
	public Response create(@RequestBody Product product) {
		// Create Product
		try {
			productManager.addProduct(product.getName(), product.getPrice(), product.getCategoryId(), product.getDetails());
		} catch (Exception e) {
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

	@GetMapping
	public Response getProducts() {
		try {
			return Response.ok(productManager.getProducts()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GetMapping("{id}")
	public Response getProduct(@PathVariable final int id) {
		try {
			return Response.ok(productManager.getProductById(id)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@DeleteMapping("{id}")
	public Response delete(@PathVariable final int id) {
		// Delete Product
		try {
			productManager.deleteProductById(id);
		} catch (Exception e) {
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

}
