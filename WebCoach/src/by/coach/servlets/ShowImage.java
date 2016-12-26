package by.coach.servlets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.coach.beans.Teacher;

public class ShowImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowImage() {
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
		response.setContentType("image/jpeg");

		OutputStream out = response.getOutputStream();

		try {
			int index = Integer.valueOf(request.getParameter("index"));
			ArrayList<Teacher> listTeach = (ArrayList<Teacher>) request
					.getSession(false).getAttribute("currentTeachList");
			Teacher teach = listTeach.get(index);
			if (teach.getPic() != null) {
				response.setContentLength(teach.getPic().length);
				out.write(teach.getPic());
			}

			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File("d:/nofo.jpg"));

			// конвертация изображения в массив байтов
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
			response.setContentLength(imageInByte.length);
			out.write(imageInByte);

		} finally {
			out.close();
		}

	}
}
