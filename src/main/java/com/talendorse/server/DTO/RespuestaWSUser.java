package com.talendorse.server.DTO;

public class RespuestaWSUser {

	public String urlAvatar;
	public String email;
	public String telefono;
	public String name;
	public String surname;

	public RespuestaWSUser(String name, String surname, String email, String urlAvatar, String telefono) {
		this.name = name;
		this.surname = surname;
		this.urlAvatar = urlAvatar;
		this.email = email;
		this.telefono = telefono;
	}
}
