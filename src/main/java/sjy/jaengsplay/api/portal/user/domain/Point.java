package sjy.jaengsplay.api.portal.user.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Entity(name = "point_tb")
public class Point {
    @ApiModelProperty(value = "포인트 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "사용자 아이디")
    @Column(nullable = false)
    private String userEmail;

    @ApiModelProperty(value = "포인트")
    @Column(nullable = false)
    private Long amt;

    @ApiModelProperty(value = "총 포인트")
    @Column(nullable = false)
    private Long totalAmt;

    @ApiModelProperty(value = "포인트 유형", notes = "A: accumulate / U: use")
    @Column(nullable = false, columnDefinition = "char(1)")
    private String type;

    @ApiModelProperty(value = "포인트 적립 or 사용 내용")
    @Column(nullable = false, length = 200)
    private String content;

    @ApiModelProperty(value = "포인트 생성일자")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false)
    private Date createdDate;
}
