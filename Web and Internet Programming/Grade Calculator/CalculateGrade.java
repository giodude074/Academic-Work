package labs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Labs/CalculateGrade")
public class CalculateGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("    <head>");
		out.println("        <title>Grade Calculator</title>");
		out.println("        <meta charset='utf-8'>");
		out.println("        <link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		out.println("        <style type='text/css'>");
		out.println("            .form-control {");
		out.println("                margin: 0 0 20px 10px;");
		out.println("                display: inline;");
		out.println("                width: 150px;");
		out.println("            }");
		out.println("            /*specifies what kind of input you want to alter*/");
		out.println("            input[type='text'] { display: inline; }");
		out.println("            label { display: block; }");
		out.println("            p { display: inline; }");
		out.println("            .btn {");
		out.println("                display: inline;");
		out.println("                background-color: green;");
		out.println("                color: white;");
		out.println("            }");
		out.println("			#buttonLine { ");
		out.println("				display: block;");
		out.println("				margin-left: 166px;");
		out.println("			}");
		out.println("            #total {");
		out.println("                display: inline;");
		out.println("                margin: 0 0 20px 10px;");
		out.println("            }");
		out.println("            .btn:hover { color: white; }");
		out.println("            h3 { display: inline; }");
		out.println("			.page-header { width: 444px; }");
		out.println("        </style>");
		out.println("    </head>");
		out.println("    <body>");
		out.println(" 		 <div class='container'>");
		out.println("        <div class='page-header'><h1> <small> Grade Calculator </small> </h1></div>");
		out.println("        <form action='CalculateGrade' method='POST'>");
		out.println("            <label>Attendance:</label>");
		out.println("            <input type='text' class='form-control' name='possible_attendance' value='100.0' />");
		out.println("            <input type='text' class='form-control' name='my_attendance' value='100.0' />");
		out.println("            <p> - / 5%</p>");
		out.println("            <label>HW and Labs:</label>");
		out.println("            <input type='text' class='form-control' name='possible_hwlabs' value='100.0' />");
		out.println("            <input type='text' class='form-control' name='my_hwlabs' value='100.0' />");
		out.println("            <p> - / 20.00%</p>");
		out.println("            <label>Quizes:</label>");
		out.println("            <input type='text' class='form-control' name='possible_quizzes' value='100.0' />");
		out.println("            <input type='text' class='form-control' name='my_quizzes' value='100.0' />");
		out.println("            <p> - / 25.00%</p>");
		out.println("            <label>Midterm:</label>");
		out.println("            <input type='text' class='form-control' name='possible_midterm' value='100.0' />");
		out.println("            <input type='text' class='form-control' name='my_midterm' value='100.0' />");
		out.println("            <p> - / 25.00%</p>");
		out.println("            <label>Final:</label>");
		out.println("            <input type='text' class='form-control' name='possible_final' value='100.0' />");
		out.println("            <input type='text' class='form-control' name='my_final' value='100.0' />");
		out.println("            <p> - / 25.00%</p>");
		out.println("			 <div id='buttonLine'><input type='submit' class='btn' value='Calculate' />");
		out.println("            <label id='total'><h3>Total: </h3></label> - / 100.0%</div>");
		out.println("        </form>");
		out.println(" 		 </div>");
		out.println("    </body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double possibleAttendance = Double.parseDouble(request.getParameter("possible_attendance"));
		double myAttendance = Double.parseDouble(request.getParameter("my_attendance"));
		double attendance = (myAttendance/possibleAttendance)*0.05*100.0;

		//my score/possible * 0.05 * 100
		double possibleHwlabs = Double.parseDouble(request.getParameter("possible_hwlabs"));
		double myHwlabs = Double.parseDouble(request.getParameter("my_hwlabs"));
		double hwlabs = (myHwlabs/possibleHwlabs)*0.20*100.0;
		
		double possibleQuizzes = Double.parseDouble(request.getParameter("possible_quizzes"));
		double myQuizzes = Double.parseDouble(request.getParameter("my_quizzes"));
		double quizzes = (myQuizzes/possibleQuizzes)*0.25*100.0;
		
		double possibleMidterm = Double.parseDouble(request.getParameter("possible_midterm"));
		double myMidterm = Double.parseDouble(request.getParameter("my_midterm"));
		double midterm = (myMidterm/possibleMidterm)*0.25*100.0;
		
		double possibleFinal = Double.parseDouble(request.getParameter("possible_final"));
		double myFinal = Double.parseDouble(request.getParameter("my_final"));
		double finalGrade = (myFinal/possibleFinal)*0.25*100.0;
		
		double totalGrade = ((myAttendance +  myHwlabs + myQuizzes + myMidterm + myFinal ) / (possibleAttendance + possibleHwlabs + possibleQuizzes + possibleMidterm + possibleFinal)*100);

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("    <head>");
		out.println("        <title>Grade Calculator</title>");
		out.println("        <meta charset='utf-8'>");
		out.println("        <link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>");
		out.println("        <style type='text/css'>");
		out.println("            .form-control {");
		out.println("                margin: 0 0 20px 10px;");
		out.println("                display: inline;");
		out.println("                width: 150px;");
		out.println("            }");
		out.println("            /*specifies what kind of input you want to alter*/");
		out.println("            input[type='text'] { display: inline; }");
		out.println("            label { display: block; }");
		out.println("            p { display: inline; }");
		out.println("            .btn {");
		out.println("                display: inline;");
		out.println("                background-color: green;");
		out.println("                color: white;");
		out.println("            }");
		out.println("			#buttonLine { ");
		out.println("				display: block;");
		out.println("				margin-left: 166px;");
		out.println("			}");
		out.println("            #total {");
		out.println("                display: inline;");
		out.println("                margin: 0 0 20px 10px;");
		out.println("            }");
		out.println("            h3 { display: inline; }");
		out.println("			.page-header { width: 444px; }");
		out.println("        </style>");
		out.println("    </head>");
		out.println("    <body>");
		out.println(" 		 <div class='container'>");
		out.println("		<div class='page-header'> <h1> <small> Grade Calculator </small> </h1> </div>");
		out.println("        <form action='CalculateGrade' method='POST'>");
		out.println("            <label>Attendance:</label>");
		out.printf("            <input type='text' class='form-control' name='possible_attendance' value='%.2f' />", possibleAttendance);
		out.printf("            <input type='text' class='form-control' name='my_attendance' value='%.2f' />", myAttendance);
		out.printf("            <p> %.2f%% / 5%%</p>", attendance);
		out.println("            <label>HW and Labs:</label>");
		out.printf("            <input type='text' class='form-control' name='possible_hwlabs' value='%.2f' />", possibleHwlabs);
		out.printf("            <input type='text' class='form-control' name='my_hwlabs' value='%.2f' />", myHwlabs);
		out.printf("            <p> %.2f%% / 20.00%%</p>", hwlabs);
		out.println("            <label>Quizes:</label>");
		out.printf("            <input type='text' class='form-control' name='possible_quizzes' value='%.2f' />", possibleQuizzes);
		out.printf("            <input type='text' class='form-control' name='my_quizzes' value='%.2f' />", myQuizzes);
		out.printf("            <p> %.2f%% / 25.00%%</p>", quizzes);
		out.println("            <label>Midterm:</label>");
		out.printf("            <input type='text' class='form-control' name='possible_midterm' value='%.2f' />", possibleMidterm);
		out.printf("            <input type='text' class='form-control' name='my_midterm' value='%.2f' />", myMidterm);
		out.printf("            <p> %.2f%% / 25.00%%</p>", midterm);
		out.println("            <label>Final:</label>");
		out.printf("            <input type='text' class='form-control' name='possible_final' value='%.2f' />", possibleFinal);
		out.printf("            <input type='text' class='form-control' name='my_final' value='%.2f' />", myFinal);
		out.printf("            <p> %.2f%% / 25.00%%</p>", finalGrade);
		out.println("			<div id='buttonLine'><input type='submit' class='btn' value='Calculate' />");
		out.printf("           <label id='total'><h3>Total: </h3></lable> %.2f%% / 100.00%%</div>", totalGrade);
		out.println("        </form>");
		out.println(" 		 </div>");
		out.println("    </body>");
		out.println("</html>");
	}
}