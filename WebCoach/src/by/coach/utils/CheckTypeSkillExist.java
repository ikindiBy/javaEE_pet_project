package by.coach.utils;

import by.coach.beans.TypeSkill;
import by.coach.beans.TypeSkillList;

public class CheckTypeSkillExist {

	public static long check(String typeFromForm, long idSkillFromForm)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		TypeSkillList tsl = new TypeSkillList();
		long idTypeSkill = -1;
		for (TypeSkill type : tsl.getSkillList()) {

			if (type.getName().toLowerCase()
					.equals(typeFromForm.toLowerCase().trim())
					&& type.getIdSkill() == idSkillFromForm) {

				idTypeSkill = type.getId();
				break;
			}

		}
		return idTypeSkill;
	}

}
