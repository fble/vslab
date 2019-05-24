package de.hska.iwi.vslab.productservice.manager;

import java.util.List;

import de.hska.iwi.vslab.productservice.dao.CategoryDAO;
import de.hska.iwi.vslab.productservice.dataobject.Category;

public class CategoryManagerImpl implements CategoryManager{
	private CategoryDAO helper;
	
	public CategoryManagerImpl() {
		helper = new CategoryDAO();
	}

	public List<Category> getCategories() {
		return helper.getObjectList();
	}

	public Category getCategory(int id) {
		return helper.getObjectById(id);
	}

	public Category getCategoryByName(String name) {
		return helper.getObjectByName(name);
	}

	public void addCategory(String name) {
		Category cat = new Category(name);
		helper.saveObject(cat);

	}

	public void delCategory(Category cat) {
	
// 		Products are also deleted because of relation in Category.java 
		helper.deleteById(cat.getId());
	}

	public void delCategoryById(int id) {
		
		helper.deleteById(id);
	}
}
