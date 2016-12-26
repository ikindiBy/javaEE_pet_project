package by.coach.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TeacherExperServlet")
public class TeacherExperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherExperServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("exper_from") != null
				&& request.getParameter("exper_from") != "") {
			int experFrom = Integer.valueOf(request.getParameter("exper_from"));
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/pages/teachers.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/pages/main.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
