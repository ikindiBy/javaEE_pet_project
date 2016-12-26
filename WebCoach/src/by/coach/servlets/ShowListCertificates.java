package by.coach.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.coach.beans.TeacherList;

@WebServlet("/ShowListCertificates")
public class ShowListCertificates extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowListCertificates() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		TeacherList tl = new TeacherList();
		int idTeacher = Integer.valueOf(request.getParameter("idTeach"));
		String nameTeacher = String.valueOf(tl.getNameById(idTeacher));

		try {

			ArrayList<byte[]> certList = tl.getListSerts(idTeacher);

			int countOfCertificates = certList.size();

			request.setAttribute("countOfCertificates", countOfCertificates);
			request.setAttribute("nameTeacher", nameTeacher);
			request.getSession().setAttribute("listOfCertificates", certList);
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/pages/sertificates_page.jsp");
			rd.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}

}
