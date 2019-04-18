/*
 * This file is generated by jOOQ.
 */
package com.jobster.server.model;


import com.jobster.server.model.tables.Companies;
import com.jobster.server.model.tables.Countries;
import com.jobster.server.model.tables.Education;
import com.jobster.server.model.tables.Formations;
import com.jobster.server.model.tables.Idioms;
import com.jobster.server.model.tables.OfferFormation;
import com.jobster.server.model.tables.Offers;
import com.jobster.server.model.tables.OffersSkills;
import com.jobster.server.model.tables.Referrals;
import com.jobster.server.model.tables.Skills;
import com.jobster.server.model.tables.Tokens;
import com.jobster.server.model.tables.UserFormation;
import com.jobster.server.model.tables.UserIdiom;
import com.jobster.server.model.tables.Users;
import com.jobster.server.model.tables.UsersSkills;
import com.jobster.server.model.tables.records.CompaniesRecord;
import com.jobster.server.model.tables.records.CountriesRecord;
import com.jobster.server.model.tables.records.EducationRecord;
import com.jobster.server.model.tables.records.FormationsRecord;
import com.jobster.server.model.tables.records.IdiomsRecord;
import com.jobster.server.model.tables.records.OfferFormationRecord;
import com.jobster.server.model.tables.records.OffersRecord;
import com.jobster.server.model.tables.records.OffersSkillsRecord;
import com.jobster.server.model.tables.records.ReferralsRecord;
import com.jobster.server.model.tables.records.SkillsRecord;
import com.jobster.server.model.tables.records.TokensRecord;
import com.jobster.server.model.tables.records.UserFormationRecord;
import com.jobster.server.model.tables.records.UserIdiomRecord;
import com.jobster.server.model.tables.records.UsersRecord;
import com.jobster.server.model.tables.records.UsersSkillsRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>jobster</code> schema.
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
    public static final Identity<IdiomsRecord, Integer> IDENTITY_IDIOMS = Identities0.IDENTITY_IDIOMS;
    public static final Identity<OfferFormationRecord, Integer> IDENTITY_OFFER_FORMATION = Identities0.IDENTITY_OFFER_FORMATION;
    public static final Identity<OffersRecord, Integer> IDENTITY_OFFERS = Identities0.IDENTITY_OFFERS;
    public static final Identity<OffersSkillsRecord, Integer> IDENTITY_OFFERS_SKILLS = Identities0.IDENTITY_OFFERS_SKILLS;
    public static final Identity<ReferralsRecord, Integer> IDENTITY_REFERRALS = Identities0.IDENTITY_REFERRALS;
    public static final Identity<SkillsRecord, Integer> IDENTITY_SKILLS = Identities0.IDENTITY_SKILLS;
    public static final Identity<TokensRecord, Integer> IDENTITY_TOKENS = Identities0.IDENTITY_TOKENS;
    public static final Identity<UserFormationRecord, Integer> IDENTITY_USER_FORMATION = Identities0.IDENTITY_USER_FORMATION;
    public static final Identity<UserIdiomRecord, Integer> IDENTITY_USER_IDIOM = Identities0.IDENTITY_USER_IDIOM;
    public static final Identity<UsersRecord, Integer> IDENTITY_USERS = Identities0.IDENTITY_USERS;
    public static final Identity<UsersSkillsRecord, Integer> IDENTITY_USERS_SKILLS = Identities0.IDENTITY_USERS_SKILLS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CompaniesRecord> KEY_COMPANIES_PRIMARY = UniqueKeys0.KEY_COMPANIES_PRIMARY;
    public static final UniqueKey<CountriesRecord> KEY_COUNTRIES_PRIMARY = UniqueKeys0.KEY_COUNTRIES_PRIMARY;
    public static final UniqueKey<EducationRecord> KEY_EDUCATION_PRIMARY = UniqueKeys0.KEY_EDUCATION_PRIMARY;
    public static final UniqueKey<FormationsRecord> KEY_FORMATIONS_PRIMARY = UniqueKeys0.KEY_FORMATIONS_PRIMARY;
    public static final UniqueKey<IdiomsRecord> KEY_IDIOMS_PRIMARY = UniqueKeys0.KEY_IDIOMS_PRIMARY;
    public static final UniqueKey<OfferFormationRecord> KEY_OFFER_FORMATION_PRIMARY = UniqueKeys0.KEY_OFFER_FORMATION_PRIMARY;
    public static final UniqueKey<OffersRecord> KEY_OFFERS_PRIMARY = UniqueKeys0.KEY_OFFERS_PRIMARY;
    public static final UniqueKey<OffersSkillsRecord> KEY_OFFERS_SKILLS_PRIMARY = UniqueKeys0.KEY_OFFERS_SKILLS_PRIMARY;
    public static final UniqueKey<ReferralsRecord> KEY_REFERRALS_PRIMARY = UniqueKeys0.KEY_REFERRALS_PRIMARY;
    public static final UniqueKey<SkillsRecord> KEY_SKILLS_PRIMARY = UniqueKeys0.KEY_SKILLS_PRIMARY;
    public static final UniqueKey<TokensRecord> KEY_TOKENS_PRIMARY = UniqueKeys0.KEY_TOKENS_PRIMARY;
    public static final UniqueKey<TokensRecord> KEY_TOKENS_TOKEN_UNIQUE = UniqueKeys0.KEY_TOKENS_TOKEN_UNIQUE;
    public static final UniqueKey<UserFormationRecord> KEY_USER_FORMATION_PRIMARY = UniqueKeys0.KEY_USER_FORMATION_PRIMARY;
    public static final UniqueKey<UserIdiomRecord> KEY_USER_IDIOM_PRIMARY = UniqueKeys0.KEY_USER_IDIOM_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;
    public static final UniqueKey<UsersSkillsRecord> KEY_USERS_SKILLS_PRIMARY = UniqueKeys0.KEY_USERS_SKILLS_PRIMARY;

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
    public static final ForeignKey<UserIdiomRecord, UsersRecord> USER_IDIOM_USER = ForeignKeys0.USER_IDIOM_USER;
    public static final ForeignKey<UserIdiomRecord, IdiomsRecord> USER_IDIOM_IDIOM = ForeignKeys0.USER_IDIOM_IDIOM;
    public static final ForeignKey<UsersSkillsRecord, UsersRecord> FK_USERS_SKILLS_USER = ForeignKeys0.FK_USERS_SKILLS_USER;
    public static final ForeignKey<UsersSkillsRecord, SkillsRecord> KF_USERS_SKILLS_SKILL = ForeignKeys0.KF_USERS_SKILLS_SKILL;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<EducationRecord, Integer> IDENTITY_EDUCATION = Internal.createIdentity(Education.EDUCATION, Education.EDUCATION.ID_EDUCATION);
        public static Identity<IdiomsRecord, Integer> IDENTITY_IDIOMS = Internal.createIdentity(Idioms.IDIOMS, Idioms.IDIOMS.ID_IDIOM);
        public static Identity<OfferFormationRecord, Integer> IDENTITY_OFFER_FORMATION = Internal.createIdentity(OfferFormation.OFFER_FORMATION, OfferFormation.OFFER_FORMATION.ID_OFFER_FORMATION);
        public static Identity<OffersRecord, Integer> IDENTITY_OFFERS = Internal.createIdentity(Offers.OFFERS, Offers.OFFERS.ID_OFFER);
        public static Identity<OffersSkillsRecord, Integer> IDENTITY_OFFERS_SKILLS = Internal.createIdentity(OffersSkills.OFFERS_SKILLS, OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL);
        public static Identity<ReferralsRecord, Integer> IDENTITY_REFERRALS = Internal.createIdentity(Referrals.REFERRALS, Referrals.REFERRALS.ID_REFERRAL);
        public static Identity<SkillsRecord, Integer> IDENTITY_SKILLS = Internal.createIdentity(Skills.SKILLS, Skills.SKILLS.ID_SKILL);
        public static Identity<TokensRecord, Integer> IDENTITY_TOKENS = Internal.createIdentity(Tokens.TOKENS, Tokens.TOKENS.ID_TOKENS);
        public static Identity<UserFormationRecord, Integer> IDENTITY_USER_FORMATION = Internal.createIdentity(UserFormation.USER_FORMATION, UserFormation.USER_FORMATION.ID_USER_FORMATION);
        public static Identity<UserIdiomRecord, Integer> IDENTITY_USER_IDIOM = Internal.createIdentity(UserIdiom.USER_IDIOM, UserIdiom.USER_IDIOM.ID_USER_IDIOM);
        public static Identity<UsersRecord, Integer> IDENTITY_USERS = Internal.createIdentity(Users.USERS, Users.USERS.ID_USER);
        public static Identity<UsersSkillsRecord, Integer> IDENTITY_USERS_SKILLS = Internal.createIdentity(UsersSkills.USERS_SKILLS, UsersSkills.USERS_SKILLS.ID_USER_SKILL);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<CompaniesRecord> KEY_COMPANIES_PRIMARY = Internal.createUniqueKey(Companies.COMPANIES, "KEY_companies_PRIMARY", Companies.COMPANIES.ID_COMPANY);
        public static final UniqueKey<CountriesRecord> KEY_COUNTRIES_PRIMARY = Internal.createUniqueKey(Countries.COUNTRIES, "KEY_countries_PRIMARY", Countries.COUNTRIES.ID_COUNTRY);
        public static final UniqueKey<EducationRecord> KEY_EDUCATION_PRIMARY = Internal.createUniqueKey(Education.EDUCATION, "KEY_education_PRIMARY", Education.EDUCATION.ID_EDUCATION);
        public static final UniqueKey<FormationsRecord> KEY_FORMATIONS_PRIMARY = Internal.createUniqueKey(Formations.FORMATIONS, "KEY_formations_PRIMARY", Formations.FORMATIONS.ID_FORMATION);
        public static final UniqueKey<IdiomsRecord> KEY_IDIOMS_PRIMARY = Internal.createUniqueKey(Idioms.IDIOMS, "KEY_idioms_PRIMARY", Idioms.IDIOMS.ID_IDIOM);
        public static final UniqueKey<OfferFormationRecord> KEY_OFFER_FORMATION_PRIMARY = Internal.createUniqueKey(OfferFormation.OFFER_FORMATION, "KEY_offer_formation_PRIMARY", OfferFormation.OFFER_FORMATION.ID_OFFER_FORMATION);
        public static final UniqueKey<OffersRecord> KEY_OFFERS_PRIMARY = Internal.createUniqueKey(Offers.OFFERS, "KEY_offers_PRIMARY", Offers.OFFERS.ID_OFFER);
        public static final UniqueKey<OffersSkillsRecord> KEY_OFFERS_SKILLS_PRIMARY = Internal.createUniqueKey(OffersSkills.OFFERS_SKILLS, "KEY_offers_skills_PRIMARY", OffersSkills.OFFERS_SKILLS.ID_OFFER_SKILL);
        public static final UniqueKey<ReferralsRecord> KEY_REFERRALS_PRIMARY = Internal.createUniqueKey(Referrals.REFERRALS, "KEY_referrals_PRIMARY", Referrals.REFERRALS.ID_REFERRAL);
        public static final UniqueKey<SkillsRecord> KEY_SKILLS_PRIMARY = Internal.createUniqueKey(Skills.SKILLS, "KEY_skills_PRIMARY", Skills.SKILLS.ID_SKILL);
        public static final UniqueKey<TokensRecord> KEY_TOKENS_PRIMARY = Internal.createUniqueKey(Tokens.TOKENS, "KEY_tokens_PRIMARY", Tokens.TOKENS.ID_TOKENS);
        public static final UniqueKey<TokensRecord> KEY_TOKENS_TOKEN_UNIQUE = Internal.createUniqueKey(Tokens.TOKENS, "KEY_tokens_token_UNIQUE", Tokens.TOKENS.TOKEN);
        public static final UniqueKey<UserFormationRecord> KEY_USER_FORMATION_PRIMARY = Internal.createUniqueKey(UserFormation.USER_FORMATION, "KEY_user_formation_PRIMARY", UserFormation.USER_FORMATION.ID_USER_FORMATION);
        public static final UniqueKey<UserIdiomRecord> KEY_USER_IDIOM_PRIMARY = Internal.createUniqueKey(UserIdiom.USER_IDIOM, "KEY_user_idiom_PRIMARY", UserIdiom.USER_IDIOM.ID_USER_IDIOM);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = Internal.createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.ID_USER);
        public static final UniqueKey<UsersSkillsRecord> KEY_USERS_SKILLS_PRIMARY = Internal.createUniqueKey(UsersSkills.USERS_SKILLS, "KEY_users_skills_PRIMARY", UsersSkills.USERS_SKILLS.ID_USER_SKILL);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<CompaniesRecord, CountriesRecord> FK_COMMPANY_COUNTRY = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_COUNTRIES_PRIMARY, Companies.COMPANIES, "FK_COMMPANY_COUNTRY", Companies.COMPANIES.ID_COUNTRY);
        public static final ForeignKey<EducationRecord, UsersRecord> FK_USER_ID = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, Education.EDUCATION, "FK_user_id", Education.EDUCATION.ID_USER);
        public static final ForeignKey<OfferFormationRecord, OffersRecord> FK_OFFER_FORMATION_OFFER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_OFFERS_PRIMARY, OfferFormation.OFFER_FORMATION, "FK_OFFER_FORMATION_OFFER", OfferFormation.OFFER_FORMATION.ID_OFFER);
        public static final ForeignKey<OfferFormationRecord, FormationsRecord> FK_OFFER_FORMATION_FORMATION = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_FORMATIONS_PRIMARY, OfferFormation.OFFER_FORMATION, "FK_OFFER_FORMATION_FORMATION", OfferFormation.OFFER_FORMATION.ID_FORMATION);
        public static final ForeignKey<OffersRecord, CompaniesRecord> FK_OFFER_COMPANY = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_COMPANIES_PRIMARY, Offers.OFFERS, "FK_OFFER_COMPANY", Offers.OFFERS.ID_COMPANY);
        public static final ForeignKey<OffersSkillsRecord, SkillsRecord> OFFER_SKILLS_SKILL = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_SKILLS_PRIMARY, OffersSkills.OFFERS_SKILLS, "offer_skills_skill", OffersSkills.OFFERS_SKILLS.ID_SKILL);
        public static final ForeignKey<OffersSkillsRecord, OffersRecord> OFFER_SKILLS_OFFER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_OFFERS_PRIMARY, OffersSkills.OFFERS_SKILLS, "offer_skills_offer", OffersSkills.OFFERS_SKILLS.ID_OFFER);
        public static final ForeignKey<ReferralsRecord, UsersRecord> FK_JOBSTER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, Referrals.REFERRALS, "fk_jobster", Referrals.REFERRALS.ID_JOBSTER);
        public static final ForeignKey<ReferralsRecord, UsersRecord> FK_CANDIDATO = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, Referrals.REFERRALS, "fk_candidato", Referrals.REFERRALS.ID_CANDIDATE);
        public static final ForeignKey<ReferralsRecord, OffersRecord> FK_OFFER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_OFFERS_PRIMARY, Referrals.REFERRALS, "fk_offer", Referrals.REFERRALS.ID_OFFER);
        public static final ForeignKey<TokensRecord, UsersRecord> FK_TOKEN_USER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, Tokens.TOKENS, "FK_TOKEN_USER", Tokens.TOKENS.ID_USER);
        public static final ForeignKey<UserFormationRecord, UsersRecord> FK_USER_FORMATION_USER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, UserFormation.USER_FORMATION, "FK_USER_FORMATION_USER", UserFormation.USER_FORMATION.ID_USER);
        public static final ForeignKey<UserFormationRecord, FormationsRecord> FK_USER_FORMATION_FORMATION = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_FORMATIONS_PRIMARY, UserFormation.USER_FORMATION, "FK_USER_FORMATION_FORMATION", UserFormation.USER_FORMATION.ID_FORMATION);
        public static final ForeignKey<UserIdiomRecord, UsersRecord> USER_IDIOM_USER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, UserIdiom.USER_IDIOM, "user_idiom_user", UserIdiom.USER_IDIOM.ID_USER);
        public static final ForeignKey<UserIdiomRecord, IdiomsRecord> USER_IDIOM_IDIOM = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_IDIOMS_PRIMARY, UserIdiom.USER_IDIOM, "user_idiom_idiom", UserIdiom.USER_IDIOM.ID_IDIOM);
        public static final ForeignKey<UsersSkillsRecord, UsersRecord> FK_USERS_SKILLS_USER = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_USERS_PRIMARY, UsersSkills.USERS_SKILLS, "FK_users_skills_user", UsersSkills.USERS_SKILLS.ID_USER);
        public static final ForeignKey<UsersSkillsRecord, SkillsRecord> KF_USERS_SKILLS_SKILL = Internal.createForeignKey(com.jobster.server.model.Keys.KEY_SKILLS_PRIMARY, UsersSkills.USERS_SKILLS, "KF_users_skills_skill", UsersSkills.USERS_SKILLS.ID_SKILL);
    }
}
