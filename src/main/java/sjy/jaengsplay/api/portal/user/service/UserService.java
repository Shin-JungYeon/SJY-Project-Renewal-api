package sjy.jaengsplay.api.portal.user.service;


import sjy.jaengsplay.api.portal.user.domain.UserInfo;
import sjy.jaengsplay.api.portal.user.vo.UserInfoVo;

public interface UserService {

    UserInfo checkDuplicate(String email, String nickname);

    void insertUserInfo(UserInfoVo userInfoVo);

    UserInfo getUserInfo(String email);

    void updateUserInfo(UserInfoVo userInfoVo);
}
