package by.coach.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import by.coach.beans.Teacher;
import by.coach.beans.TeacherList;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileDownloadServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TeacherList tl = new TeacherList();

		Part partFoto = request.getPart("foto");
		Part partFile = request.getPart("file");

		InputStream fotoStream = null;
		InputStream fileStream = null;
		boolean flagFrom = false;

		HttpSession session = request.getSession();
		String login = String.valueOf(session.getAttribute("username"));
		if (session.getAttribute("from_reg_page") != null) {
			flagFrom = (boolean) session.getAttribute("from_reg_page");
		}
		System.out.println("We have login after registration: " + login
				+ "_flagFrom is_" + flagFrom + "_size foto_" + "_");

		if (partFile == null && partFoto != null) {

			fotoStream = partFoto.getInputStream();

			System.out.println("block 1");
			try {

				tl.addTeachersFoto(fotoStream, login);
				if (flagFrom) {
					RequestDispatcher rd = request.getServletContext()
							.getRequestDispatcher("/pages/add_foto.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getServletContext()
							.getRequestDispatcher("/pages/update_foto_cert.jsp");
					rd.forward(request, response);
				}
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

		if (partFile != null && partFoto == null) {
			System.out.println("block 2");
			fileStream = partFile.getInputStream();
			try {

				Teacher t = tl.getTeacherByLogin(login);

				tl.addSert(fileStream, t.getId());

				if (flagFrom) {
					RequestDispatcher rd = request.getServletContext()
							.getRequestDispatcher("/pages/add_foto.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request
							.getServletContext()
							.getRequestDispatcher("/pages/update_foto_cert.jsp");
					rd.forward(request, response);
				}

			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException e) {

				e.printStackTrace();
			}
		}

	}
}
