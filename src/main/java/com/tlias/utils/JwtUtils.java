package com.tlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey = "littleNine";
    private static Date expire = new Date(System.currentTimeMillis() + 3600 * 1000);
    public static String generateJwt (Map<String,Object> claims){
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,signKey).addClaims(claims).setExpiration(expire).compact();
        return jwt;
    }
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser().setSigningKey(signKey).parseClaimsJws(jwt).getBody();
        return claims;
    }
}
