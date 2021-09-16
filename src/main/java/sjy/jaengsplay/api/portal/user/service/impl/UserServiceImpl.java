package sjy.jaengsplay.api.portal.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.portal.user.domain.UserInfo;
import sjy.jaengsplay.api.portal.user.repository.UserInfoRepository;
import sjy.jaengsplay.api.portal.user.service.UserService;
import sjy.jaengsplay.api.portal.user.vo.UserInfoVo;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//    public PasswordEncoder getPasswordEncoder() {
//        return this.passwordEncoder;
//    }

    @Override
    public UserInfo checkDuplicate(String email, String nickname) {
        UserInfo userInfo = null;

        if(email != null) {
            userInfo = userInfoRepository.findByEmail(email);
        }
        if(nickname != null) {
            userInfo = userInfoRepository.findByNickname(nickname);
        }

        return userInfo;
    }

    @Override
    public void insertUserInfo(UserInfoVo userInfoVo) {
        UserInfo userInfo = new UserInfo();

        userInfo.setEmail(userInfoVo.getEmail());
        userInfo.setPassword(userInfoVo.getPassword()); // TODO: 암호화
        userInfo.setUserName(userInfoVo.getUserName());
        userInfo.setNickname(userInfoVo.getNickname());
        userInfo.setUserType(userInfoVo.getUserType());
        userInfo.setGender(userInfoVo.getGender());
        userInfo.setPhoneNumber(userInfoVo.getPhoneNumber());
        userInfo.setGenre(userInfoVo.getGenre());

        userInfoRepository.save(userInfo);
    }

    @Override
    public UserInfo getUserInfo(String email) {
        return userInfoRepository.findByEmail(email);
    }

    @Override
    public void updateUserInfo(UserInfoVo userInfoVo) {
        UserInfo userInfo = userInfoRepository.getById(userInfoVo.getId());
        if(userInfo != null) {
            userInfo.setGenre(userInfoVo.getGenre());
            userInfo.setPhoneNumber(userInfoVo.getPhoneNumber());
            userInfo.setNickname(userInfoVo.getNickname());

            userInfoRepository.save(userInfo);
        }
    }
}
