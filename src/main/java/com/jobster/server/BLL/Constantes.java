package com.jobster.server.BLL;

public class Constantes {
    public static final String DB_USER = "root";
    public static final String DB_PASS = "1234";
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jobster?serverTimezone=UTC";
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String CLAVE_ENCRIPTACION = "Binomio Alto";
    public static final String VI_ENCRIPTACION = "456";
    public static final String PATHERN_SPLIT= "RFVBGT";

    public static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";




    public static final String SRV_EMAIL_FROM_ACCOUNT = "hello@josbter.com";
    public static final String SRV_EMAIL_HOST = "authsmtp.jobster.com";

    public static final String SRV_EMAIL_USR = "smtp@jobster.com";
    public static final String SRV_EMAIL_PWD = "Jobster2018!";
    public static final int SRV_EMAIL_PORT = 587;
    public static final Boolean SRV_EMAIL_ENABLE_SSL = false;

    public static final String EMAIL_SUBJECT_RECOVER_PASSWORD_ES = "Jobster - Recuperar Contraseña";
    public static final String EMAIL_SUBJECT_RECOVER_PASSWORD_EN = "Jobster - Recover Password";
    public static final String EMAIL_SUBJECT_USER_ACTIVATION_ES = "Jobster - Activar jobster";
    public static final String EMAIL_SUBJECT_USER_ACTIVATION_EN = "Jobster - jobster's activation ";
}
