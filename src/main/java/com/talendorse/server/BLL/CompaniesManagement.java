package com.talendorse.server.BLL;

import com.talendorse.server.POCO.Company;
import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.Tables;
import org.jooq.DSLContext;

public class CompaniesManagement {
    public static CompaniesRecord getCompanyRecord(DSLContext create, int id_company) {
        return create.select()
                .from(Tables.COMPANIES)
                .where(Tables.COMPANIES.ID_COMPANY.equal(id_company))
                .fetchAnyInto(CompaniesRecord.class);
    }

    public static Company getCompany(int id_company) {
        try {
            ConnectionBDManager connection = new ConnectionBDManager();
            CompaniesRecord company = connection.create.select()
                                        .from(Tables.COMPANIES)
                                        .where(Tables.COMPANIES.ID_COMPANY.equal(id_company))
                                        .fetchAnyInto(CompaniesRecord.class);

            String countryName = connection.create.select(Tables.COUNTRIES.NAME_ES).from(Tables.COUNTRIES).where(Tables.COUNTRIES.ID_COUNTRY.equal(company.getIdCountry())).fetchAnyInto(String.class);
            connection.closeConnection();

            return new Company(company, countryName);

        } catch (TalendorseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
