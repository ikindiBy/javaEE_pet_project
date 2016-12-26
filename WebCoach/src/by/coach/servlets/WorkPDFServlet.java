package by.coach.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WorkPDFServlet")
public class WorkPDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WorkPDFServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();

		try {

			ArrayList<byte[]> certList = (ArrayList<byte[]>) request
					.getSession().getAttribute("listOfCertificates");

			int numberOfCert = 0;
			if (request.getParameter("numberOfCert") != null
					&& request.getParameter("numberOfCert") != "") {
				numberOfCert = Integer.valueOf(request
						.getParameter("numberOfCert"));
			}

			byte[] content = certList.get(numberOfCert);
			response.setContentLength(content.length);
			out.write(content);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			out.close();
		}
	}

}
