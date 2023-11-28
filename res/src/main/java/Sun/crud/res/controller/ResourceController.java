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
        return "main";
    }

    @PostMapping
    public String handlePost() {
        return "main";
    }

}
