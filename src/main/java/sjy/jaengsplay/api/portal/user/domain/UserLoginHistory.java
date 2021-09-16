package sjy.jaengsplay.api.portal.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity(name = "user_login_history_tb")
public class UserLoginHistory {
    @ApiModelProperty(value = "포인트 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "이메일")
    @Column(nullable = false, unique = true, length = 200)
    private String userEmail;

    @ApiModelProperty(value = "포인트 생성일자")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastLoginDate;
}
