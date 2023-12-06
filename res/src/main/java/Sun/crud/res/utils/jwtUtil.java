package Sun.crud.res.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


@Component
public class jwtUtil {
	
	public static String SECRET_KEY;
	
	
    @Value("${jwt.secretKey}")
    public void setSecretKey(String SECRET_KEY) {
    	jwtUtil.SECRET_KEY = SECRET_KEY;
    }
    
    public static String extractSubject(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();            
            return claims.get("name", String.class);
        } catch (Exception e) {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public static String extractRole(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();            
            return claims.get("role", String.class);
        } catch (Exception e) {
            e.printStackTrace();            
            return null;
        }	
    }
    
    public static boolean isUserAdmin(String jwtToken) {
        // JWT 토큰에서 "role" 클레임 추출
        String role = extractRole(jwtToken);

        // "ADMIN" 역할인 경우에만 권한을 부여
        return "ADMIN".equals(role);
    }
    
    public static String getAccessTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String accessToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                    break;
                }
            }
        }
        return accessToken;
    }    
	

}
