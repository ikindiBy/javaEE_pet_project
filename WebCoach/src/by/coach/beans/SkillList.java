package by.coach.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.coach.bd.DataBase;

public class SkillList {
	private ArrayList<Skill> skillList = new ArrayList<Skill>();
	Connection con = null;
	Statement stm = null;
	ResultSet rst = null;

	private ArrayList<Skill> getSkills() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		try {
			con = DataBase.getConnection();
			Statement stm = con.createStatement();
			ResultSet rst = stm.executeQuery("select * from coachsite.skill");
			while (rst.next()) {
				Skill skill = new Skill();
				skill.setId(rst.getInt(1));
				skill.setName(rst.getString(2));
				skillList.add(skill);
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
		return skillList;
	}

	public ArrayList<Skill> getSkillList() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		if (!skillList.isEmpty()) {
			return skillList;
		} else {
			return getSkills();
		}
	}
}
