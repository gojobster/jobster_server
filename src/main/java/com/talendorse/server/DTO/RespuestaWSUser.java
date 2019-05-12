package com.talendorse.server.DTO;

public class RespuestaWSUser {

	public String urlAvatar;
	public String email;
	public String phone;
	public String name;
	public String surname;
	public int userId;

	public RespuestaWSUser(String name, String surname, String email, String urlAvatar, String phone, int userId) {
		this.name = name;
		this.surname = surname;
		this.urlAvatar = urlAvatar;
		this.email = email;
		this.phone = phone;
		this.userId = userId;
	}
}
