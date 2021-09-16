package sjy.jaengsplay.api.portal.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.framework.util.PointUtil;
import sjy.jaengsplay.api.portal.user.domain.Point;
import sjy.jaengsplay.api.portal.user.repository.PointRepository;
import sjy.jaengsplay.api.portal.user.service.PointService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PointServiceImpl implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public List<Point> listPoint(String userEmail) {
        return pointRepository.findAllByUserEmail(userEmail);
    }

    /**
     * 포인트 적립
     * @param pointUtil
     */
    @Override
    public void insertPoint(PointUtil pointUtil) {
        Point point = new Point();

        point.setContent(pointUtil.getValue());
        point.setAmt(pointUtil.getAmt());
        point.setCreatedDate(new Date());
        point.setType("적립");

        pointRepository.save(point);
    }
}
