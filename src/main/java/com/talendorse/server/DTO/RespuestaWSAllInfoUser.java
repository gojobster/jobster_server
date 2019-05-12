package com.talendorse.server.DTO;

import com.talendorse.server.model.tables.records.UsersRecord;

import java.util.List;

public class RespuestaWSAllInfoUser {

	public String urlAvatar;
	public String email;
	public String telefono;
	public String name;
	public String surname;
	public List<String> skills;
	public List<String> idioms;

	public RespuestaWSAllInfoUser(UsersRecord endorser, List<String> lstSkills, List<String> lstIdioms) {
		this.urlAvatar = endorser.getPictureUrl();
		this.email = endorser.getEmail();
		this.telefono = endorser.getPhoneNumber();
		this.name = endorser.getName();
		this.surname = endorser.getSurname();
		this.skills = lstSkills;
		this.idioms = lstIdioms;
	}
}
