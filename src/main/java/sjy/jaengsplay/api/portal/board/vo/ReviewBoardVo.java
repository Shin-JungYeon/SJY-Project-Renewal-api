package sjy.jaengsplay.api.portal.board.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReviewBoardVo {
    private Long id;
    private String genre;
    private Date viewingDate;
    private String viewingArea;
    private String viewingScore;
    private String title;
    private String content;
}
