package sjy.jaengsplay.api.portal.notice.vo;

import lombok.Data;

@Data
public class NoticeVo {
    private Long id;
    private String title;
    private String content;
    private String createdUserId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedUserId() {
        return this.createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

}
