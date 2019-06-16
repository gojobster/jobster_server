package com.talendorse.server.POCO;

import java.sql.Timestamp;

public class UserPOCO {
    public int idUser;
    public String name;
    public String surname;
    public String urlAvatar;
    public String email;
    public String phone;
    public String language;
    public Timestamp date_created;
    public Timestamp last_connection;

    public UserPOCO(int idUser, String name, String surname, String urlAvatar, String email, String phone, String language, Timestamp date_created, Timestamp last_connection) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.urlAvatar = urlAvatar;
        this.email = email;
        this.phone = phone;
        this.language = language;
        this.date_created = date_created;
        this.last_connection = last_connection;
    }
}
