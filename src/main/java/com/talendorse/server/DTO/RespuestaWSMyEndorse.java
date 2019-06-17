package com.talendorse.server.DTO;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class RespuestaWSMyEndorse {
	public int id_offer;
	public String nameCompany;
	public String path_image_company;
	public String position;
	public String summary;
	public String city;
	public int reward;
	public Integer salary_min;
	public Integer salary_max;
	public Timestamp date_start;
	public Timestamp date_end;
	public Integer time_from_start;
	public Integer time_to_end;
	public String candidate;
	public String path_image_candidate;
	public String email_candidate;
	public int idCandidate;
	public int status;
	public String date_start_string;
	public String date_end_string;

	public RespuestaWSMyEndorse(int id_offer, String nameCompany, String path_image_company, String position, String summary, String city,
                                int reward, Integer salary_min, Integer salary_max, Timestamp date_start, Timestamp date_end,
								String candidate, String path_image_candidate, String email_candidate, int idCandidate, int status) {
		this.id_offer = id_offer;
		this.nameCompany = nameCompany;
		this.path_image_company = path_image_company;
		this.position = position;
		this.summary = summary;
		this.city = city;
		this.reward = reward;
		this.salary_min = salary_min;
		this.salary_max = salary_max;
		this.date_end = date_end;
		this.date_start = date_start;
		this.time_from_start = daysFromNow(date_start);
		this.time_to_end = daysFromNow(date_end);
		this.idCandidate = idCandidate;
		this.candidate = candidate;
		this.path_image_candidate = path_image_candidate;
		this.email_candidate = email_candidate;
		this.status = status;
		this.date_start_string = dateToString(date_start);
		this.date_end_string = dateToString(date_end);
	}
	private Integer daysFromNow(Timestamp myDate){
		LocalDate now = LocalDate.now();
		LocalDate theDate = myDate.toLocalDateTime().toLocalDate();
		Period period = Period.between(theDate, now);
		return Math.abs(period.getDays());
	}
	private String statusName(int status){
		String estado;
		switch(status){
			case -1:
				estado = "Cancelado";
				break;
			case 0:
				estado = "Pendiente";
				break;
			case 1:
				estado = "Unido";
				break;
			case 2:
				estado = "Preseleccionado";
				break;
			case 3:
				estado = "Aceptado";
				break;
			default:
				estado = "No Disponible";
				break;
		}
		return estado;
	}
	private String dateToString(Timestamp timestamp) {
		return new SimpleDateFormat("dd/MM/yyyy").format(timestamp);
	}
}
