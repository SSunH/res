package Sun.crud.res.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;  // 추가
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  // 추가

@Controller
@RequestMapping("/main")  // 추가
public class ResourceController {

    @GetMapping
    public String main() {   
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("Current User: " + username);        
        return "main";
    }

    @PostMapping
    public String handlePost(@RequestBody Map<String, String> requestBody) {
        // POST 요청 처리 로직 추가
        System.out.println("POST 요청이 정상적으로 처리되었습니다.");

        // 토큰 값 확인
        String accessToken = requestBody.get("access_token");
        System.out.println("Received Access Token: " + accessToken);

        return "main";
    }

}
