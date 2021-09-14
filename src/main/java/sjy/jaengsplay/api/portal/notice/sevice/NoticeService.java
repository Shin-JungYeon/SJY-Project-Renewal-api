package sjy.jaengsplay.api.portal.notice.sevice;

import org.springframework.data.domain.Page;
import sjy.jaengsplay.api.portal.notice.domain.Notice;
import sjy.jaengsplay.api.portal.notice.vo.NoticeVo;

public interface NoticeService {

    Page<Notice> listNotice(int page, int size, String searchText);

    Notice getNotice(Long id);

    void insertNotice(NoticeVo noticeVo);

    void updateNotice(NoticeVo noticeVo);

    void deleteNotice(Long id);
}
