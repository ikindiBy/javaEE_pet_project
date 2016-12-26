package by.coach.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.coach.bd.DataBase;
import by.coach.beans.Teacher;

public class UserLogin {

	public Teacher getByNameAndPass(String username, String password) {

		Connection con = null;
		Statement stm = null;
		ResultSet rst = null;
		Teacher teacher = new Teacher();

		try {
			con = DataBase.getConnection();
			stm = con.createStatement();

			String str = "select t.idteacher, t.name, s.name AS skill, st.name as skillType, "
					+ "t.experience, t.foto, t.username, t.password from coachsite.teacher t "
					+ "inner join coachsite.skill s ON t.skill_id=s.idskill "
					+ " inner join coachsite.skill_type st ON t.typeSkill_id=st.idskill_type "
					+ " where t.username='"
					+ username
					+ "'"
					+ " and t.password='" + password + "'";

			rst = stm.executeQuery(str);

			if (rst != null) {
				teacher.setId(rst.getInt(1));
				teacher.setName(rst.getString("name"));
				teacher.setExperianceAge(rst.getInt("experience"));
				teacher.setTypeOfSkill(rst.getString("skillType"));
				teacher.setPic(rst.getBytes("foto"));
				return teacher;
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
		return null;
	}

}
