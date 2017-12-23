package todo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs/Archive")
public class Archive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu59";
			String username = "cs3220stu59";
			String password = "1Du2YtRZ";

			String sql = "UPDATE Todo SET Archive = 1 WHERE Done = 1 AND Archive = 0"; //Done = state = action
			
			c = DriverManager.getConnection(url, username, password); // make a connection
			c.prepareStatement(sql).executeUpdate();
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