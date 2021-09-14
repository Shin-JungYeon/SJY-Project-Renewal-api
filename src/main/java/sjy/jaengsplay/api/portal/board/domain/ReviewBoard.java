package sjy.jaengsplay.api.portal.board.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity(name = "review_board_tb")
public class ReviewBoard {
    @ApiModelProperty(value = "리뷰 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "장르")
    @Column(nullable = false)
    private String genre;

    @ApiModelProperty(value = "관람 일자")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date viewingDate;

    @ApiModelProperty(value = "관람 장소")
    @Column(nullable = false)
    private String viewingArea;

    @ApiModelProperty(value = "관람 평점")
    @Column(nullable = false)
    private String viewingScore;

    @ApiModelProperty(value = "리뷰 작성 사용자 아이디")
    @Column(nullable = false)
    private String createdUserId;

    @ApiModelProperty(value = "리뷰 제목")
    @Column(nullable = false, length = 200)
    private String title;

    @ApiModelProperty(value = "리뷰 내용")
    @Column(nullable = false, length = 2000)
    private String content;
}
