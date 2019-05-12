package com.talendorse.server.util;

import com.talendorse.server.BLL.Constantes;
import com.talendorse.server.BLL.TalendorseException;
import com.talendorse.server.types.TalendorseErrorType;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Properties;

public class Email {
	public static void sendEmail(String toEmail, String subject, String body) {
		sendEmail(prepareEmail(), toEmail, subject, body);

		//****************************************
		//sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
		//sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
	}

	public static void sendEmailrecomendation(String local_url, String toEmail, String endorserName, String candidateName, String codeOffer) {
		try {
			String url_email = Constantes.URL_EMAIL_SEND_RECOMMENDATION_URL_EN;
			String subject = Constantes.EMAIL_SUBJECT_USER_ACTIVATION_ES;

			String body = TextoMail(local_url, url_email);
			body = body.replace("{endorser}",endorserName);
			body = body.replace("{new_user}",candidateName);
			body = body.replace("{url_recomendation}", Constantes.TALENDORSE_URL +"offer/"+ codeOffer);

			sendEmail(prepareEmail(), toEmail, subject, body);
		} catch (TalendorseException e) {//TODO: tratar el error.
			e.printStackTrace();
		}

		//****************************************
		//sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
		//sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
	}

	private static Session prepareEmail() {
		//creamos la session
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", Constantes.SRV_EMAIL_HOST); //SMTP Host
		props.put("mail.smtp.socketFactory.port", Constantes.SRV_EMAIL_PORT); //SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", Constantes.SRV_EMAIL_PORT); //SMTP Port

		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constantes.SRV_EMAIL_USR, Constantes.SRV_EMAIL_PWD);
			}
		};

		return Session.getInstance(props, auth);
	}


	private static void sendEmail(Session session, String toEmail, String subject, String body){
		try
		{
			MimeMessage msg = createMimeMessage(session, toEmail,subject);
			msg.setContent(body, "text/html; charset=utf-8");

			System.out.println("Message is ready");
			Transport.send(msg);
			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String TextoMail(String url, String url_location) throws TalendorseException {
		try {
			return GetURLContent(url, url_location);
		} catch (Exception e) {
			throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
		}
	}

	private static String GetURLContent(String url_header, String url_location) throws TalendorseException {
		StringBuilder content = new StringBuilder();
		try {
			// create a url object
			URL url = new URL(url_header+url_location);

			// create a urlconnection object
			URLConnection urlConnection = url.openConnection();

			// wrap the urlconnection in a bufferedreader
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line).append("\n");
			}
			bufferedReader.close();
		} catch (Exception e) {
			throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
		}
		return content.toString();
	}

	private static MimeMessage createMimeMessage(Session session, String toEmail, String subject){
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress(Constantes.SRV_EMAIL_FROM_ACCOUNT, "Talendorse"));

			msg.setReplyTo(InternetAddress.parse(Constantes.SRV_EMAIL_FROM_ACCOUNT, false));

			msg.setSubject(subject, "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return  msg;
	}
	public enum TipoFormatoFichero {
		None,
		Binario,
		Plano
    }
}
