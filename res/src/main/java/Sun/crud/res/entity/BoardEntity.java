package Sun.crud.res.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

import lombok.Data;

@Data
@Entity
@Table(name = "Board")
public class BoardEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "boardNo", length = 5)
	@Comment("글 번호")
	private int boardNo;
	
	@Column(name = "writer", length = 5)
	@Comment("작성자")
	private String writer;
	
	@Column(name = "content", nullable = false , columnDefinition = "TEXT")
    @Comment("글 내용")
    private String content;	
	
	@Column(name = "title", nullable = false , columnDefinition = "TEXT")
    @Comment("글 제목")
    private String title;
	
	@Column(name = "createdDate")
	@Comment("작성날짜")
	private String createdDate;
	
	
}







