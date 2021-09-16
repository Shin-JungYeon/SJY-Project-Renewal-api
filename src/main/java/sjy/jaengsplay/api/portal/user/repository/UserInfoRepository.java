package sjy.jaengsplay.api.portal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sjy.jaengsplay.api.portal.user.domain.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByEmail(String email);
    UserInfo findByNickname(String nickname);
}
