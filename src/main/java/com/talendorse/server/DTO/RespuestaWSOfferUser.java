package com.talendorse.server.DTO;

import java.sql.Timestamp;

public class RespuestaWSOfferUser {
	public int id_recomendation;
	public int id_offer;
	public int state;
	public int idEndorser;
	public Integer idCandidato;

	public String name_endorser;
	public String surname_endorser;

	public String name_candidate;
	public String surname_candidate;
	public String email_candidate;

	public String name_company;
	public String path_image_company;
	public String position;
	public String summary;

	public Timestamp date_created;
	public Timestamp date_accepted_candidate;
	public Timestamp date_end;

	public RespuestaWSOfferUser(int id_recomendation, int id_offer, int state, int idEndorser, String name_endorser, String surname_endorser,
								String email_candidate, String name_company, String path_image_company, String position, String summary,
								Timestamp date_created, Timestamp date_accepted_candidate, Timestamp date_end) {
		this.id_recomendation = id_recomendation;
		this.id_offer = id_offer;
		this.state = state;
		this.idEndorser = idEndorser;
		this.name_endorser = name_endorser;
		this.surname_endorser = surname_endorser;
		this.email_candidate = email_candidate;
		this.name_company = name_company;
		this.path_image_company = path_image_company;
		this.position = position;
		this.summary = summary;
		this.date_created = date_created;
		this.date_accepted_candidate = date_accepted_candidate;
		this.date_end = date_end;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public void setName_candidate(String name_candidate) {
		this.name_candidate = name_candidate;
	}

	public void setSurname_candidate(String surname_candidate) {
		this.surname_candidate = surname_candidate;
	}

}
