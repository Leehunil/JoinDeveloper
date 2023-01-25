package GDSC.JoinDeveloper.domain.participation.controller;

import GDSC.JoinDeveloper.domain.comment.repository.CommentRepository;
import GDSC.JoinDeveloper.domain.participation.dto.request.ParticipationDto;
import GDSC.JoinDeveloper.domain.participation.dto.response.ShowPostParUserInfoDto;
import GDSC.JoinDeveloper.domain.participation.dto.response.ShowUserParInfoDto;
import GDSC.JoinDeveloper.domain.participation.service.ParticipationService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participation")
public class ParticipationController {

    private final ParticipationService participationService;
    private final CommentRepository commentRepository;

    @PostMapping("/save")
    public ResponseEntity participationSave(@RequestBody ParticipationDto participationDto){
        Boolean bool = participationService.saveParticipation(participationDto);

        return bool != false ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "참여 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    @GetMapping("/{userId}/post-info")
    public ResponseEntity ShowUserPar(@PathVariable Long userId){
        List<ShowUserParInfoDto> result = participationService.showUserParInfo(userId);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "사용자 참여한 목록 완료!!", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    @GetMapping("/{postId}/user-info")
    public ResponseEntity showParUserInfo(@PathVariable Long postId){
        List<ShowPostParUserInfoDto> collect = participationService.showPostParUserInfo(postId);

        return collect != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "게시물에 참여한 유저 정보 조회 완료!!", collect), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
