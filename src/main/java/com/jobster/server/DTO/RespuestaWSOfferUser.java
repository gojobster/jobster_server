package com.jobster.server.DTO;

import java.sql.Timestamp;

public class RespuestaWSOfferUser {
	public int state;
	public int idJobster;
	public Integer idCandidato;

	public String name_jobster;
	public String surname_josbter;

	public String name_candidate;
	public String surname_candidate;
	public String email_candidate;

	public String position;
	public String summary;

	public Timestamp date_created;
	public Timestamp date_accepted_candidate;
	public Timestamp date_end;

	public RespuestaWSOfferUser(int state, int idJobster, String name_jobster, String surname_josbter, String email_candidate, String position,
								String summary, Timestamp date_created, Timestamp date_accepted_candidate, Timestamp date_end) {
		this.state = state;
		this.idJobster = idJobster;
		this.name_jobster = name_jobster;
		this.surname_josbter = surname_josbter;
		this.email_candidate = email_candidate;
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
