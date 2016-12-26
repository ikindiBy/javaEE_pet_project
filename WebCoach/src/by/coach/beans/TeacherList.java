package by.coach.beans;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.coach.bd.DataBase;
import by.coach.utils.CheckTypeSkillExist;

public class TeacherList {

	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	Connection con = null;
	Statement stm = null;
	ResultSet rst = null;

	private ArrayList<Teacher> getTeachers(String str)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery(str);

			while (rst.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rst.getInt(1));
				teacher.setName(rst.getString("name"));
				teacher.setExperianceAge(rst.getInt("experience"));
				teacher.setTypeOfSkill(rst.getString("skillType"));
				teacher.setCost(rst.getInt("cost"));
				teacher.setPic(rst.getBytes("foto"));
				teacher.setUsername(rst.getString("username"));
				teacher.setPassword(rst.getString("password"));
				teacherList.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
		return teacherList;
	}

	public Teacher getTeacherByLogin(String login)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		Teacher teacher = new Teacher();
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			login = login.toLowerCase();
			ResultSet rst = stm
					.executeQuery("select * from coachsite.teacher where username = '"
							+ login + "'");

			while (rst.next()) {

				teacher.setId(rst.getInt(1));
				teacher.setName(rst.getString("name"));
				teacher.setExperianceAge(rst.getInt("experience"));
				teacher.setCost(rst.getInt("cost"));
				teacher.setUsername(rst.getString("username"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
		return teacher;
	}

	public String getNameById(int idTeacher) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		String name = null;
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm
					.executeQuery("select name from coachsite.teacher where idteacher ="
							+ idTeacher);

			while (rst.next()) {

				name = rst.getString("name");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
		return name;
	}

	public ArrayList<Teacher> getAllTeachers() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		return getTeachers("select t.idteacher, t.name, s.name AS skill, st.name as skillType, "
				+ "t.experience, t.cost, t.foto, t.username, t.password from coachsite.teacher t "
				+ "inner join coachsite.skill s ON t.skill_id=s.idskill "
				+ " inner join coachsite.skill_type st ON t.typeSkill_id=st.idskill_type");
	}

	public ArrayList<Teacher> getTeachersBySkill(long idSkill)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		if (idSkill == 0) {
			return getAllTeachers();
		} else {
			return getTeachers("select t.idteacher, t.name, s.name AS skill, st.name as skillType, "
					+ "t.experience, t.cost, t.foto, t.username, t.password from coachsite.teacher t "
					+ "inner join coachsite.skill s ON t.skill_id=s.idskill "
					+ " inner join coachsite.skill_type st ON t.typeSkill_id=st.idskill_type"
					+ " where t.skill_id=" + idSkill);
		}
	}

	public ArrayList<Teacher> getTeachersBySearch(String searchStr)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		if (searchStr == null) {
			return getAllTeachers();
		} else {
			return getTeachers("select t.idteacher, t.name, s.name AS skill, st.name as skillType, "
					+ " t.experience, t.cost, t.foto, t.username, t.password from coachsite.teacher t "
					+ " inner join coachsite.skill s ON t.skill_id=s.idskill "
					+ " inner join coachsite.skill_type st ON t.typeSkill_id=st.idskill_type "
					+ " WHERE LOWER (t.name) like '%"
					+ searchStr.toLowerCase()
					+ "%' OR "
					+ " LOWER (s.name) like '%"
					+ searchStr.toLowerCase()
					+ "%' OR "
					+ "LOWER (st.name) like '%"
					+ searchStr.toLowerCase()
					+ "%'");
		}
	}

	public ArrayList<Teacher> getTeachersByExperience(int exper)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		if (exper == 0) {
			return getAllTeachers();
		} else {
			return getTeachers("select t.idteacher, t.name, s.name AS skill, st.name as skillType, "
					+ " t.experience, t.cost, t.foto, t.username, t.password from coachsite.teacher t "
					+ " inner join coachsite.skill s ON t.skill_id=s.idskill "
					+ " inner join coachsite.skill_type st ON t.typeSkill_id=st.idskill_type "
					+ " WHERE  t.experience >=" + exper);
		}
	}

	public ArrayList<Teacher> getTeachersByExperiencePerSkill(
			ArrayList<Teacher> resultList, int exper)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		if (resultList == null) {
			return getTeachersByExperience(exper);
		} else {
			ArrayList<Teacher> newList = new ArrayList<Teacher>();
			for (Teacher teacher : (ArrayList<Teacher>) resultList) {
				if (teacher.getExperianceAge() >= exper)
					newList.add(teacher);
			}
			return newList;
		}
	}

	public ArrayList<Teacher> getTeacherList() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (!teacherList.isEmpty()) {
			return teacherList;
		} else {
			return getTeachers("select * from coachsite.teacher");
		}
	}

	public void addTeacher(Teacher newTeacher, int idSkill)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		try {
			// проверка наличия навыка в БД
			long idTypeSkill = CheckTypeSkillExist.check(
					newTeacher.getTypeOfSkill(), idSkill);
			if (idTypeSkill == -1) {
				TypeSkillList typeSkillList = new TypeSkillList();
				typeSkillList.addTypeOfSkill(newTeacher, idSkill);
				idTypeSkill = CheckTypeSkillExist.check(
						newTeacher.getTypeOfSkill(), idSkill);
			}
			if (newTeacher.getName() != null
					&& newTeacher.getExperianceAge() != 0 && idSkill != 0
					&& newTeacher.getUsername() != null
					&& newTeacher.getPassword() != null) {
				con = DataBase.getConnection();
				Statement stm = con.createStatement();
				stm.execute("INSERT INTO coachsite.teacher (`name`, `experience`, `skill_id`,  "
						+ "`typeSkill_id`, `username`, `password`, `cost`) VALUES "
						+ " ('"
						+ newTeacher.getName()
						+ "', '"
						+ newTeacher.getExperianceAge()
						+ "', '"
						+ idSkill
						+ "', '"
						+ idTypeSkill
						+ "', '"
						+ newTeacher.getUsername()
						+ "', '"
						+ newTeacher.getPassword()
						+ "', '"
						+ newTeacher.getCost() + "')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}

	public void addTeachersFoto(InputStream fotoStream, String login)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException {
		try {

			con = DataBase.getConnection();

			java.sql.PreparedStatement prepStmt = con
					.prepareStatement("UPDATE coachsite.teacher SET foto=? WHERE username=?");
			if (login != null && fotoStream.available() != 0) {
				prepStmt.setBlob(1, fotoStream);
				prepStmt.setString(2, login);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}

	public byte[] getContentPDF() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		byte[] content = null;
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm
					.executeQuery("select document from coachsite.sertificates WHERE idsert=1");

			while (rst.next()) {
				content = rst.getBytes("document");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
		return content;
	}

	public ArrayList<byte[]> getListSerts(int idTeacher)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		byte[] sertificate = null;

		ArrayList<byte[]> newListSert = new ArrayList<byte[]>();

		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm
					.executeQuery("select * from coachsite.sertificates WHERE idteacher="
							+ idTeacher);

			while (rst.next()) {
				sertificate = rst.getBytes("document");
				newListSert.add(sertificate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
		return newListSert;
	}

	// Добавление ПДФ сертификата в БД

	public void addSert(InputStream sertifStream, long idTeacher)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException {
		try {

			con = DataBase.getConnection();

			java.sql.PreparedStatement prepStmt = con
					.prepareStatement("insert coachsite.sertificates  (document, idteacher) VALUES(?, ?)");
			if (sertifStream.available() != 0) {
				prepStmt.setBlob(1, sertifStream);
				prepStmt.setLong(2, idTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}

	public void updateTeacher(Teacher newTeacher, long idTeacher, int idSkill)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		try {
			// проверка наличия навыка в БД
			long idTypeSkill = CheckTypeSkillExist.check(
					newTeacher.getTypeOfSkill(), idSkill);

			if (idTypeSkill == -1) {
				TypeSkillList typeSkillList = new TypeSkillList();
				typeSkillList.addTypeOfSkill(newTeacher, idSkill);
				idTypeSkill = CheckTypeSkillExist.check(
						newTeacher.getTypeOfSkill(), idSkill);
			}
			if (newTeacher.getName() != null
					&& newTeacher.getExperianceAge() != 0 && idSkill != 0
					&& newTeacher.getUsername() != null
					&& newTeacher.getPassword() != null) {

				con = DataBase.getConnection();
				Statement stm = con.createStatement();
				stm.execute("UPDATE coachsite.teacher SET name='"
						+ newTeacher.getName() + "', experience="
						+ newTeacher.getExperianceAge() + ", typeSkill_id="
						+ idTypeSkill + ", username='"
						+ newTeacher.getUsername() + "', password='"
						+ newTeacher.getPassword() + "', cost="
						+ newTeacher.getCost() + " WHERE idteacher="
						+ idTeacher);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (stm != null) {
					stm.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.err.println("Error: " + ex.getMessage());
			}
		}
	}
}
