package de.hska.iwi.vslab.productservice.actions;


import java.util.Map;


public class DeleteProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666796923937616729L;

	private int id;

	public String execute() throws Exception {
		
		String res = "input";
		
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		User user = (User) session.get("webshop_user");
//		
//		if(user != null && (user.getRole().getTyp().equals("admin"))) {
//
//			new ProductDAO().deleteById(id);
//			{
//				res = "success";
//			}
//		}
		
		return res;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
