package sjy.jaengsplay.api.portal.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sjy.jaengsplay.api.portal.board.domain.FreeBoard;

public interface FreeRepository extends JpaRepository<FreeBoard, Long> {
    Page<FreeBoard> findAllByTitleContaining(Pageable pageable, String searchText);
    Page<FreeBoard> findAll(Pageable pageable);
}
