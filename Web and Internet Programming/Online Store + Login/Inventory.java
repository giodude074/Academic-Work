package store;

import java.io.IOException;   
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Store/Inventory")
public class Inventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ArrayList<Item> items = new ArrayList<>();

		getServletContext().setAttribute("items", items); // this makes array a global variable ("key",value)
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Item> items = (ArrayList<Item>) getServletContext().getAttribute("items");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("CurrentUser");
		
		if (user != null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("    <title>Inventory</title>");
			out.println("    <meta charset='utf-8'>");
			out.println("    <link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
			out.println("    <style type='text/css'>");
			out.println("         form {");
			out.println("             margin: 10px 10px 10px 0;");
			out.println("        }");
			out.println("        .form-control {");
			out.println("             width: 150px;");
			out.println("             display: inline;");
			out.println("             border-radius: 0;");
			out.println("        }");
			out.println("        table {");
			out.println("             margin-bottom: 10px;");
			out.println("        }");
			out.println("        th {");
			out.println("             padding: 10px;");
			out.println("             background-color: rgba(0,255,0,0.1);");
			out.println("             color: #1e6120;");
			out.println("        }");
			out.println("        .btn {");
			out.println("             background-color: rgba(0,255,0,0.2);");
			out.println("             color:#1e6120;");
			out.println("            }");
			out.println("        .btn-default {");
			out.println("             border-color:#fff;");
			out.println("             color:#1e6120;");
			out.println("        }");
			out.println("        td { padding: 10px; }");
			out.println("        a {");
			out.println("             color:#1e6120;");
			out.println("             text-decoration: underline;");
			out.println("        }");
			out.println("    </style>");
			out.println("</head>");
			out.println("<body>");
			out.println("    <div class='container'>");
			out.println("        <form action='Inventory' method='GET'>");
			out.println("             <input type='text' class='form-control' placeholder='Search Query' name='query' />");
			out.println("             <input type='submit' class='btn btn-default' value='Search'/>");
			out.println("        </form>");
			if (items.size() == 0) {
				out.println("<h1><small> There are no items in your inventory. </small></h1>");
			} else {
				out.println("         <table class='table-bordered'>");
				out.println("             <tr>");
				out.println("                 <th> Name </th>");
				out.println("                 <th> Description </th>");
				out.println("                 <th> Quantity </th>");
				out.println("                 <th> Price </th>");
				out.println("                 <th> Actions </th>");
				out.println("            </tr>");
				out.println("            <tr>");
				for (Item item: items) {
					String query = request.getParameter("query");
					
					if (query == null || item.getName().contains( query.trim() ) || item.getDescription().contains( query.trim() ) ){
						out.println("<tr>");
						out.printf("	<td> %s </td>", item.getName());
						out.printf("	<td> %s </td>", item.getDescription());
						out.printf("	<td> %d </td>", item.getQuantity());
						out.printf("	<td> %.2f </td>", item.getPrice());
						out.printf("	<td> <a class='btn' href='Delete?id=%d'>Delete</a> </td>" ,item.getId());
						out.println("</tr>");
					}
				}
				out.println("             </tr>");
				out.println("        </table>");
			}
			out.println("        <a href='AddItem'><strong>Add Item</strong></a>");
			out.println( "		<p><a href='Logout'>Logout</a></p>" );
			out.println("    </div>");
			out.println("</body>");
			out.println("</html>");
		} else
			response.sendRedirect("Login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public static class Item {
		private Integer id, quantity;
		private String name, description;
		private Double price;

		public Item(Integer id, String name, String description,  Integer quantity, Double price) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.quantity = quantity;
			this.price = price;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String message) {
			this.description = description;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

	}
}