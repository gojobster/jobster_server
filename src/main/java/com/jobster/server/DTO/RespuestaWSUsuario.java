package com.jobster.server.DTO;

public class RespuestaWSUsuario {

	public String urlAvatar;
	public String email;
	public String telefono;
	public String name;
	public String surname;

	public RespuestaWSUsuario(String urlAvatar, String email, String telefono, String name, String surname) {
		this.urlAvatar = urlAvatar;
		this.email = email;
		this.telefono = telefono;
		this.name = name;
		this.surname = surname;
	}
}
