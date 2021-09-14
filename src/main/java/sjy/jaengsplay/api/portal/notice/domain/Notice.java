package sjy.jaengsplay.api.portal.notice.domain;

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
@Entity(name = "notice_tb")
public class Notice {
    @ApiModelProperty(value = "공지사항 아이디")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ApiModelProperty(value = "공지사항 제목")
    @Column(nullable = false, length = 200)
    private String title;

    @ApiModelProperty(value = "공지사항 내용")
    @Column(nullable = false, length = 2000)
    private String content;

    @ApiModelProperty(value = "공지사항 생성자 아이디")
    @Column(nullable = false, length = 40)
    private String createdUserId;

    @ApiModelProperty(value = "공지사항 생성일자")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false)
    private Date createdDate;
}
