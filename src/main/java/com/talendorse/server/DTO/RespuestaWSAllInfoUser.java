package com.talendorse.server.DTO;

import com.talendorse.server.model.tables.records.UsersRecord;

import java.util.List;

public class RespuestaWSAllInfoUser {

	public String urlAvatar;
	public String email;
	public String phone;
	public String name;
	public String surname;
	public List<String> skills;
	public List<String> languages;

	public RespuestaWSAllInfoUser(UsersRecord endorser, List<String> lstSkills, List<String> lstLanguages) {
		this.urlAvatar = endorser.getPictureUrl();
		this.email = endorser.getEmail();
		this.phone = endorser.getPhoneNumber();
		this.name = endorser.getName();
		this.surname = endorser.getSurname();
		this.skills = lstSkills;
		this.languages = lstLanguages;
	}
}
