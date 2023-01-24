package GDSC.JoinDeveloper.domain.comment.controller;

import GDSC.JoinDeveloper.domain.comment.dto.request.CreateCommentDto;
import GDSC.JoinDeveloper.domain.comment.dto.request.UpdateCommentDto;
import GDSC.JoinDeveloper.domain.comment.service.CommentService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "댓글 저장 완료", commentId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //댓글 수정
    @PostMapping("/update")
    public ResponseEntity showComment(@RequestBody UpdateCommentDto updateCommentDto){
        Long commentId = commentService.updateComment(updateCommentDto);

        return commentId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "댓글 수정 완료", commentId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //댓글 삭제
    @DeleteMapping("/delete")
    public ResponseEntity deleteComment(@RequestParam Long commentId){
        boolean bool = commentService.deleteComment(commentId);

        return bool != true ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "댓글 삭제 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
