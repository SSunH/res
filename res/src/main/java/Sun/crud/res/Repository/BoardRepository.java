package Sun.crud.res.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Sun.crud.res.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

	BoardEntity findByBoardNo(int boardNo);
	void deleteByBoardNo(int boardNo);
	boolean existsByBoardNoAndWriter(int boardNo, String username);


}

