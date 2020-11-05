package no.hvl.dat152.obl4.util;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.SecureRandom;

public class CSRFUtils {

    public static void generateCSRFToken(HttpServletRequest request) {
        SecureRandom sr = new SecureRandom();
        byte[] csrf = new byte[16];
        sr.nextBytes(csrf);
        String token = Base64.encodeBase64URLSafeString(csrf);
        request.getSession().setAttribute("csrftoken", token);
    }

    public static boolean isCSRFTokenMatch(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // get the token from the session
        String sessionToken = (String) session.getAttribute("csrftoken");
        // get the token submitted with the form
        String requestToken = request.getParameter("csrftoken");
        // check whether they match
        if (sessionToken.equals(requestToken))
            return true;
        else {
            return false;
        }
    }
}
