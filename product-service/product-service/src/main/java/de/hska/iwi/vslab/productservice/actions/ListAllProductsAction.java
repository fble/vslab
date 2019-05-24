package de.hska.iwi.vslab.productservice.actions;


import java.util.List;

import de.hska.iwi.vslab.productservice.dataobject.Product;
import de.hska.iwi.vslab.productservice.dataobject.User;

public class ListAllProductsAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94109228677381902L;
	
	User user;
	private List<Product> products;
	
	public String execute() throws Exception{
		String result = "input";
		
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		user = (User) session.get("webshop_user");
//		
//		if(user != null){
//			System.out.println("list all products!");
//			ProductManager productManager = new ProductManagerImpl();
//			this.products = productManager.getProducts();
//			result = "success";
//		}
		
		return result;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
