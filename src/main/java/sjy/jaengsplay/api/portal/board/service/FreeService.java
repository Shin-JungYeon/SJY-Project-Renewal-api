package sjy.jaengsplay.api.portal.board.service;

import org.springframework.data.domain.Page;
import sjy.jaengsplay.api.portal.board.domain.FreeBoard;
import sjy.jaengsplay.api.portal.board.vo.FreeBoardVo;

public interface FreeService {

    Page<FreeBoard> listFree(int page, int size, String searchText);

    FreeBoard getFree(Long id);

    void insertFree(FreeBoardVo freeBoardVo);
}
