package store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Store/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create the collection in the servlet context to be used by all other servlets
		ArrayList<User> users = new ArrayList<User>();
		
		// Pre-Populate your users database with the following accounts
		users.add(new User("John", "Doe", "john@doe.com", "aa"));
		users.add(new User("Mary", "Jane", "mary@jane.com", "bb"));
		users.add(new User("Joe", "Boxer", "joe@boxer.com", "cc"));
		
		// Add the users list to the global scope
		getServletContext().setAttribute("users", users);
	}

    private String getEmailFromCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null)
			for (Cookie cookie : cookies)
				if (cookie.getName().equals("username"))
					return cookie.getValue();
		return null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("    <head>");
		out.println("        <title>Login</title>");
		out.println("        <meta charset='utf-8'>");
		out.println("        <link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		out.println("        <style type='text/css'>");
		out.println("        body {");
		out.println("             background-color: rgba(0,255,0,0.3);");
		//out.println("             background-image: url('img_tree.gif');");
		out.println("             text-align: center;");
		out.println("             padding-top: 50px;");
		out.println("        }");
		out.println("        .container {");
		out.println("             background-color: white;");
		out.println("");
		out.println("        }");
		out.println("        #page-wrap {");
		out.println("             text-align: left;");
		out.println("             width: 400px;");
		out.println("             margin: 0 auto;");
		out.println("");
		out.println("        }");
		out.println("        form {");
		out.println("                 margin: 20px 10px 30px 10px;");
		out.println("            }");
		out.println("            .form-control {");
		out.println("                 width: 150px;");
		out.println("                 border-radius: 0;");
		out.println("            }");
		out.println("            .btn {");
		out.println("                 background-color: rgba(0,255,0,0.2);");
		out.println("                 color:#1e6120;");
		out.println("                }");
		out.println("            .btn-default {");
		out.println("                 border-color:#fff;");
		out.println("                 color:#1e6120;");
		out.println("            }");
		out.println("            input[type='checkbox'] {");
		out.println("                display: inline;");
		out.println("                margin-bottom: 20px;");
		out.println("");
		out.println("            }");
		out.println("");
		out.println("");
		out.println("        </style>");
		out.println("    </head>");
		out.println("    <body>");
		out.println("         <div class='container' id='page-wrap' >");
		String error = (String) request.getAttribute("error");
        
        if (error != null)
        	out.printf("<h4 style='color: #f00;'> %s </h4>", error);
     // Read the username and password if it exists
        String email = request.getParameter("email") == null ? "" : request.getParameter("email");
        String password = request.getParameter("password") == null ? "" : request.getParameter("password");
		out.println("             <form action='Login' method='POST'>");
		out.println("                 <lable> Email: </lable>");
		out.printf("                 <input type='text' class='form-control' name='email' value='%s'/> <br />", email);
		out.println("                 <lable> Password: </lable>");
		out.printf("                 <input type='password' class='form-control' name='password' value='%s' /> <br />", password);
		
	//	String username = getEmailFromCookie(request);
		out.println("                 <input type='checkbox' name='rememberMe' value='RememberMe'> Remember Me<br>");
		out.println("                 <input type='submit' class='btn' name='login' value='Login' /> <br />");
		out.println("             </form>");
		out.println("        </div>");
		out.println("");
		out.println("    </body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		@SuppressWarnings("unchecked")
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users"); //getting users
//		boolean hasError = false;
		
		for( User user: users) {
			if (email.equals(user.getEmail())) {
				if (password.equals(user.getPassword())) {
					if (request.getParameter("rememberMe") != null ){
						Cookie cookie = new Cookie("username", email);
						cookie.setMaxAge(1800);//30 min
						response.addCookie(cookie);
					}
					request.getSession().setAttribute("CurrentUser", user);
					response.sendRedirect("Inventory");
				} else {
		        	request.setAttribute("error", "Invalid email and/or password");
		        	doGet(request, response);
				}
			} 
		}

		//Email Error Vallidation
//		if (!hasError) {
			doGet(request, response);
			request.setAttribute("error", "Invalid email and/or password");
			return;
//		}

//		if (email.equals("john@doe.com") && password.equals("aa") ||
//				email.equals("mary@jane.com") && password.equals("bb") ||
//				email.equals("joe@boxer.com") && password.equals("cc")){
//			session.setAttribute("CurrentUser", user);
//			response.sendRedirect("Inventory");
//		}else
//        	request.setAttribute("error", "Invalid email and/or password");
//			doGet(request, response);
//			//response.sendRedirect("Loginn");
	}
}
