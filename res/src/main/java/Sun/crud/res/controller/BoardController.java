package Sun.crud.res.controller;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;  // 추가
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  // 추가
import org.springframework.web.bind.annotation.ResponseBody;


import Sun.crud.res.Service.BoardService;
import Sun.crud.res.dto.WriteDTO;
import Sun.crud.res.entity.BoardEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Controller
public class BoardController {
	
	public static String SECRET_KEY;
	
    @Value("${jwt.secretKey}")
    public void setSecretKey(String SECRET_KEY) {
    	BoardController.SECRET_KEY = SECRET_KEY;
    }
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
		public String board() {
			return "board";
		}
	

    @GetMapping("/write")
    public String write() {
        return "write";
    }
    
 // 공지사항 작성
    @ResponseBody
    @PostMapping("/write") 	
    public ResponseEntity<?> notice(@RequestBody WriteDTO writeDTO, HttpServletRequest request) {
        try {
            // 엑세스 토큰 가져오기
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
            System.err.println(accessToken);

            // 엑세스 토큰 파싱 및 작성자 설정
            String username = extractSubject(accessToken);
            System.err.println(username);

            String title = writeDTO.getPostTitle();
            String content = writeDTO.getPostContent();

            BoardEntity boardEntity = new BoardEntity();
            boardEntity.setTitle(title);
            boardEntity.setContent(content);

            boardService.insert(boardEntity);

            return ResponseEntity.status(200).body("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    public static String extractSubject(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그 출력
            return null; // 예외 발생 시 null 반환 또는 적절한 처리를 수행
        }
    }



  

}
