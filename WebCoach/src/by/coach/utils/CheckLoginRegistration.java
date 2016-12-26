package by.coach.utils;

import by.coach.beans.Teacher;
import by.coach.beans.TeacherList;

public class CheckLoginRegistration {

	public static boolean check(String loginNew) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		TeacherList tl = new TeacherList();
		boolean result = true;
		for (Teacher teach : tl.getAllTeachers()) {

			if (teach.getUsername().equals(loginNew)) {
				result = false;
				break;
			}

		}
		return result;
	}
}
