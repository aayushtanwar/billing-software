// package com.project.billing_software.config;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// import javax.crypto.SecretKey;
// import javax.crypto.spec.SecretKeySpec;
// import org.springframework.stereotype.Component;

// import java.nio.charset.StandardCharsets;
// import java.security.Key;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.function.Function;

// @Component
// public class JwtUtil {

//     private String SECRET_KEY = "my_secret_key"; // Replace with a stronger key

//     // Get signing key using SecretKeySpec
//      private Key getSigningKey() {
//         byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
//         return new SecretKeySpec(keyBytes, "HmacSHA256");
//     }

//     // Generate JWT token using the modern claims() builder
//     public String generateToken(String username) {
//         Map<String, Object> claims = new HashMap<>();
//         // Add any custom claims here if necessary
//         return Jwts.builder()
//                 .claims(claims)  // Use claims() instead of setClaims()
//                 .subject(username) // Use 'subject' to set the username
//                 .issuedAt(new Date(System.currentTimeMillis())) // Set the issued date
//                 .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token validity for 10 hours
//                 .signWith(getSigningKey()) // Use Jwts.SIG for signing
//                 .compact();
//     }

//     // Validate the token
//     public Boolean validateToken(String token, String username) {
//         String extractedUsername = extractUsername(token);
//         return (extractedUsername.equals(username) && !isTokenExpired(token));
//     }

//     // Extract username from the token
//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     // Check if the token is expired
//     private Boolean isTokenExpired(String token) {
//         return extractExpiration(token).before(new Date());
//     }

//     // Extract the expiration date from the token
//     public Date extractExpiration(String token) {
//         return extractClaim(token, Claims::getExpiration);
//     }

//     // Extract claims from the token
//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     // Helper to extract all claims
//     private Claims extractAllClaims(String token) {
//         return Jwts.parser() 
//                 .verifyWith((SecretKey) getSigningKey()) // Updated to use verifyWith
//                 .build()
//                 .getBody();
//     }
// }