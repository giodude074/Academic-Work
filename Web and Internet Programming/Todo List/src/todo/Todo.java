package todo;

//CONTROLLER CLASS
import java.io.IOException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.PreparedStatement;

@WebServlet("/Labs/Todo")
public class Todo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver"); // loading the jdbc file
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create a list of z and then pas the list to the view for the
		// view to display
		ArrayList<Entry> archived = new ArrayList<Entry>();
		ArrayList<Entry> todos = new ArrayList<Entry>();
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu59";
			String username = "cs3220stu59";
			String password = "1Du2YtRZ";

			c = DriverManager.getConnection(url, username, password); // make a
																		// connection
			Statement stmt = c.createStatement();
			// returns list of results
			ResultSet rs = stmt.executeQuery("SELECT * FROM Todo WHERE Archive = 0"); // useexecutestatementto run a query

			while (rs.next()) { // goes to all entrys in table, at last result
								// "next" will return false
				// create new entry and add it.
				Entry entry = new Entry(rs.getInt("id"), rs.getString("title"), rs.getBoolean("done"),
						rs.getBoolean("archive"));
				todos.add(entry);
				// basically converts data from relational to objects, which
				// later converts to rows and columns
			}
			
			rs = stmt.executeQuery("SELECT * FROM Todo WHERE Archive = 1");
			
			while (rs.next()) { 
				archived.add(new Entry(rs.getInt("id"), rs.getString("title"), rs.getBoolean("done"),
						rs.getBoolean("archive")));
			}
			
			rs = stmt.executeQuery("SELECT COUNT(*) AS 'remaining' FROM Todo WHERE Done = 0");
			rs.next();
			request.setAttribute("remaining", rs.getInt("remaining") );
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
		// throw entry to the view
		request.setAttribute("todos", todos);
		request.setAttribute("archived", archived);
		request.getRequestDispatcher("/Labs/Todo.jsp").forward(request, response); // ("/WEB-INF/Labs/Todo.jsp")

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");

		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu59";
			String username = "cs3220stu59";
			String password = "1Du2YtRZ";

			String sql = "insert into Todo (title) values (?)";

			c = DriverManager.getConnection(url, username, password); // make a connection
																		
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, title); //getting the 1st question mark you encounter and assign it to a string
			pstmt.executeUpdate(); // update statements like insert and delete,
									// they dont return
									// a table like "ResultSet", thet typically
									// return an int.
									// int tells us how many rows are affected
									// by update statement, so we need 2
									// diffrent statements
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
		// send the user back to the todo page
		response.sendRedirect("Todo");
	}

}

