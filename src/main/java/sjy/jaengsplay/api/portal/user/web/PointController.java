package sjy.jaengsplay.api.portal.user.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.user.domain.Point;
import sjy.jaengsplay.api.portal.user.service.PointService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class PointController {
    
    @Autowired
    private PointService pointService;

    @ApiOperation(value = "사용자 포인트 목록 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userEmail", value = "사용자 이메일", dataType = "Long", paramType = "path")
    })
    @GetMapping(value = "/users/{userEmail}/points")
    public List<Point> listPoint(@PathVariable String userEmail) {
        return pointService.listPoint(userEmail);
    }
}
