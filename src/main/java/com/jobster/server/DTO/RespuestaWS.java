package com.jobster.server.DTO;

public class RespuestaWS<T> {
	public int responseStatus;
	public T message;
	public String error;


	public RespuestaWS(){}
}