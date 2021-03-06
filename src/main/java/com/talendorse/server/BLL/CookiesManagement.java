package com.talendorse.server.BLL;

import com.talendorse.server.types.TalendorseErrorType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.*;

public class CookiesManagement {
    public static boolean cookieHasToken(HttpServletRequest request) throws TalendorseException {
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals("token"))
                    return TokenManagement.isTokenValid(c.getValue());
            }
        }
        return false;
    }
    public static int getIdFromCookie(HttpServletRequest request) throws TalendorseException {
        try {
            if (request.getCookies() != null) {
                for (Cookie c : request.getCookies()) {
                    if (c.getName().equals("token"))
                        return TokenManagement.getUserIdFromToken(c.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static String getTokenFromCookie(HttpServletRequest request){
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals("token"))
                    return c.getValue();
            }
        }
        return null;
    }
    public static String getLastUrlFromCookie(HttpServletRequest request){
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if (c.getName().equals("last_url"))
                    return c.getValue();
            }
        }
        return null;
    }
    public static void deleteTokenCookie (HttpServletResponse response) throws TalendorseException{
        try {
            Cookie cookie = new Cookie("token", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new TalendorseException(TalendorseErrorType.GENERIC_ERROR);
        }
    }
}