package store;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.Inventory.Item;

import java.util.ArrayList;

@WebServlet("/Store/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>) getServletContext().getAttribute("items");
		int id = Integer.parseInt(request.getParameter("id"));
		for(int i = 0; i < items.size(); ++i)
			if(items.get(i).getId()== id)
			{
				items.remove(i);
				break;
			}
		 
		response.sendRedirect("Inventory");

	}

}