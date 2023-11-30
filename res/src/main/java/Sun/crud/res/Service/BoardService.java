package Sun.crud.res.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sun.crud.res.Repository.BoardRepository;
import Sun.crud.res.entity.BoardEntity;

@Service
public class BoardService {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd");

	@Autowired
	private BoardRepository boardRepository;

	public void insert(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);
	}

	public List<BoardEntity> getAllPosts() {
		return boardRepository.findAll();
	}

	public BoardEntity getBoardByBoardNo(int boardNo) {
		return boardRepository.findByBoardNo(boardNo);
	}

	@Transactional
	public void deleteByBoardNo(int boardNo) {
		boardRepository.deleteByBoardNo(boardNo);
	}

	public void updateBoard(int boardNo, String newTitle, String newContent) {
		// 공지사항 수정
		BoardEntity boardEntity = boardRepository.findByBoardNo(boardNo);
		if (boardEntity == null) {
			throw new IllegalArgumentException("해당 글번호의 공지사항이 없습니다.");
		}
		boardEntity.setTitle(newTitle);
		boardEntity.setContent(newContent);
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		boardEntity.setCreatedDate(formattedDate);
		boardRepository.save(boardEntity);
	}

	public BoardEntity getBoardBy(int boardNo) {
		return boardRepository.findByBoardNo(boardNo);
	}

	public void updateBoard(int boardNo, String newTitle, String newContent, String username) {

		BoardEntity boardEntity = boardRepository.findByBoardNo(boardNo);
		if (boardEntity == null) {
			throw new IllegalArgumentException("해당 글번호의 공지사항이 없습니다.");
		}
		boardEntity.setTitle(newTitle);
		boardEntity.setContent(newContent);
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(formatter);
		boardEntity.setCreatedDate(formattedDate);
		boardEntity.setWriter(username);
		boardRepository.save(boardEntity);

	}

	public boolean isUserAuthor(int boardNo, String username) {
	    return boardRepository.existsByBoardNoAndWriter(boardNo, username);

	}

}
