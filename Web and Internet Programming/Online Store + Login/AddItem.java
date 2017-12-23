package store;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.Inventory.Item;

@WebServlet("/Store/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int idSeed = 100;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("    <html>");
		out.println("        <head>");
		out.println("            <title>Online Store</title>");
		out.println("            <meta charset='utf-8'>");
		out.println(
				"            <link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		out.println("        <style type='text/css'>");
		out.println("            .container {");
		out.println("                 color:#1e6120;");
		out.println("            }");
		out.println("            .form-control {");
		out.println("                 width: 350px;");
		out.println("                 border-radius: 0;");
		out.println("            }");
		out.println("            .btn {");
		out.println("                 background-color: rgba(0,255,0,0.2);");
		out.println("                 border-color:#fff;");
		out.println("                 color:#1e6120;");
		out.println("             }");
		out.println("        </style>");
		out.println("        </head>");
		out.println("        <body>");
		out.println("            <div class='container'>");
		out.println("                <h3>Add Item</h3>");
		out.println("                <form action='AddItem' method='POST'>");
		out.println("                     <label>Name:</label>");
		String name = request.getParameter("name") == null || request.getAttribute("nameError") != null ? ""
				: request.getParameter("name");
		out.printf(
				"					  <input type='text' class='form-control' name='name' value='%s' placeholder='Enter your name' /> <br />",
				name);
		if (request.getAttribute("nameError") != null) {
			out.println("					<p style='color:#7E0808;'>Please enter your name.</p>");
		}
		out.println("                     <label>Description:</label>");
		String description = request.getParameter("description") == null
				|| request.getAttribute("descriptionError") != null ? "" : request.getParameter("description");
		out.printf(
				"					  <textarea class='form-control' name='description' value='%s' placeholder='Describe product here' /></textarea> <br />",
				description);
		if (request.getAttribute("descriptionError") != null) {
			out.println("					<p style='color:#7E0808;'>Please enter a description for your item.</p>");
		}

		out.println("                     <label>Quantity:</label>");
		String quantity = request.getParameter("quantity") == null || request.getAttribute("quantityError") != null
				? "" : request.getParameter("quantity");
		out.printf(
				"					  <input type='text' class='form-control' name='quantity' value='%s' placeholder='Enter an integer' /> <br />",
				quantity);
		if (request.getAttribute("quantityError") != null) {
			out.println("					<p style='color:#7E0808;'>Please enter an integer.</p>");
		}

		out.println("                     <label>Price:</label>");
		String price = request.getParameter("price") == null || request.getAttribute("priceError") != null
				? "" : request.getParameter("price");
		out.printf(
				"					  <input type='text' class='form-control' name='price' value='%s' placeholder='Enter a decimal' /> <br />",
				price);
		if (request.getAttribute("price") != null) {
			out.println("					<p style='color:#7E0808;'>Please enter an decimal.</p>");
		}
		
		out.println("                     <input type='submit' class='btn' value='Add Item' />");
		out.println("                </form>");
		out.println("            </div>");
		out.println("         </body>");
		out.println("     </html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasError = false; // Assume that we start with no errors

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Integer quantity = 0;
		Double price = 0.0;

		// Name Validation
		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", true);
		}
		// Description Validation
		if (description == null || description.trim().length() == 0) {
			hasError = true;
			request.setAttribute("descriptionError", true);
		}

		// Quantity Validation
		try {
			quantity = Integer.parseInt(request.getParameter("quantity"));

		} catch (NumberFormatException exception) {
			hasError = true;
			request.setAttribute("quantityError", true);
		}
		
		// Quantity Validation
		try {
			price = Double.parseDouble(request.getParameter("price"));
		} catch (NumberFormatException exception) {
			hasError = true;
			request.setAttribute("priceError", true);
		}

		// Redisplay form if we have errors
		if (hasError) {
			doGet(request, response);
			return;
		} else {
			// adds new user
			@SuppressWarnings("unchecked")
			ArrayList<Item> items = (ArrayList<Item>) getServletContext().getAttribute("items");
			items.add(new Item(idSeed++, name, description, quantity, price));

			response.sendRedirect("Inventory");
		}

	}

}