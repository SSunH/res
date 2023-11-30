package Sun.crud.res.controller;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import Sun.crud.res.Service.BoardService;
import Sun.crud.res.dto.BoardDTO;
import Sun.crud.res.dto.WriteDTO;
import Sun.crud.res.entity.BoardEntity;
import Sun.crud.res.utils.jwtUtil;


@Controller
public class BoardController {
	
	public static String SECRET_KEY;
	
    @Value("${jwt.secretKey}")
    public void setSecretKey(String SECRET_KEY) {
    	BoardController.SECRET_KEY = SECRET_KEY;
    }
    
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");

	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
		public ModelAndView board() {
		ModelAndView mv = new ModelAndView("board");
		List<BoardEntity> boardList = boardService.getAllPosts();
		mv.addObject("board", boardList);		
		
		return mv;
		}
	

    @GetMapping("/write")
    public String write() {
        return "write";
    }
    @GetMapping("/edit")
    public String editBoard(@RequestParam(name = "boardNo") int boardNo, Model model) {
    	
        model.addAttribute("boardNo", boardNo);
        BoardEntity boardEntity = boardService.getBoardByBoardNo(boardNo);
        model.addAttribute("boardEntity", boardEntity);
        return "edit";
    }
    
 // 공지사항 작성
    @ResponseBody
    @PostMapping("/write") 	
    public ResponseEntity<?> notice(@RequestBody WriteDTO writeDTO, HttpServletRequest request) {
        try {
            String accessToken = jwtUtil.getAccessTokenFromCookies(request);
            System.err.println(accessToken);

            // 엑세스 토큰 파싱 및 작성자 설정
            String username = jwtUtil.extractSubject(accessToken);
            System.err.println(username);

            String title = writeDTO.getPostTitle();
            String content = writeDTO.getPostContent();

            BoardEntity boardEntity = new BoardEntity();
            boardEntity.setTitle(title);
            boardEntity.setContent(content);
            boardEntity.setWriter(username);
         // 현재 날짜의 월/일 설정
            LocalDate currentDate = LocalDate.now();
            String formattedDate = currentDate.format(formatter);
            boardEntity.setCreatedDate(formattedDate);

            boardService.insert(boardEntity);

            return ResponseEntity.status(200).body("ok");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
    
    @ResponseBody
    @GetMapping("/board/detail/{boardNo}")
    public ModelAndView noticeDetail(@PathVariable int boardNo) {
        ModelAndView mv = new ModelAndView("detail"); // Assuming you have a "detail" view

        BoardEntity boardEntity = boardService.getBoardByBoardNo(boardNo);

        if (boardEntity == null) {
            mv.addObject("error", "Notice not found");
        } else {
            mv.addObject("boardEntity", boardEntity);
        }

        return mv;
    }

    @ResponseBody
    @PutMapping("/board/edit/{boardNo}")
    public ModelAndView updateBoard(@PathVariable int boardNo, HttpServletRequest request, @RequestParam String newTitle, @RequestParam String newContent ){
    	ModelAndView mv = new ModelAndView("redirect:/board"); // Assuming you want to redirect after updating

        try {
            String accessToken = jwtUtil.getAccessTokenFromCookies(request);

            // 엑세스 토큰 파싱 및 작성자 설정
            String username = jwtUtil.extractSubject(accessToken);

            // 자기가 쓴 글에 대해서만 수정 가능
            if (boardService.isUserAuthor(boardNo, username)) {
                boardService.updateBoard(boardNo, newTitle, newContent, username);
            } else {
                return new ModelAndView("403 Forbidden");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("403 Forbidden");
        }

        return mv;
    }

    @ResponseBody	
    @DeleteMapping("/board/delete/{boardNo}")
    public ModelAndView deleteBoardEntry(@PathVariable int boardNo, HttpServletRequest request) {
        try {
            String accessToken = jwtUtil.getAccessTokenFromCookies(request);
            boolean isAdmin = jwtUtil.isUserAdmin(accessToken);

            if (isAdmin) {
                // 권한이 있는 경우 게시물 삭제
                boardService.deleteByBoardNo(boardNo);
                return new ModelAndView("redirect:/board");
            } else {
                // 권한이 없는 경우 403 Forbidden 반환
                return new ModelAndView("403 Forbidden");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions if needed
            return new ModelAndView("403 Forbidden");
        }
    }

    


}
