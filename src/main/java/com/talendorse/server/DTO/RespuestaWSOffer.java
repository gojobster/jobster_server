package com.talendorse.server.DTO;

import com.talendorse.server.util.Fechas;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class RespuestaWSOffer {
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
	public String date_start_string;
	public String date_end_string;

	public RespuestaWSOffer(int id_offer, String nameCompany, String path_image_company, String position, String summary, String city,
							int reward, Integer salary_min, Integer salary_max, Timestamp date_start, Timestamp date_end) {
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
		this.time_from_start = Fechas.daysFromNow(date_start);
		this.time_to_end = Fechas.daysFromNow(date_end);
		this.date_start_string = Fechas.getDateStringFromTimeStamp(date_start);
		this.date_end_string = Fechas.getDateStringFromTimeStamp(date_end);
	}

	public RespuestaWSOffer(JSONObject object){
		try {
			this.id_offer = object.getInt("id_offer");
			this.nameCompany = object.getString("nameCompany");
			this.path_image_company = object.getString("path_image_company");;
			this.position = object.getString("position");
			this.summary = object.getString("summary");
			this.city = object.getString("city");
			this.reward = object.getInt("reward");
			this.salary_min = object.getInt("salary_min");
			this.salary_max = object.getInt("salary_max");
			this.date_start = new Timestamp(Long.parseLong(object.getString("date_start")));
			this.date_end = new Timestamp(Long.parseLong(object.getString("date_end")));
			this.time_from_start = Fechas.daysFromNow(date_start);
			this.time_to_end = Fechas.daysFromNow(date_end);
			this.date_start_string = Fechas.getDateStringFromTimeStamp(date_start);
			this.date_end_string = Fechas.getDateStringFromTimeStamp(date_end);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
