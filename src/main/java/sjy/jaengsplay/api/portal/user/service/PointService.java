package sjy.jaengsplay.api.portal.user.service;

import sjy.jaengsplay.api.framework.util.PointUtil;
import sjy.jaengsplay.api.portal.user.domain.Point;

import java.util.List;

public interface PointService {

    List<Point> listPoint(String userEmail);

    void insertPoint(PointUtil pointUtil);

}
