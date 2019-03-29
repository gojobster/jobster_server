package com.jobster.server.BLL;

import com.jobster.server.POCO.Company;
import com.jobster.server.model.tables.records.CompaniesRecord;
import org.jooq.DSLContext;

import static com.jobster.server.model.Tables.COMPANIES;
import static com.jobster.server.model.Tables.COUNTRIES;

public class CompaniesManagement {
    public static CompaniesRecord getCompanyRecord(DSLContext create, int id_company) {
        return create.select()
                .from(COMPANIES)
                .where(COMPANIES.ID_COMPANY.equal(id_company))
                .fetchAnyInto(CompaniesRecord.class);
    }

    public static Company getCompany(int id_company) {
        try {
            ConnectionBDManager connection = new ConnectionBDManager();
            CompaniesRecord company = connection.create.select()
                                        .from(COMPANIES)
                                        .where(COMPANIES.ID_COMPANY.equal(id_company))
                                        .fetchAnyInto(CompaniesRecord.class);

            String countryName = connection.create.select(COUNTRIES.NAME_ES).from(COUNTRIES).where(COUNTRIES.ID_COUNTRY.equal(company.getIdCountry())).fetchAnyInto(String.class);
            connection.closeConnection();

            return new Company(company, countryName);

        } catch (JobsterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
