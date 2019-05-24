package de.hska.iwi.vslab.categoryservice.actions;

import java.util.List;

import de.hska.iwi.vslab.categoryservice.dataobjects.Category;
import de.hska.iwi.vslab.categoryservice.dataobjects.User;

public class AddCategoryAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6704600867133294378L;
	
	private String newCatName = null;
	
	private List<Category> categories;
	
	User user;

	public String execute() throws Exception {

		String res = "input";
//
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		user = (User) session.get("webshop_user");
//		if(user != null && (user.getRole().getTyp().equals("admin"))) {
//			CategoryManager categoryManager = new CategoryManagerImpl();
//			// Add category
//			categoryManager.addCategory(newCatName);
//			
//			// Go and get new Category list
//			this.setCategories(categoryManager.getCategories());
//			
//			res = "success";
//		}
		
		return res;
	
	}
	
//	@Override
//	public void validate(){
//		if (getNewCatName().length() == 0) {
//			addActionError(getText("error.catname.required"));
//		}
//		// Go and get new Category list
//		CategoryManager categoryManager = new CategoryManagerImpl();
//		this.setCategories(categoryManager.getCategories());
//	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public String getNewCatName() {
		return newCatName;
	}

	public void setNewCatName(String newCatName) {
		this.newCatName = newCatName;
	}
}
