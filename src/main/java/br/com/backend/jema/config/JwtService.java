
package br.com.backend.jema.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET =
            "JEMA_TMS_CHAVE_SECRETA_2026_SEGURANCA_JWT_123456789";

    private static final long TEMPO_EXPIRACAO = 1000 * 60 * 60;

    private final SecretKey chave = Keys.hmacShaKeyFor(
            SECRET.getBytes(StandardCharsets.UTF_8)
    );

    public String gerarToken(String email) {

        Date agora = new Date();

        Date expiracao = new Date(
                agora.getTime() + TEMPO_EXPIRACAO
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(chave)
                .compact();
    }

    public String extrairEmail(String token) {

        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validarToken(String token) {

        try {
            extrairEmail(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
