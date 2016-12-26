package by.coach.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.coach.beans.Teacher;
import by.coach.beans.TeacherList;
import by.coach.controller.MessageManager;
import by.coach.utils.CheckLoginRegistration;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login_from_form = String.valueOf(request
				.getParameter("login_form"));
		String password_from_form = String.valueOf(request
				.getParameter("password_form"));
		String name_from_form = String.valueOf(request
				.getParameter("name_form"));
		String type_skill_from_form = String.valueOf(request
				.getParameter("type_skill_form"));

		int experFrom = 0;
		int cost_from_form = 0;
		int skillId = 0;

		if (request.getParameter("skill") != null
				&& request.getParameter("skill") != "") {
			skillId = Integer.valueOf(request.getParameter("skill"));
		}
		if (request.getParameter("experience_form") != null
				&& request.getParameter("experience_form") != "") {
			experFrom = Integer
					.valueOf(request.getParameter("experience_form"));
		}
		if (request.getParameter("cost_form") != null
				&& request.getParameter("cost_form") != "") {

			cost_from_form = Integer.valueOf(request.getParameter("cost_form"));
		}

		Teacher newTeacher = new Teacher();
		newTeacher.setUsername(login_from_form);
		newTeacher.setPassword(password_from_form);
		newTeacher.setName(name_from_form);
		newTeacher.setTypeOfSkill(type_skill_from_form);
		newTeacher.setExperianceAge(experFrom);
		newTeacher.setCost(cost_from_form);

		try {
			if (!CheckLoginRegistration.check(login_from_form)) {
				request.setAttribute("errorDoubleLogin",
						MessageManager.getProperty("message.existing_user"));
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/pages/registration.jsp");
				rd.forward(request, response);

			} else if (login_from_form == null || password_from_form == null
					|| name_from_form == null || type_skill_from_form == null
					|| experFrom == 0 || cost_from_form == 0) {
				request.setAttribute("errorEmptyData",
						MessageManager.getProperty("message.empty_field"));
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/pages/registration.jsp");
				rd.forward(request, response);

			} else {

				try {
					TeacherList tl = new TeacherList();
					tl.addTeacher(newTeacher, skillId);

				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {

					e.printStackTrace();
				}

				HttpSession session = request.getSession();
				session.setAttribute("username", login_from_form);
				session.setAttribute("from_reg_page", true);
				RequestDispatcher rd = request.getServletContext()
						.getRequestDispatcher("/pages/add_foto.jsp");
				rd.forward(request, response);

			}

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
