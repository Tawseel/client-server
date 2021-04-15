package com.tawseel.clients_server;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("singleton")
public class TokensManager {

    private final String key = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
    final String userIdHeaderKey = "userId";

    public Integer verifyToken(String token) {
        Integer userId = null;
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            JwsHeader header = claimsJws.getHeader();
            Date tokenExpiration = claimsJws.getBody().getExpiration();
            Date now = new Date();
            if (tokenExpiration.after(now)) {
                userId = (int) header.get(userIdHeaderKey);
            }
            return userId;
        } catch (Exception e) {
            System.out.println("Time out");
        }

        return userId;
    }
}