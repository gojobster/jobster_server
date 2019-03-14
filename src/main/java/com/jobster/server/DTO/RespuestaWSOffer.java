package com.jobster.server.DTO;

import java.sql.Timestamp;

public class RespuestaWSOffer {

	public String position;
	public String summary;
	public String experience;
	public String city;
	public String job_functions;
	public String date_init;
	public String date_end;

	public RespuestaWSOffer(String position, String summary, String experience, String city, String job_functions, Timestamp date_init, Timestamp date_end) {
		this.position = position;
		this.summary = summary;
		this.experience = experience;
		this.city = city;
		this.job_functions = job_functions;
		this.date_init = date_init.toString();
		this.date_end = date_end.toString();
	}
}
