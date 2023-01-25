package GDSC.JoinDeveloper.domain.post.controller;

import GDSC.JoinDeveloper.domain.post.dto.request.CreatePostDto;
import GDSC.JoinDeveloper.domain.post.dto.request.PostUpdateRequestDto;
import GDSC.JoinDeveloper.domain.post.dto.response.PostDetailResponseDto;
import GDSC.JoinDeveloper.domain.post.dto.response.PostsResponseDto;
import GDSC.JoinDeveloper.domain.post.service.PostService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    //게시물 저장
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody CreatePostDto createPostDto){
        Long postId = postService.create(createPostDto);

        return postId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물 저장 완료!", postId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //게시물 목록 보여주기
    @GetMapping
    public ResponseEntity show(){
        List<PostsResponseDto> result = postService.showAllPosts();

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물 목록 응답 완료!", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //게시물 하나 세부사항 보여주기
    @GetMapping("/{postId}/show")
    public ResponseEntity showDetail(@PathVariable Long postId){
        PostDetailResponseDto result = postService.showPostInfo(postId);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물 세부 사항 응답 완료!", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //게시물 수정
    @PostMapping("/update")
    public ResponseEntity updatePost(@RequestBody PostUpdateRequestDto postUpdateRequestDto){

        Long postId = postService.update(postUpdateRequestDto);

        return postId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물 수정 완료!"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/delete")
    public ResponseEntity deletePost(@PathVariable Long postId){

        boolean bool = postService.delete(postId);

        return bool != true ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물 삭제 완료!"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
