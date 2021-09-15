package sjy.jaengsplay.api.portal.notice.sevice.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.portal.notice.domain.Notice;
import sjy.jaengsplay.api.portal.notice.repository.NoticeRepository;
import sjy.jaengsplay.api.portal.notice.sevice.NoticeService;
import sjy.jaengsplay.api.portal.notice.vo.NoticeVo;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
@Slf4j
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;
    
    @Override
    public Page<Notice> listNotice(int page, int size, String searchText) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("created_date").descending());
        return noticeRepository.findAllByTitleContaining(pageable, searchText);
    }

    @Override
    public Notice getNotice(Long id) {
        return noticeRepository.getById(id);
    }

    @Override
    public void insertNotice(NoticeVo noticeVo) {
        Notice notice = new Notice();
        notice.setTitle(noticeVo.getTitle());
        notice.setContent(noticeVo.getContent());
        notice.setCreatedDate(new Date());
        notice.setCreatedUserId(noticeVo.getCreatedUserId());

        noticeRepository.save(notice);
    }

    @Override
    public void updateNotice(NoticeVo noticeVo) {
        Notice notice = noticeRepository.getById(noticeVo.getId());
        if(notice != null) {
            notice.setTitle(noticeVo.getTitle());
            notice.setContent(noticeVo.getContent());
            
            noticeRepository.save(notice);
        }

    }

    @Override
    public void deleteNotice(Long id) {
        Notice notice = noticeRepository.getById(id);
        if(notice != null) {
            noticeRepository.delete(notice);
        }
    }
}
