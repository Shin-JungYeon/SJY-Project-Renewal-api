package sjy.jaengsplay.api.portal.board.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.board.domain.FreeBoard;
import sjy.jaengsplay.api.portal.board.service.FreeService;
import sjy.jaengsplay.api.portal.board.vo.FreeBoardVo;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class FreeController {

    @Autowired
    private FreeService freeService;

    @ApiOperation(value = "자유 게시글 목록 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지", dataType = "int", paramType = "param"),
            @ApiImplicitParam(name = "size", value = "사이즈", dataType = "int", paramType = "param"),
            @ApiImplicitParam(name = "searchText", value = "검색 내용", dataType = "String", paramType = "param")
    })
    @GetMapping(value = "/freeboards")
    public Page<FreeBoard> listFree(@RequestParam int page,
                                    @RequestParam int size,
                                    @RequestParam String searchText) {
        return freeService.listFree(page, size, searchText);
    }

    @ApiOperation(value = "자유 게시글 상세 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "자유 게시글 id", dataType = "Long", paramType = "path")
    })
    @GetMapping(value = "/freeboards/{id}")
    public FreeBoard getFree(@PathVariable Long id) {
        return freeService.getFree(id);
    }

    @ApiOperation(value = "자유 게시글 등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "freeBoardVo", value = "자유 게시글 vo", dataType = "FreeBoardVo", paramType = "body")
    })
    @PostMapping(value = "/freeboards")
    public void insertFree(@RequestBody FreeBoardVo freeBoardVo) {
        freeService.insertFree(freeBoardVo);
    }
}
