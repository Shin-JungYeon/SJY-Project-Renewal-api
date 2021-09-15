package sjy.jaengsplay.api.portal.board.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "free_board_tb")
public class FreeBoard {
    @ApiModelProperty(value = "자유 게시글 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "자유 게시글 제목")
    @Column(nullable = false, length = 200)
    private String title;

    @ApiModelProperty(value = "자유 게시글 내용")
    @Column(nullable = false, length = 2000)
    private String content;

    @ApiModelProperty(value = "자유 게시글 작성자 아이디")
    @Column(nullable = false, length = 200)
    private String createdUserId;

    @ApiModelProperty(value = "자유 게시글 작성일자")
    @Column(nullable = false, length = 200)
    private Date createdDate;

    @ApiModelProperty(value = "자유 게시글 조회수")
    @Column(nullable = false, length = 200)
    private Long viewCnt;

    @ApiModelProperty(value = "자유 게시글 추천수")
    @Column(nullable = false, length = 200)
    private Long likeCnt;

    // 첨부파일

    // 댓글 목록
}
