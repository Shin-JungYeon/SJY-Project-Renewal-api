package sjy.jaengsplay.api.portal.board.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.board.service.ReviewService;
import sjy.jaengsplay.api.portal.board.vo.ReviewBoardVo;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/reviews")
    public void insertReview(@RequestBody ReviewBoardVo reviewBoardVo) {
        reviewService.insertReview(reviewBoardVo);
    }
}
