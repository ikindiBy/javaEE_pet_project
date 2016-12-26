package by.coach.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchFormServlet")
public class SearchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchFormServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/pages/teachers.jsp");
		rd.forward(request, response);

	}

}
