package de.hska.iwi.vslab.productservice.manager;


import java.util.List;

import de.hska.iwi.vslab.productservice.dataobject.Category;

public interface CategoryManager {

	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	public Category getCategoryByName(String name);
	
	public void addCategory(String name);
	
	public void delCategory(Category cat);
	
	public void delCategoryById(int id);

	
}
