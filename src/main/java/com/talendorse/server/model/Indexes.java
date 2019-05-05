/*
 * This file is generated by jOOQ.
 */
package com.talendorse.server.model;


import com.talendorse.server.model.tables.Companies;
import com.talendorse.server.model.tables.Countries;
import com.talendorse.server.model.tables.Education;
import com.talendorse.server.model.tables.Formations;
import com.talendorse.server.model.tables.Languages;
import com.talendorse.server.model.tables.OfferFormation;
import com.talendorse.server.model.tables.Offers;
import com.talendorse.server.model.tables.OffersSkills;
import com.talendorse.server.model.tables.Referrals;
import com.talendorse.server.model.tables.Skills;
import com.talendorse.server.model.tables.Tokens;
import com.talendorse.server.model.tables.UserFormation;
import com.talendorse.server.model.tables.UserLanguage;
import com.talendorse.server.model.tables.Users;
import com.talendorse.server.model.tables.UsersSkills;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>database</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index COMPANIES_PRIMARY = Indexes0.COMPANIES_PRIMARY;
    public static final Index COMPANIES_WRWEG_IDX = Indexes0.COMPANIES_WRWEG_IDX;
    public static final Index COUNTRIES_PRIMARY = Indexes0.COUNTRIES_PRIMARY;
    public static final Index EDUCATION_FK_USER_ID_IDX = Indexes0.EDUCATION_FK_USER_ID_IDX;
    public static final Index EDUCATION_PRIMARY = Indexes0.EDUCATION_PRIMARY;
    public static final Index FORMATIONS_PRIMARY = Indexes0.FORMATIONS_PRIMARY;
    public static final Index LANGUAGES_PRIMARY = Indexes0.LANGUAGES_PRIMARY;
    public static final Index OFFER_FORMATION_FK_OFFER_FORMATION_FORMATION_IDX = Indexes0.OFFER_FORMATION_FK_OFFER_FORMATION_FORMATION_IDX;
    public static final Index OFFER_FORMATION_FK_OFFER_FORMATION_OFFER_IDX = Indexes0.OFFER_FORMATION_FK_OFFER_FORMATION_OFFER_IDX;
    public static final Index OFFER_FORMATION_PRIMARY = Indexes0.OFFER_FORMATION_PRIMARY;
    public static final Index OFFERS_FK_OFFER_COMPANY_IDX = Indexes0.OFFERS_FK_OFFER_COMPANY_IDX;
    public static final Index OFFERS_PRIMARY = Indexes0.OFFERS_PRIMARY;
    public static final Index OFFERS_SKILLS_OFFER_SKILLS_OFFER_IDX = Indexes0.OFFERS_SKILLS_OFFER_SKILLS_OFFER_IDX;
    public static final Index OFFERS_SKILLS_OFFER_SKILLS_SKILL_IDX = Indexes0.OFFERS_SKILLS_OFFER_SKILLS_SKILL_IDX;
    public static final Index OFFERS_SKILLS_PRIMARY = Indexes0.OFFERS_SKILLS_PRIMARY;
    public static final Index REFERRALS_CANDIDATO_IDX = Indexes0.REFERRALS_CANDIDATO_IDX;
    public static final Index REFERRALS_FK_OFFER_IDX = Indexes0.REFERRALS_FK_OFFER_IDX;
    public static final Index REFERRALS_JOBSTER_IDX = Indexes0.REFERRALS_JOBSTER_IDX;
    public static final Index REFERRALS_PRIMARY = Indexes0.REFERRALS_PRIMARY;
    public static final Index SKILLS_PRIMARY = Indexes0.SKILLS_PRIMARY;
    public static final Index TOKENS_FK_TOKEN_USER_IDX = Indexes0.TOKENS_FK_TOKEN_USER_IDX;
    public static final Index TOKENS_PRIMARY = Indexes0.TOKENS_PRIMARY;
    public static final Index TOKENS_TOKEN_UNIQUE = Indexes0.TOKENS_TOKEN_UNIQUE;
    public static final Index USER_FORMATION_FK_USER_FORMATION_FORMATION_IDX = Indexes0.USER_FORMATION_FK_USER_FORMATION_FORMATION_IDX;
    public static final Index USER_FORMATION_FK_USER_FORMATION_IDX = Indexes0.USER_FORMATION_FK_USER_FORMATION_IDX;
    public static final Index USER_FORMATION_PRIMARY = Indexes0.USER_FORMATION_PRIMARY;
    public static final Index USER_LANGUAGE_PRIMARY = Indexes0.USER_LANGUAGE_PRIMARY;
    public static final Index USER_LANGUAGE_USER_IDIOM_IDIOM_IDX = Indexes0.USER_LANGUAGE_USER_IDIOM_IDIOM_IDX;
    public static final Index USER_LANGUAGE_USUARIO_IDIOMA_IDX = Indexes0.USER_LANGUAGE_USUARIO_IDIOMA_IDX;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;
    public static final Index USERS_SKILLS_PRIMARY = Indexes0.USERS_SKILLS_PRIMARY;
    public static final Index USERS_SKILLS_SKILL_USER_IDX = Indexes0.USERS_SKILLS_SKILL_USER_IDX;
    public static final Index USERS_SKILLS_USERS_SKILLS_SKILL_IDX = Indexes0.USERS_SKILLS_USERS_SKILLS_SKILL_IDX;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index COMPANIES_PRIMARY = Internal.createIndex("PRIMARY", Companies.COMPANIES, new OrderField[] { Companies.COMPANIES.ID_COMPANY }, true);
        public static Index COMPANIES_WRWEG_IDX = Internal.createIndex("wrweg_idx", Companies.COMPANIES, new OrderField[] { Companies.COMPANIES.ID_COUNTRY }, false);
        public static Index COUNTRIES_PRIMARY = Internal.createIndex("PRIMARY", Countries.COUNTRIES, new OrderField[] { Countries.COUNTRIES.ID_COUNTRY }, true);
        public static Index EDUCATION_FK_USER_ID_IDX = Internal.createIndex("FK_user_id_idx", Education.EDUCATION, new OrderField[] { Education.EDUCATION.ID_USER }, false);
        public static Index EDUCATION_PRIMARY = Internal.createIndex("PRIMARY", Education.EDUCATION, new OrderField[] { Education.EDUCATION.ID_EDUCATION }, true);
        public static Index FORMATIONS_PRIMARY = Internal.createIndex("PRIMARY", Formations.FORMATIONS, new OrderField[] { Formations.FORMATIONS.ID_FORMATION }, true);
        public static Index LANGUAGES_PRIMARY = Internal.createIndex("PRIMARY", Languages.LANGUAGES, new OrderField[] { Languages.LANGUAGES.ID_LANGUAGE }, true);
        public static Index OFFER_FORMATION_FK_OFFER_FORMATION_FORMATION_IDX = Internal.createIndex("FK_OFFER_FORMATION_FORMATION_idx", OfferFormation.OFFER_FORMATION, new OrderField[] { OfferFormation.OFFER_FORMATION.ID_FORMATION }, false);
        public static Index OFFER_FORMATION_FK_OFFER_FORMATION_OFFER_IDX = Internal.createIndex("FK_OFFER_FORMATION_OFFER_idx", OfferFormation.OFFER_FORMATION, new OrderField[] { OfferFormation.OFFER_FORMATION.ID_OFFER }, false);
        public static Index OFFER_FORMATION_PRIMARY = Internal.createIndex("PRIMARY", OfferFormation.OFFER_FORMATION, new OrderField[] { OfferFormation.OFFER_FORMATION.ID_OFFER_FORMATION }, true);
        public static Index OFFERS_FK_OFFER_COMPANY_IDX = Internal.createIndex("FK_OFFER_COMPANY_idx", Offers.OFFERS, new OrderField[] { Offers.OFFERS.ID_COMPANY }, false);
        public static Index OFFERS_PRIMARY = Internal.createIndex("PRIMARY", Offers.OFFERS, new OrderField[] { Offers.OFFERS.ID_OFFER }, true);
        public static Index OFFERS_SKILLS_OFFER_SKILLS_OFFER_IDX = Internal.createIndex("offer_skills_offer_idx", OffersSkills.OFFERS_SKILLS, new OrderField[] { OffersSkills.OFFERS_SKILLS.ID_OFFER }, false);
        public static Index OFFERS_SKILLS_OFFER_SKILLS_SKILL_IDX = Internal.createIndex("offer_skills_skill_idx", OffersSkills.OFFERS_SKILLS, new OrderField[] { OffersSkills.OFFERS_SKILLS.ID_SKILL }, false);
        public static Index OFFERS_SKILLS_PRIMARY = Internal.createIndex("PRIMARY", OffersSkills.OFFERS_SKILLS, new OrderField[] { OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL }, true);
        public static Index REFERRALS_CANDIDATO_IDX = Internal.createIndex("candidato_idx", Referrals.REFERRALS, new OrderField[] { Referrals.REFERRALS.ID_CANDIDATE }, false);
        public static Index REFERRALS_FK_OFFER_IDX = Internal.createIndex("fk_offer_idx", Referrals.REFERRALS, new OrderField[] { Referrals.REFERRALS.ID_OFFER }, false);
        public static Index REFERRALS_JOBSTER_IDX = Internal.createIndex("jobster_idx", Referrals.REFERRALS, new OrderField[] { Referrals.REFERRALS.ID_ENDORSER }, false);
        public static Index REFERRALS_PRIMARY = Internal.createIndex("PRIMARY", Referrals.REFERRALS, new OrderField[] { Referrals.REFERRALS.ID_REFERRAL }, true);
        public static Index SKILLS_PRIMARY = Internal.createIndex("PRIMARY", Skills.SKILLS, new OrderField[] { Skills.SKILLS.ID_SKILL }, true);
        public static Index TOKENS_FK_TOKEN_USER_IDX = Internal.createIndex("FK_TOKEN_USER_idx", Tokens.TOKENS, new OrderField[] { Tokens.TOKENS.ID_USER }, false);
        public static Index TOKENS_PRIMARY = Internal.createIndex("PRIMARY", Tokens.TOKENS, new OrderField[] { Tokens.TOKENS.ID_TOKENS }, true);
        public static Index TOKENS_TOKEN_UNIQUE = Internal.createIndex("token_UNIQUE", Tokens.TOKENS, new OrderField[] { Tokens.TOKENS.TOKEN }, true);
        public static Index USER_FORMATION_FK_USER_FORMATION_FORMATION_IDX = Internal.createIndex("FK_USER_FORMATION_FORMATION_idx", UserFormation.USER_FORMATION, new OrderField[] { UserFormation.USER_FORMATION.ID_FORMATION }, false);
        public static Index USER_FORMATION_FK_USER_FORMATION_IDX = Internal.createIndex("FK_USER_FORMATION_idx", UserFormation.USER_FORMATION, new OrderField[] { UserFormation.USER_FORMATION.ID_USER }, false);
        public static Index USER_FORMATION_PRIMARY = Internal.createIndex("PRIMARY", UserFormation.USER_FORMATION, new OrderField[] { UserFormation.USER_FORMATION.ID_USER_FORMATION }, true);
        public static Index USER_LANGUAGE_PRIMARY = Internal.createIndex("PRIMARY", UserLanguage.USER_LANGUAGE, new OrderField[] { UserLanguage.USER_LANGUAGE.ID_USER_LANGUAGE }, true);
        public static Index USER_LANGUAGE_USER_IDIOM_IDIOM_IDX = Internal.createIndex("user_idiom_idiom_idx", UserLanguage.USER_LANGUAGE, new OrderField[] { UserLanguage.USER_LANGUAGE.ID_LANGUAGE }, false);
        public static Index USER_LANGUAGE_USUARIO_IDIOMA_IDX = Internal.createIndex("usuario_idioma_idx", UserLanguage.USER_LANGUAGE, new OrderField[] { UserLanguage.USER_LANGUAGE.ID_USER }, false);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.ID_USER }, true);
        public static Index USERS_SKILLS_PRIMARY = Internal.createIndex("PRIMARY", UsersSkills.USERS_SKILLS, new OrderField[] { UsersSkills.USERS_SKILLS.ID_USER_SKILL }, true);
        public static Index USERS_SKILLS_SKILL_USER_IDX = Internal.createIndex("skill_user_idx", UsersSkills.USERS_SKILLS, new OrderField[] { UsersSkills.USERS_SKILLS.ID_USER }, false);
        public static Index USERS_SKILLS_USERS_SKILLS_SKILL_IDX = Internal.createIndex("users_skills_skill_idx", UsersSkills.USERS_SKILLS, new OrderField[] { UsersSkills.USERS_SKILLS.ID_SKILL }, false);
    }
}
