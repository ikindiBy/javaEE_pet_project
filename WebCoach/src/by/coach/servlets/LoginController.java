package by.coach.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.coach.controller.ActionCommand;
import by.coach.controller.ActionFactory;
import by.coach.controller.ConfigurationManager;
import by.coach.controller.MessageManager;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		page = command.execute(request);

		if (request.getParameter("username") != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", request.getParameter("username"));
		}

		if (Boolean.valueOf(request.getParameter("guest"))
				&& request.getParameter("username") == "") {
			HttpSession session = request.getSession();
			session.setAttribute("username", "guest");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/pages/main.jsp");

			dispatcher.forward(request, response);

		} else if (page != null) {
			request.getSession().setAttribute("button_edit",
					MessageManager.getProperty("message.button_edit"));
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}

}
