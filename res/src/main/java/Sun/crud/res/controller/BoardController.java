//package Sun.crud.res.controller;
//
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//public class BoardController {
//	private RestTemplate restTemplate;
//
//    @RequestMapping("/board")
//    public String board(HttpServletRequest request, HttpSession session) {        // 세션에서 토큰 가져오기
//        String accessToken = (String) session.getAttribute("accessToken");
//
//        // 토큰이 있다면 헤더에 추가
//        if (accessToken != null) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", "Bearer " + accessToken);
//
//            // RestTemplate 또는 HttpClient 등을 사용하여 헤더를 설정하고 요청을 보낼 수 있습니다.
//            // 이 부분은 사용하고 있는 라이브러리에 따라 달라집니다.
//            // 여기서는 ResponseEntity를 사용하는 가상의 예시를 보여드립니다.
//            ResponseEntity<String> responseEntity = restTemplate.exchange(
//                    "http://localhost:9090/board",
//                    HttpMethod.GET,
//                    new HttpEntity<>(headers),
//                    String.class
//            );
//
//            // 응답 처리 등의 로직 수행
//            String responseBody = responseEntity.getBody();
//            System.out.println("Response from /board: " + responseBody);
//        } else {
//            System.out.println("No access token found in session.");
//        }
//
//        return "게시판 엔드포인트";
//    }
//}
