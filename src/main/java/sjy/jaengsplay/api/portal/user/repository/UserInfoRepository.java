package sjy.jaengsplay.api.portal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sjy.jaengsplay.api.portal.user.domain.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
    UserInfo findByNickname(String nickname);
}
