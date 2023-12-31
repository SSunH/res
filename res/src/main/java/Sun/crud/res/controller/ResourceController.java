package Sun.crud.res.controller;
import java.util.Map;


import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> handlePost(@RequestBody Map<String, String> requestBody) {
        // requestBody에서 필요한 데이터 추출 및 로직 수행
        String accessToken = requestBody.get("accessToken");

        return ResponseEntity.ok("Success");
    }


}
