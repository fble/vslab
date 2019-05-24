package de.hska.iwi.vslab.contentmanagementservice.clients;

import de.hska.iwi.vslab.contentmanagementservice.Category;

public class CategoryClient {

	public boolean createCategory(Category c) {
		return true;
	}
	
	public Category[] getCategories() {
		return new Category[0];
	}
	
	
	public Category getCategoryById(int id) {
		return new Category(1, "");
	}
	
	
	public boolean deleteCategory(int id) {
		return true;
	}
	

	
	
}
