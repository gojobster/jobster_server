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
import com.talendorse.server.model.tables.ViewsUser;
import com.talendorse.server.model.tables.records.CompaniesRecord;
import com.talendorse.server.model.tables.records.CountriesRecord;
import com.talendorse.server.model.tables.records.EducationRecord;
import com.talendorse.server.model.tables.records.FormationsRecord;
import com.talendorse.server.model.tables.records.LanguagesRecord;
import com.talendorse.server.model.tables.records.OfferFormationRecord;
import com.talendorse.server.model.tables.records.OffersRecord;
import com.talendorse.server.model.tables.records.OffersSkillsRecord;
import com.talendorse.server.model.tables.records.ReferralsRecord;
import com.talendorse.server.model.tables.records.SkillsRecord;
import com.talendorse.server.model.tables.records.TokensRecord;
import com.talendorse.server.model.tables.records.UserFormationRecord;
import com.talendorse.server.model.tables.records.UserLanguageRecord;
import com.talendorse.server.model.tables.records.UsersRecord;
import com.talendorse.server.model.tables.records.UsersSkillsRecord;
import com.talendorse.server.model.tables.records.ViewsUserRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>database</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<EducationRecord, Integer> IDENTITY_EDUCATION = Identities0.IDENTITY_EDUCATION;
    public static final Identity<LanguagesRecord, Integer> IDENTITY_LANGUAGES = Identities0.IDENTITY_LANGUAGES;
    public static final Identity<OfferFormationRecord, Integer> IDENTITY_OFFER_FORMATION = Identities0.IDENTITY_OFFER_FORMATION;
    public static final Identity<OffersRecord, Integer> IDENTITY_OFFERS = Identities0.IDENTITY_OFFERS;
    public static final Identity<OffersSkillsRecord, Integer> IDENTITY_OFFERS_SKILLS = Identities0.IDENTITY_OFFERS_SKILLS;
    public static final Identity<ReferralsRecord, Integer> IDENTITY_REFERRALS = Identities0.IDENTITY_REFERRALS;
    public static final Identity<SkillsRecord, Integer> IDENTITY_SKILLS = Identities0.IDENTITY_SKILLS;
    public static final Identity<TokensRecord, Integer> IDENTITY_TOKENS = Identities0.IDENTITY_TOKENS;
    public static final Identity<UserFormationRecord, Integer> IDENTITY_USER_FORMATION = Identities0.IDENTITY_USER_FORMATION;
    public static final Identity<UserLanguageRecord, Integer> IDENTITY_USER_LANGUAGE = Identities0.IDENTITY_USER_LANGUAGE;
    public static final Identity<UsersRecord, Integer> IDENTITY_USERS = Identities0.IDENTITY_USERS;
    public static final Identity<UsersSkillsRecord, Integer> IDENTITY_USERS_SKILLS = Identities0.IDENTITY_USERS_SKILLS;
    public static final Identity<ViewsUserRecord, Integer> IDENTITY_VIEWS_USER = Identities0.IDENTITY_VIEWS_USER;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CompaniesRecord> KEY_COMPANIES_PRIMARY = UniqueKeys0.KEY_COMPANIES_PRIMARY;
    public static final UniqueKey<CountriesRecord> KEY_COUNTRIES_PRIMARY = UniqueKeys0.KEY_COUNTRIES_PRIMARY;
    public static final UniqueKey<EducationRecord> KEY_EDUCATION_PRIMARY = UniqueKeys0.KEY_EDUCATION_PRIMARY;
    public static final UniqueKey<FormationsRecord> KEY_FORMATIONS_PRIMARY = UniqueKeys0.KEY_FORMATIONS_PRIMARY;
    public static final UniqueKey<LanguagesRecord> KEY_LANGUAGES_PRIMARY = UniqueKeys0.KEY_LANGUAGES_PRIMARY;
    public static final UniqueKey<OfferFormationRecord> KEY_OFFER_FORMATION_PRIMARY = UniqueKeys0.KEY_OFFER_FORMATION_PRIMARY;
    public static final UniqueKey<OffersRecord> KEY_OFFERS_PRIMARY = UniqueKeys0.KEY_OFFERS_PRIMARY;
    public static final UniqueKey<OffersSkillsRecord> KEY_OFFERS_SKILLS_PRIMARY = UniqueKeys0.KEY_OFFERS_SKILLS_PRIMARY;
    public static final UniqueKey<ReferralsRecord> KEY_REFERRALS_PRIMARY = UniqueKeys0.KEY_REFERRALS_PRIMARY;
    public static final UniqueKey<SkillsRecord> KEY_SKILLS_PRIMARY = UniqueKeys0.KEY_SKILLS_PRIMARY;
    public static final UniqueKey<TokensRecord> KEY_TOKENS_PRIMARY = UniqueKeys0.KEY_TOKENS_PRIMARY;
    public static final UniqueKey<TokensRecord> KEY_TOKENS_TOKEN_UNIQUE = UniqueKeys0.KEY_TOKENS_TOKEN_UNIQUE;
    public static final UniqueKey<UserFormationRecord> KEY_USER_FORMATION_PRIMARY = UniqueKeys0.KEY_USER_FORMATION_PRIMARY;
    public static final UniqueKey<UserLanguageRecord> KEY_USER_LANGUAGE_PRIMARY = UniqueKeys0.KEY_USER_LANGUAGE_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;
    public static final UniqueKey<UsersSkillsRecord> KEY_USERS_SKILLS_PRIMARY = UniqueKeys0.KEY_USERS_SKILLS_PRIMARY;
    public static final UniqueKey<ViewsUserRecord> KEY_VIEWS_USER_PRIMARY = UniqueKeys0.KEY_VIEWS_USER_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CompaniesRecord, CountriesRecord> FK_COMMPANY_COUNTRY = ForeignKeys0.FK_COMMPANY_COUNTRY;
    public static final ForeignKey<EducationRecord, UsersRecord> FK_USER_ID = ForeignKeys0.FK_USER_ID;
    public static final ForeignKey<OfferFormationRecord, OffersRecord> FK_OFFER_FORMATION_OFFER = ForeignKeys0.FK_OFFER_FORMATION_OFFER;
    public static final ForeignKey<OfferFormationRecord, FormationsRecord> FK_OFFER_FORMATION_FORMATION = ForeignKeys0.FK_OFFER_FORMATION_FORMATION;
    public static final ForeignKey<OffersRecord, CompaniesRecord> FK_OFFER_COMPANY = ForeignKeys0.FK_OFFER_COMPANY;
    public static final ForeignKey<OffersSkillsRecord, SkillsRecord> OFFER_SKILLS_SKILL = ForeignKeys0.OFFER_SKILLS_SKILL;
    public static final ForeignKey<OffersSkillsRecord, OffersRecord> OFFER_SKILLS_OFFER = ForeignKeys0.OFFER_SKILLS_OFFER;
    public static final ForeignKey<ReferralsRecord, UsersRecord> FK_JOBSTER = ForeignKeys0.FK_JOBSTER;
    public static final ForeignKey<ReferralsRecord, UsersRecord> FK_CANDIDATO = ForeignKeys0.FK_CANDIDATO;
    public static final ForeignKey<ReferralsRecord, OffersRecord> FK_OFFER = ForeignKeys0.FK_OFFER;
    public static final ForeignKey<TokensRecord, UsersRecord> FK_TOKEN_USER = ForeignKeys0.FK_TOKEN_USER;
    public static final ForeignKey<UserFormationRecord, UsersRecord> FK_USER_FORMATION_USER = ForeignKeys0.FK_USER_FORMATION_USER;
    public static final ForeignKey<UserFormationRecord, FormationsRecord> FK_USER_FORMATION_FORMATION = ForeignKeys0.FK_USER_FORMATION_FORMATION;
    public static final ForeignKey<UserLanguageRecord, UsersRecord> USER_IDIOM_USER = ForeignKeys0.USER_IDIOM_USER;
    public static final ForeignKey<UsersSkillsRecord, UsersRecord> FK_USERS_SKILLS_USER = ForeignKeys0.FK_USERS_SKILLS_USER;
    public static final ForeignKey<UsersSkillsRecord, SkillsRecord> KF_USERS_SKILLS_SKILL = ForeignKeys0.KF_USERS_SKILLS_SKILL;
    public static final ForeignKey<ViewsUserRecord, UsersRecord> FK_VIEWS_USER = ForeignKeys0.FK_VIEWS_USER;
    public static final ForeignKey<ViewsUserRecord, OffersRecord> FK_VIEWS_OFFER = ForeignKeys0.FK_VIEWS_OFFER;
    public static final ForeignKey<ViewsUserRecord, CompaniesRecord> FK_VIEWS_COMPANY = ForeignKeys0.FK_VIEWS_COMPANY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<EducationRecord, Integer> IDENTITY_EDUCATION = Internal.createIdentity(Education.EDUCATION, Education.EDUCATION.ID_EDUCATION);
        public static Identity<LanguagesRecord, Integer> IDENTITY_LANGUAGES = Internal.createIdentity(Languages.LANGUAGES, Languages.LANGUAGES.ID_LANGUAGE);
        public static Identity<OfferFormationRecord, Integer> IDENTITY_OFFER_FORMATION = Internal.createIdentity(OfferFormation.OFFER_FORMATION, OfferFormation.OFFER_FORMATION.ID_OFFER_FORMATION);
        public static Identity<OffersRecord, Integer> IDENTITY_OFFERS = Internal.createIdentity(Offers.OFFERS, Offers.OFFERS.ID_OFFER);
        public static Identity<OffersSkillsRecord, Integer> IDENTITY_OFFERS_SKILLS = Internal.createIdentity(OffersSkills.OFFERS_SKILLS, OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL);
        public static Identity<ReferralsRecord, Integer> IDENTITY_REFERRALS = Internal.createIdentity(Referrals.REFERRALS, Referrals.REFERRALS.ID_REFERRAL);
        public static Identity<SkillsRecord, Integer> IDENTITY_SKILLS = Internal.createIdentity(Skills.SKILLS, Skills.SKILLS.ID_SKILL);
        public static Identity<TokensRecord, Integer> IDENTITY_TOKENS = Internal.createIdentity(Tokens.TOKENS, Tokens.TOKENS.ID_TOKENS);
        public static Identity<UserFormationRecord, Integer> IDENTITY_USER_FORMATION = Internal.createIdentity(UserFormation.USER_FORMATION, UserFormation.USER_FORMATION.ID_USER_FORMATION);
        public static Identity<UserLanguageRecord, Integer> IDENTITY_USER_LANGUAGE = Internal.createIdentity(UserLanguage.USER_LANGUAGE, UserLanguage.USER_LANGUAGE.ID_USER_LANGUAGE);
        public static Identity<UsersRecord, Integer> IDENTITY_USERS = Internal.createIdentity(Users.USERS, Users.USERS.ID_USER);
        public static Identity<UsersSkillsRecord, Integer> IDENTITY_USERS_SKILLS = Internal.createIdentity(UsersSkills.USERS_SKILLS, UsersSkills.USERS_SKILLS.ID_USER_SKILL);
        public static Identity<ViewsUserRecord, Integer> IDENTITY_VIEWS_USER = Internal.createIdentity(ViewsUser.VIEWS_USER, ViewsUser.VIEWS_USER.ID_VIEWS_USER);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CompaniesRecord> KEY_COMPANIES_PRIMARY = Internal.createUniqueKey(Companies.COMPANIES, "KEY_companies_PRIMARY", Companies.COMPANIES.ID_COMPANY);
        public static final UniqueKey<CountriesRecord> KEY_COUNTRIES_PRIMARY = Internal.createUniqueKey(Countries.COUNTRIES, "KEY_countries_PRIMARY", Countries.COUNTRIES.ID_COUNTRY);
        public static final UniqueKey<EducationRecord> KEY_EDUCATION_PRIMARY = Internal.createUniqueKey(Education.EDUCATION, "KEY_education_PRIMARY", Education.EDUCATION.ID_EDUCATION);
        public static final UniqueKey<FormationsRecord> KEY_FORMATIONS_PRIMARY = Internal.createUniqueKey(Formations.FORMATIONS, "KEY_formations_PRIMARY", Formations.FORMATIONS.ID_FORMATION);
        public static final UniqueKey<LanguagesRecord> KEY_LANGUAGES_PRIMARY = Internal.createUniqueKey(Languages.LANGUAGES, "KEY_languages_PRIMARY", Languages.LANGUAGES.ID_LANGUAGE);
        public static final UniqueKey<OfferFormationRecord> KEY_OFFER_FORMATION_PRIMARY = Internal.createUniqueKey(OfferFormation.OFFER_FORMATION, "KEY_offer_formation_PRIMARY", OfferFormation.OFFER_FORMATION.ID_OFFER_FORMATION);
        public static final UniqueKey<OffersRecord> KEY_OFFERS_PRIMARY = Internal.createUniqueKey(Offers.OFFERS, "KEY_offers_PRIMARY", Offers.OFFERS.ID_OFFER);
        public static final UniqueKey<OffersSkillsRecord> KEY_OFFERS_SKILLS_PRIMARY = Internal.createUniqueKey(OffersSkills.OFFERS_SKILLS, "KEY_offers_skills_PRIMARY", OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL);
        public static final UniqueKey<ReferralsRecord> KEY_REFERRALS_PRIMARY = Internal.createUniqueKey(Referrals.REFERRALS, "KEY_referrals_PRIMARY", Referrals.REFERRALS.ID_REFERRAL);
        public static final UniqueKey<SkillsRecord> KEY_SKILLS_PRIMARY = Internal.createUniqueKey(Skills.SKILLS, "KEY_skills_PRIMARY", Skills.SKILLS.ID_SKILL);
        public static final UniqueKey<TokensRecord> KEY_TOKENS_PRIMARY = Internal.createUniqueKey(Tokens.TOKENS, "KEY_tokens_PRIMARY", Tokens.TOKENS.ID_TOKENS);
        public static final UniqueKey<TokensRecord> KEY_TOKENS_TOKEN_UNIQUE = Internal.createUniqueKey(Tokens.TOKENS, "KEY_tokens_token_UNIQUE", Tokens.TOKENS.TOKEN);
        public static final UniqueKey<UserFormationRecord> KEY_USER_FORMATION_PRIMARY = Internal.createUniqueKey(UserFormation.USER_FORMATION, "KEY_user_formation_PRIMARY", UserFormation.USER_FORMATION.ID_USER_FORMATION);
        public static final UniqueKey<UserLanguageRecord> KEY_USER_LANGUAGE_PRIMARY = Internal.createUniqueKey(UserLanguage.USER_LANGUAGE, "KEY_user_language_PRIMARY", UserLanguage.USER_LANGUAGE.ID_USER_LANGUAGE);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.ID_USER);
        public static final UniqueKey<UsersSkillsRecord> KEY_USERS_SKILLS_PRIMARY = Internal.createUniqueKey(UsersSkills.USERS_SKILLS, "KEY_users_skills_PRIMARY", UsersSkills.USERS_SKILLS.ID_USER_SKILL);
        public static final UniqueKey<ViewsUserRecord> KEY_VIEWS_USER_PRIMARY = Internal.createUniqueKey(ViewsUser.VIEWS_USER, "KEY_views_user_PRIMARY", ViewsUser.VIEWS_USER.ID_VIEWS_USER);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CompaniesRecord, CountriesRecord> FK_COMMPANY_COUNTRY = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_COUNTRIES_PRIMARY, Companies.COMPANIES, "FK_COMMPANY_COUNTRY", Companies.COMPANIES.ID_COUNTRY);
        public static final ForeignKey<EducationRecord, UsersRecord> FK_USER_ID = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, Education.EDUCATION, "FK_user_id", Education.EDUCATION.ID_USER);
        public static final ForeignKey<OfferFormationRecord, OffersRecord> FK_OFFER_FORMATION_OFFER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_OFFERS_PRIMARY, OfferFormation.OFFER_FORMATION, "FK_OFFER_FORMATION_OFFER", OfferFormation.OFFER_FORMATION.ID_OFFER);
        public static final ForeignKey<OfferFormationRecord, FormationsRecord> FK_OFFER_FORMATION_FORMATION = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_FORMATIONS_PRIMARY, OfferFormation.OFFER_FORMATION, "FK_OFFER_FORMATION_FORMATION", OfferFormation.OFFER_FORMATION.ID_FORMATION);
        public static final ForeignKey<OffersRecord, CompaniesRecord> FK_OFFER_COMPANY = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_COMPANIES_PRIMARY, Offers.OFFERS, "FK_OFFER_COMPANY", Offers.OFFERS.ID_COMPANY);
        public static final ForeignKey<OffersSkillsRecord, SkillsRecord> OFFER_SKILLS_SKILL = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_SKILLS_PRIMARY, OffersSkills.OFFERS_SKILLS, "offer_skills_skill", OffersSkills.OFFERS_SKILLS.ID_SKILL);
        public static final ForeignKey<OffersSkillsRecord, OffersRecord> OFFER_SKILLS_OFFER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_OFFERS_PRIMARY, OffersSkills.OFFERS_SKILLS, "offer_skills_offer", OffersSkills.OFFERS_SKILLS.ID_OFFER);
        public static final ForeignKey<ReferralsRecord, UsersRecord> FK_JOBSTER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, Referrals.REFERRALS, "fk_jobster", Referrals.REFERRALS.ID_ENDORSER);
        public static final ForeignKey<ReferralsRecord, UsersRecord> FK_CANDIDATO = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, Referrals.REFERRALS, "fk_candidato", Referrals.REFERRALS.ID_CANDIDATE);
        public static final ForeignKey<ReferralsRecord, OffersRecord> FK_OFFER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_OFFERS_PRIMARY, Referrals.REFERRALS, "fk_offer", Referrals.REFERRALS.ID_OFFER);
        public static final ForeignKey<TokensRecord, UsersRecord> FK_TOKEN_USER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, Tokens.TOKENS, "FK_TOKEN_USER", Tokens.TOKENS.ID_USER);
        public static final ForeignKey<UserFormationRecord, UsersRecord> FK_USER_FORMATION_USER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, UserFormation.USER_FORMATION, "FK_USER_FORMATION_USER", UserFormation.USER_FORMATION.ID_USER);
        public static final ForeignKey<UserFormationRecord, FormationsRecord> FK_USER_FORMATION_FORMATION = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_FORMATIONS_PRIMARY, UserFormation.USER_FORMATION, "FK_USER_FORMATION_FORMATION", UserFormation.USER_FORMATION.ID_FORMATION);
        public static final ForeignKey<UserLanguageRecord, UsersRecord> USER_IDIOM_USER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, UserLanguage.USER_LANGUAGE, "user_idiom_user", UserLanguage.USER_LANGUAGE.ID_USER);
        public static final ForeignKey<UsersSkillsRecord, UsersRecord> FK_USERS_SKILLS_USER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, UsersSkills.USERS_SKILLS, "FK_users_skills_user", UsersSkills.USERS_SKILLS.ID_USER);
        public static final ForeignKey<UsersSkillsRecord, SkillsRecord> KF_USERS_SKILLS_SKILL = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_SKILLS_PRIMARY, UsersSkills.USERS_SKILLS, "KF_users_skills_skill", UsersSkills.USERS_SKILLS.ID_SKILL);
        public static final ForeignKey<ViewsUserRecord, UsersRecord> FK_VIEWS_USER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_USERS_PRIMARY, ViewsUser.VIEWS_USER, "FK_VIEWS_USER", ViewsUser.VIEWS_USER.ID_USER);
        public static final ForeignKey<ViewsUserRecord, OffersRecord> FK_VIEWS_OFFER = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_OFFERS_PRIMARY, ViewsUser.VIEWS_USER, "FK_VIEWS_OFFER", ViewsUser.VIEWS_USER.ID_OFFER);
        public static final ForeignKey<ViewsUserRecord, CompaniesRecord> FK_VIEWS_COMPANY = Internal.createForeignKey(com.talendorse.server.model.Keys.KEY_COMPANIES_PRIMARY, ViewsUser.VIEWS_USER, "FK_VIEWS_COMPANY", ViewsUser.VIEWS_USER.ID_COMPANY);
    }
}
