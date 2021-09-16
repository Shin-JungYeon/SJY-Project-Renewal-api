package sjy.jaengsplay.api.portal.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "user_info_tb")
public class UserInfo {
    @ApiModelProperty(value = "사용자 정보 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "이메일")
    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @ApiModelProperty(value = "비밀번호")
    @Column(nullable = false, length = 200)
    private String password;

    @ApiModelProperty(value = "사용자 이름")
    @Column(nullable = false, length = 200)
    private String userName;

    @ApiModelProperty(value = "닉네임")
    @Column(nullable = false, unique = true, length = 200)
    private String nickname;

    @ApiModelProperty(value = "사용자 유형", notes = "A: admin / R: related / G: general")
    @Column(nullable = false, columnDefinition = "char(1) default 'G'")
    private String userType;

    @ApiModelProperty(value = "성별", notes = "F: female / M: male")
    @Column(nullable = false, columnDefinition = "char(1)")
    private String gender;

    @ApiModelProperty(value = "전화번호")
    @Column(nullable = false, length = 200)
    private String phoneNumber;

    @ApiModelProperty(value = "관심 장르", notes = "공포,스릴러,로맨스 / null")
    @Column(nullable = false, length = 200)
    private String genre;
}
