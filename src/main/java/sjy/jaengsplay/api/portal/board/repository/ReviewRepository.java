package sjy.jaengsplay.api.portal.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjy.jaengsplay.api.portal.board.domain.ReviewBoard;

public interface ReviewRepository extends JpaRepository<ReviewBoard, Long> {

}
