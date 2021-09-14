package sjy.jaengsplay.api.portal.notice.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sjy.jaengsplay.api.portal.notice.domain.Notice;
import sjy.jaengsplay.api.portal.notice.sevice.NoticeService;
import sjy.jaengsplay.api.portal.notice.vo.NoticeVo;

@RestController
@RequestMapping(value = "/api/v1/portal")
@Slf4j
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "공지사항 목록")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "페이지", dataType = "int", paramType = "param"),
        @ApiImplicitParam(name = "size", value = "사이즈", dataType = "int", paramType = "param"),
        @ApiImplicitParam(name = "searchText", value = "검색 내용", dataType = "String", paramType = "param")
    })
    @GetMapping(value = "/notices")
    public Page<Notice> listNotice(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(required = false, defaultValue = "") String searchText) {
        return noticeService.listNotice(page, size, searchText);
    }

    @ApiOperation(value = "공지사항 상세")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "공지사항 아이디", dataType = "Long", paramType = "path")
    })
    @GetMapping(value = "/notices/{id}")
    public Notice getNotice(@PathVariable Long id) {
        return noticeService.getNotice(id);
    }

    @ApiOperation(value = "공지사항 등록")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "noticeVo", value = "공지사항 vo", dataType = "NoticeVo", paramType = "body")
    })
    @PostMapping(value = "/notices")
    public void insertNotice(@RequestBody NoticeVo noticeVo) {
        noticeService.insertNotice(noticeVo);
    }

    @ApiOperation(value = "공지사항 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeVo", value = "공지사항 vo", dataType = "NoticeVo", paramType = "body")
    })
    @PutMapping(value = "/notices")
    public void updateNotice(@RequestBody NoticeVo noticeVo) {
        noticeService.updateNotice(noticeVo);
    }
    
    @ApiOperation(value = "공지사항 삭제")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "공지사항 아이디", dataType = "Long", paramType = "path")
    })
    @DeleteMapping(value = "/notices/{id}")
    public void deleteNotice(@PathVariable Long id) {
        noticeService.deleteNotice(id);
    }
    
}
