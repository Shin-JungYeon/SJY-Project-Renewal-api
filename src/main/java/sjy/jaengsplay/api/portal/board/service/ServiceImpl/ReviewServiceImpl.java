package sjy.jaengsplay.api.portal.board.service.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.portal.board.domain.ReviewBoard;
import sjy.jaengsplay.api.portal.board.repository.ReviewRepository;
import sjy.jaengsplay.api.portal.board.service.ReviewService;
import sjy.jaengsplay.api.portal.board.vo.ReviewBoardVo;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void insertReview(ReviewBoardVo reviewBoardVo) {
        ReviewBoard reviewBoard = new ReviewBoard();

        reviewBoard.setTitle(reviewBoardVo.getTitle());
        reviewBoard.setContent(reviewBoardVo.getContent());
        reviewBoard.setGenre(reviewBoardVo.getGenre());
        reviewBoard.setViewingDate(reviewBoardVo.getViewingDate());
        reviewBoard.setViewingArea(reviewBoardVo.getViewingArea());
        reviewBoard.setViewingScore(reviewBoardVo.getViewingScore());
        reviewBoard.setCreatedUserId("login id");
    }
}
