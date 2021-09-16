package sjy.jaengsplay.api.portal.user.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.user.domain.UserInfo;
import sjy.jaengsplay.api.portal.user.service.UserService;
import sjy.jaengsplay.api.portal.user.vo.UserInfoVo;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "회원가입 중복체크")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "이메일", dataType = "String", paramType = "param"),
            @ApiImplicitParam(name = "nickname", value = "닉네임", dataType = "String", paramType = "param")
    })
    @GetMapping(value = "/users/join/duplicate")
    public UserInfo checkDuplicate(@RequestParam(required = false) String email,
                                   @RequestParam(required = false) String nickname) {
        return userService.checkDuplicate(email, nickname);
    }

    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userInfoVo", value = "사용자 정보 vo", dataType = "UserInfoVo", paramType = "body")
    })
    @PostMapping(value = "/users/join")
    public void insertUserInfo(@RequestBody UserInfoVo userInfoVo) {
        userService.insertUserInfo(userInfoVo);
    }

    @ApiOperation(value = "회원정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "이메일", dataType = "String", paramType = "path")
    })
    @GetMapping(value = "/users/{email}")
    public UserInfo getUserInfo(@PathVariable String email) {
        return userService.getUserInfo(email);
    }

    @ApiOperation(value = "회원정보 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfoVo", value = "사용자 정보 vo", dataType = "UserInfoVo", paramType = "body")
    })
    @PutMapping(value = "/users")
    public void updateUserInfo(@RequestBody UserInfoVo userInfoVo) {
        userService.updateUserInfo(userInfoVo);
    }

}
