package sjy.jaengsplay.api.portal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sjy.jaengsplay.api.portal.user.domain.Point;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findAllByUserEmail(String userEmail);
}
