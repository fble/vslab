package de.hska.iwi.vslab.categoryservice.controller;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.hska.iwi.vslab.categoryservice.Category;
import de.hska.iwi.vslab.categoryservice.actions.AddCategoryAction;
import de.hska.iwi.vslab.categoryservice.actions.DeleteCategoryAction;
import de.hska.iwi.vslab.categoryservice.actions.InitCategorySiteAction;
import de.hska.iwi.vslab.categoryservice.actions.SearchAction;
import de.hska.iwi.vslab.categoryservice.manager.CategoryManager;


@RestController
@RequestMapping(value = "categorys/")
public class CategoryController {
	
//
//	private final SearchAction searchAction;
//	private final AddCategoryAction addCategoryAction;
//	private final DeleteCategoryAction deleteCategoryAction;
//	private final InitCategorySiteAction initCategorySiteAction;
	private final CategoryManager categoryManager;
	
	public CategoryController(
//			final SearchAction searchAction,
//			final AddCategoryAction addCategoryAction,
//			final DeleteCategoryAction deleteCategoryAction,
//			final InitCategorySiteAction initCategorySiteAction,
			final CategoryManager categoryManager) {
//		this.addCategoryAction = addCategoryAction;
//		this.searchAction = searchAction;
//		this.deleteCategoryAction = deleteCategoryAction;
//		this.initCategorySiteAction = initCategorySiteAction;
		this.categoryManager = categoryManager;
	}
	
	@PostMapping
	public Response create(@RequestBody String name) {
		// Create Category
		try {
			categoryManager.addCategory(name);
		} catch (Exception e) {
			return Response.serverError().build();
		}
		
		return Response.ok().build();
	}

	@GetMapping
	public Response getCategorys() {
		try {
			return Response.ok(categoryManager.getCategories()).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GetMapping("{id}")
	public Response getCategory(@PathVariable final int id) {
		try {
			return Response.ok(categoryManager.getCategory(id)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@DeleteMapping("{id}")
	public Response delete(@PathVariable final int id) {
		// Delete Category
		try {
			categoryManager.delCategoryById(id);
		} catch (Exception e) {
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

}
