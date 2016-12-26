package by.coach.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.coach.beans.Teacher;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "username";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_GUEST = "guest";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		Boolean stateGuest = Boolean.valueOf(request.getParameter(PARAM_GUEST));

		if (LoginLogic.checkLogin(login, password)) {
			request.setAttribute("user", login);
			HttpSession session = request.getSession();
			Teacher tea = LoginLogic.getByNameAndPass(login, password);

			session.setAttribute("userData", tea);

			page = ConfigurationManager.getProperty("path.page.main");

		} else if (login == "" && password == "" && stateGuest) {
			HttpSession session = request.getSession();
			Teacher tea = new Teacher();
			tea.setName("Student");
			tea.setUsername("guest");
			tea.setTypeOfSkill("learning");

			session.setAttribute("userData", tea);
			page = ConfigurationManager.getProperty("path.page.main");

		} else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.index");
		}
		return page;
	}

}
