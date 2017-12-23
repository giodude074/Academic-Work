package labs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs/AboutMe")
public class AboutMe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AboutMe() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>About Me</title></head><body>");
		out.println("<form action='AboutMe' method='POST'>");
		out.println("Type in your CIN: <input type='text' name= 'cin'/><br />");
		out.println("<input type='submit' name='enter' value='Enter'/>");
		out.println("</form>");
		out.println("</body> </html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Read the cin that was submitted by the form
		String cin = request.getParameter("cin");

		if (cin == null || !(cin.equals("123456789"))) {
			doGet(request, response);
			return;
		} else {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>About Me</title></head><body>");
			out.println("<h2>About Me</h2>");
			out.println("<div id='name'> Giovanni Garcia </div>");
			out.println("<div id='content'> "
					+ "<p class='description'> I am a beginner and the language I have developed in so far is java.</p> "
					+ "<p class='description'> I expect to be able to know how to make full functioning webpages by the end of this course; that is what I am here for. I believe that knowing how to make webages is a very important skill that MUST be learned. I plan on working on my own website, and making websites for friends so I can practice. I want to eventually be able to put on my resume that I know how to make webpages. </p>"
					+ "<p class='description'>I absolutely love Pokemon (and no, not because of the Pokemon Go game that recently came out). I'm also kind of a crazy bird lady; my 5 birds are my babies.</p>"
					+ "</div>");
			out.println("</body> </html>");

		}
	}
}
