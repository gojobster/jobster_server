package com.talendorse.server.BLL;

import com.talendorse.server.model.tables.records.SkillsRecord;
import com.talendorse.server.types.TalendorseErrorType;
import com.talendorse.server.model.Tables;

import java.util.List;

public class SkillsManagement {
    public static String addSkill(String skillName) throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        skillName = skillName.trim();

        SkillsRecord idiom = connection.create.select()
                .from(Tables.SKILLS)
                .where(Tables.SKILLS.NAME.equal(skillName))
                .fetchAnyInto(SkillsRecord.class);
        if (idiom != null) throw new TalendorseException(TalendorseErrorType.SKILL_ALREADY_EXISTS);

        SkillsRecord skill = connection.create.newRecord(Tables.SKILLS);
        skill.setName(skillName);

        skill.store();
        connection.closeConnection();
        return "OK";
    }

    public static List<String> getAllSkills() throws TalendorseException {
        ConnectionBDManager connection = new ConnectionBDManager();

        List<String> lst_skills = connection.create.select().from(Tables.SKILLS).fetch(Tables.SKILLS.NAME);

        connection.closeConnection();
        return lst_skills;
    }
}
