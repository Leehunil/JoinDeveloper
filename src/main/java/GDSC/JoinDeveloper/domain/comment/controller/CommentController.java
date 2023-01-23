package GDSC.JoinDeveloper.domain.comment.controller;

import GDSC.JoinDeveloper.domain.comment.dto.request.CreateCommentDto;
import GDSC.JoinDeveloper.domain.comment.service.CommentService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    //댓글 저장
    @PostMapping("/save")
    public ResponseEntity saveComment(@RequestBody CreateCommentDto createCommentDto){
        Long commentId = commentService.save(createCommentDto);

        return commentId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "장소 정보 조회 완료", commentId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
