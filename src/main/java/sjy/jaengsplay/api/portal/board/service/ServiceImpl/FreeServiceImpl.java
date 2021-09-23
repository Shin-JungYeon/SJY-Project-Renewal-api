package sjy.jaengsplay.api.portal.board.service.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sjy.jaengsplay.api.portal.board.domain.FreeBoard;
import sjy.jaengsplay.api.portal.board.repository.FreeRepository;
import sjy.jaengsplay.api.portal.board.service.FreeService;
import sjy.jaengsplay.api.portal.board.vo.FreeBoardVo;

import javax.transaction.Transactional;
import java.util.Date;


@Service
@Transactional
@Slf4j
public class FreeServiceImpl implements FreeService {

    @Autowired
    private FreeRepository freeRepository;

    @Override
    public Page<FreeBoard> listFree(int page, int size, String searchText) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("created_date").descending());
        return freeRepository.findAllByTitleContaining(pageable, searchText);
    }

    @Override
    public FreeBoard getFree(Long id) {
        return freeRepository.getById(id);
    }

    @Override
    public void insertFree(FreeBoardVo freeBoardVo) {
        FreeBoard freeBoard = new FreeBoard();

        freeBoard.setTitle(freeBoardVo.getTitle());
        freeBoard.setContent(freeBoardVo.getContent());
        freeBoard.setCreatedDate(new Date());
        freeBoard.setCreatedUserId("login id");
        freeBoard.setLikeCnt(0L);
        freeBoard.setViewCnt(0L);

        freeRepository.save(freeBoard);
    }
}
