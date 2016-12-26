package by.coach.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.coach.bd.DataBase;

public class TypeSkillList {

	private ArrayList<TypeSkill> typeSkillList = new ArrayList<TypeSkill>();
	Connection con = null;
	Statement stm = null;
	ResultSet rst = null;

	private ArrayList<TypeSkill> getTypeSkills() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm
					.executeQuery("select * from coachsite.skill_type");
			while (rst.next()) {

				TypeSkill typeSkill = new TypeSkill();

				typeSkill.setId(rst.getInt("idskill_type"));
				typeSkill.setName(rst.getString("name"));
				typeSkill.setIdSkill(rst.getInt("skill_id"));
				typeSkillList.add(typeSkill);

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
		return typeSkillList;
	}

	public ArrayList<TypeSkill> getSkillList() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (!typeSkillList.isEmpty()) {
			return typeSkillList;
		} else {
			return getTypeSkills();
		}
	}

	public void addTypeOfSkill(Teacher newTeacher, int idSkill)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		try {
			if (newTeacher.getTypeOfSkill() != null && idSkill != 0) {
				con = DataBase.getConnection();
				Statement stm = con.createStatement();
				stm.execute("INSERT INTO coachsite.skill_type (`name`, `skill_id`)  "
						+ "VALUES ('"
						+ newTeacher.getTypeOfSkill()
						+ "', '"
						+ idSkill + "')");
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
