package com.travelapp.travel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    //A token: just a long generated string that is unique to prove who the user is, for authentification purposes

    //methods for security, implemented from the jjwt library in pom.xml
    @Value("${jwt.secret}")
    private String secretKey;

    public String generateToken(String email) {
        return Jwts.builder().setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact(); //builds the final token string/unique code
    }

    private Key getSigningKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractEmail (String token) {

        return Jwts.parserBuilder()//Parsing and turning it into a java object
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); //we get back the subject = email
    }

    public boolean isTokenValid (String token) {

        try{
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true; //if this happens then the token is valid

        }
        catch(Exception e){
            return false; //not valid
        }
    }




}
