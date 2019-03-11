package com.jobster.server.BLL;

import com.jobster.server.model.tables.records.IdiomsRecord;
import com.jobster.server.model.tables.records.SkillsRecord;
import com.jobster.server.types.JobsterErrorType;
import com.jobster.server.util.Fechas;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.jobster.server.model.Tables.IDIOMS;
import static com.jobster.server.model.Tables.SKILLS;

public class SkillsManagement {
    public static String addSkill(String skillName) throws JobsterException {
        try {
            Class.forName(Constantes.DB_DRIVER).newInstance();
            Connection conn = DriverManager.getConnection(Constantes.DB_URL, Constantes.DB_USER, Constantes.DB_PASS);
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            skillName = skillName.trim();

            SkillsRecord idiom = create.select()
                    .from(SKILLS)
                    .where(SKILLS.NAME.equal(skillName))
                    .fetchAnyInto(SkillsRecord.class);
            if (idiom != null) throw new JobsterException(JobsterErrorType.SKILL_ALREADY_EXISTS);

            SkillsRecord skill = create.newRecord(SKILLS);
            skill.setName(skillName);
            skill.setDateCreated(Fechas.GetCurrentTimestampLong());

            skill.store();
            create.close();
            conn.close();
        }
        catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException ex) {
            throw new JobsterException(JobsterErrorType.GENERIC_ERROR);
        }
        return "OK";
    }
}
