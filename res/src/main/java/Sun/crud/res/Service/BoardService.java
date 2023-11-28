package Sun.crud.res.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sun.crud.res.Repository.BoardRepository;
import Sun.crud.res.entity.BoardEntity;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public void insert(BoardEntity boardEntity) {
		boardRepository.save(boardEntity);		
	}
	
}
