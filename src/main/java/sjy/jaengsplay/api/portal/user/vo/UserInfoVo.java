package sjy.jaengsplay.api.portal.user.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private Long id;
    private String email;
    private String password;
    private String userName;
    private String nickname;
    private String userType;
    private String gender;
    private String phoneNumber;
    private String genre;
}
