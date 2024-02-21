package com.yashasvi.ums.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

	private static String key ="abcde";
	
	private static final SecretKey SECRET_KEY=Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
	
	
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token,Claims::getSubject);
	}
	

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		
		return claimResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().verifyWith(SECRET_KEY).build()
		        .parseSignedClaims(token)
		        .getPayload();
	}
	
	public boolean ValidateToken(String token,UserDetails userDetails) {
		String userName= getUserNameFromToken(token);
		return ( userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	private boolean isTokenExpired(String token) {
	final Date expirationDate =	getExpirationDateFromToken(token);
	return expirationDate.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token,Claims::getExpiration);
	}
}

