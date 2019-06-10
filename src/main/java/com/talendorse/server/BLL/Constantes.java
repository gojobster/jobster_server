package com.talendorse.server.BLL;

import org.jooq.True;

public class Constantes {
    private static final boolean IS_DEBUG = true;

    private static final String TALENDORSE_URL_LOCALHOST = "http://localhost:8080/";
    private static final String TALENDORSE_URL_SERVER = "http://www.talendorse.com:8080/";
    public static final String TALENDORSE_URL = IS_DEBUG ? TALENDORSE_URL_LOCALHOST : TALENDORSE_URL_SERVER;

    private static final String TALENDORSE_WS_URL_LOCALHOST = "http://localhost:8085/";
    private static final String WS_TALENDORSE_DEBUG = TALENDORSE_WS_URL_LOCALHOST + "ws/";
    private static final String WS_TALENDORSE_RELEASE = TALENDORSE_URL + "ws/";
    public static final String WS_TALENDORSE_URL = IS_DEBUG ? WS_TALENDORSE_DEBUG : WS_TALENDORSE_RELEASE;

    public static final String DB_PASS_LOCALHOST = "1234";
//    public static final String DB_PASS_LOCALHOST = "Jobster2018!";
    public static final String DB_PASS_SERVER = "Jobster2018!";

    public static final String DB_USER = "root";
    public static final String DB_PASS = IS_DEBUG ? DB_PASS_LOCALHOST : DB_PASS_SERVER;
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/database?serverTimezone=UTC";

    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String CLAVE_ENCRIPTACION = "Binomio Alto";
    public static final String VI_ENCRIPTACION = "456";
    public static final String PATTERN_SPLIT = "RFVBGT";
    public static final long TOKEN_EXPIRATION_MINUTES = 60 * 24 * 3600;

    public static final int NUM_RANDOM_INTENTS_CODE_OFFER = 10;

    public static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    /****************************************************************************
     ************************* Web Services ***********************************
     ****************************************************************************/


    public static final String WS_GET_ALL_OFFERS = WS_TALENDORSE_URL + "getAllWsOffers";
    public static final String WS_GET_TOP_OFFERS = WS_TALENDORSE_URL + "getTopOffers";



    public static final String URL_EMAIL_VALIDATION_ACCOUNT_URL_ES = "email/activation_es";//WS_TALENDORSE_URL + "email/email_activation_es.html";
    public static final String URL_EMAIL_SEND_RECOMMENDATION_URL_ES = "email/recommendation_es";//WS_TALENDORSE_URL + "email/email_recommendation_es.html";
    public static final String URL_EMAIL_VALIDATION_ACCOUNT_URL_EN = "email/activation_en";//WS_TALENDORSE_URL + "email/email_activation_en.html";
    public static final String URL_EMAIL_SEND_RECOMMENDATION_URL_EN = "email/recommendation_en";//WS_TALENDORSE_URL + "email/email_recommendation_en.html";

    public static final String URL_EMAIL_NEW_USER_URL_EN = "email/new_user_es";

    /****************************************************************************
     ************************* EMAIL SETTINGS ***********************************
     ****************************************************************************/

    public static final String SRV_EMAIL_FROM_ACCOUNT = "hello@talendorse.com";
    public static final String SRV_EMAIL_HOST = "smtp-es.securemail.pro";

    public static final String SRV_EMAIL_USR = "hello@talendorse.com";
    public static final String SRV_EMAIL_PWD = "BljZiLtGNr9J";
    public static final int SRV_EMAIL_PORT = 465;
    public static final Boolean SRV_EMAIL_ENABLE_SSL = true;


    public static final String EMAIL_SUBJECT_RECOVER_PASSWORD_ES = "Talendorse - Recuperar Contraseña";
    public static final String EMAIL_SUBJECT_USER_ACTIVATION_ES = "Talendorse - Activar endorser";
    public static final String EMAIL_SUBJECT_OFFER_RECOMENDATION_ES = "Talendorse - Recomendación de trabajo de";
    public static final String EMAIL_SUBJECT_NEW_USER_ES = "Talendorse: Bienvenido";



    public static final String EMAIL_SUBJECT_RECOVER_PASSWORD_EN = "Talendorse - Recover Password";
    public static final String EMAIL_SUBJECT_USER_ACTIVATION_EN = "Talendorse - endorser's activation ";
    public static final String EMAIL_SUBJECT_OFFER_RECOMENDATION_EN = "Talendorse - Job offer recomendation from ";


    /****************************************************************************
     ************************* LINKEDIN ***********************************
     ****************************************************************************/

    //This is the public api key of our application
    public static final String CLIENT_ID = "77sx2eal8s9cco";
//    public static final String CLIENT_ID = "bee8g63gi4x6";
    //This is the private api key of our application
    public static final String CLIENT_SECRET = "JjQyf7QOjHERNgFj";
//    public static final String CLIENT_SECRET = "7M3uvL19CjWWRLSJ";

    public static final String REDIRECT_URL_LINKEDIN = Constantes.TALENDORSE_URL +"login";
    public static final String REDIRECT_URL_LINKEDIN_WP = Constantes.TALENDORSE_URL +"login_wp";
    //This is any string we want to use. This will be used for avoiding CSRF attacks. You can generate one here: http://strongpasswordgenerator.com/
    public static final String STATE = "E3ZYKC1T6H2yP4z";
    //This is the url that LinkedIn Auth process will redirect to. We can put whatever we want that starts with http:// or https:// .
//We use a made up url that we will intercept when redirecting. Avoid Uppercases.
    public static final String REDIRECT_URI = "http://gojobster.com/register";

    public static final String LINKEDIN_PERMISSIONS_LITEPROFILE = "r_liteprofile";
    public static final String LINKEDIN_PERMISSIONS_EMAILADRESS = "r_emailaddress";
    public static final String LINKEDIN_PERMISSIONS_WMEMBER_SOCIAL = "w_member_social";

    //These are constants used for build the urls
    public static final String AUTHORIZATION_URL = "https://www.linkedin.com/uas/oauth2/authorization";
    public static final String ACCESS_TOKEN_URL = "https://www.linkedin.com/uas/oauth2/accessToken";
    public static final String SECRET_KEY_PARAM = "client_secret";
    public static final String RESPONSE_TYPE_PARAM = "response_type";
    public static final String GRANT_TYPE_PARAM = "grant_type";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String RESPONSE_TYPE_VALUE ="code";
    public static final String CLIENT_ID_PARAM = "client_id";
    public static final String STATE_PARAM = "state";
    public static final String REDIRECT_URI_PARAM = "redirect_uri";
    /*---------------------------------------*/
    public static final String QUESTION_MARK = "?";
    public static final String AMPERSAND = "&";
    public static final String EQUALS = "=";



}