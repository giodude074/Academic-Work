package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu59";
			String username = "cs3220stu59";
			String password = "1Du2YtRZ";
					
			c = DriverManager.getConnection(url, username, password); // make a connection
																		
			PreparedStatement pstmt = c.prepareStatement("UPDATE Todo SET Done = ? WHERE ID = ?");
			String state = request.getParameter("state");
			if (state.equals("done")){
				pstmt.setBoolean(1, true);
				pstmt.setInt(2, id);
				pstmt.executeUpdate(); 
			}
			else if (state.equals("notdone")) {
				pstmt.setBoolean(1, false);
				pstmt.setInt(2, id);
				pstmt.executeUpdate(); 
			}
			else {
				pstmt = c.prepareStatement("UPDATE Todo SET Done = 0, Archive = 0 WHERE ID = ?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			}
		}

		catch (SQLException e) {
			throw new ServletException(e);
		}

		finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		response.sendRedirect("Todo");
	}

}
