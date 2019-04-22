package com.talendorse.server.DTO;

import com.talendorse.server.types.VerificationStateType;

public class RespuestaWSLogin {
	public String apiKey;
	public String urlAvatar;
	public String username;
	public String name;
	public String surname;
	public String token;
	public VerificationStateType state;

	public RespuestaWSLogin(String apiKey, String urlAvatar, String username, String name, String surname, String token) {
		this.apiKey = apiKey;
		this.urlAvatar = urlAvatar;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.token = token;
	}

	public RespuestaWSLogin(String apiKey, String urlAvatar, String username, String name, String surname, String token, VerificationStateType state) {
		this.apiKey = apiKey;
		this.urlAvatar = urlAvatar;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.state = state;
		this.token = token;
	}
}
