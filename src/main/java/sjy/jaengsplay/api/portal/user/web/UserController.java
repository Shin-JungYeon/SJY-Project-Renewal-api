package sjy.jaengsplay.api.portal.user.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.user.service.UserService;
import sjy.jaengsplay.api.portal.user.vo.UserInfoVo;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    
    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userInfoVo", value = "사용자 정보 vo", dataType = "UserInfoVo", paramType = "body")
    })
    @PostMapping(value = "/users/join")
    public void insertUserInfo(@RequestBody UserInfoVo userInfoVo) {
        userService.insertUserInfo(userInfoVo);
    }
}
