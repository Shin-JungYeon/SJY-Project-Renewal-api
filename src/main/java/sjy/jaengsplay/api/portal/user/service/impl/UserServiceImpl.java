package sjy.jaengsplay.api.portal.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.portal.user.domain.UserInfo;
import sjy.jaengsplay.api.portal.user.service.UserService;
import sjy.jaengsplay.api.portal.user.vo.UserInfoVo;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public void insertUserInfo(UserInfoVo userInfoVo) {
        UserInfo userInfo = new UserInfo();

    }
    
}
