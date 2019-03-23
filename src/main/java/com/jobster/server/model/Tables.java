/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model;


import com.jobster.server.model.tables.Companies;
import com.jobster.server.model.tables.Countries;
import com.jobster.server.model.tables.Education;
import com.jobster.server.model.tables.Idioms;
import com.jobster.server.model.tables.Offers;
import com.jobster.server.model.tables.OffersSkills;
import com.jobster.server.model.tables.Referrals;
import com.jobster.server.model.tables.Skills;
import com.jobster.server.model.tables.UserIdiom;
import com.jobster.server.model.tables.Users;
import com.jobster.server.model.tables.UsersSkills;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in jobster
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>jobster.companies</code>.
     */
    public static final Companies COMPANIES = com.jobster.server.model.tables.Companies.COMPANIES;

    /**
     * The table <code>jobster.countries</code>.
     */
    public static final Countries COUNTRIES = com.jobster.server.model.tables.Countries.COUNTRIES;

    /**
     * The table <code>jobster.education</code>.
     */
    public static final Education EDUCATION = com.jobster.server.model.tables.Education.EDUCATION;

    /**
     * The table <code>jobster.idioms</code>.
     */
    public static final Idioms IDIOMS = com.jobster.server.model.tables.Idioms.IDIOMS;

    /**
     * The table <code>jobster.offers</code>.
     */
    public static final Offers OFFERS = com.jobster.server.model.tables.Offers.OFFERS;

    /**
     * The table <code>jobster.offers_skills</code>.
     */
    public static final OffersSkills OFFERS_SKILLS = com.jobster.server.model.tables.OffersSkills.OFFERS_SKILLS;

    /**
     * The table <code>jobster.referrals</code>.
     */
    public static final Referrals REFERRALS = com.jobster.server.model.tables.Referrals.REFERRALS;

    /**
     * The table <code>jobster.skills</code>.
     */
    public static final Skills SKILLS = com.jobster.server.model.tables.Skills.SKILLS;

    /**
     * The table <code>jobster.users</code>.
     */
    public static final Users USERS = com.jobster.server.model.tables.Users.USERS;

    /**
     * The table <code>jobster.users_skills</code>.
     */
    public static final UsersSkills USERS_SKILLS = com.jobster.server.model.tables.UsersSkills.USERS_SKILLS;

    /**
     * The table <code>jobster.user_idiom</code>.
     */
    public static final UserIdiom USER_IDIOM = com.jobster.server.model.tables.UserIdiom.USER_IDIOM;
}
