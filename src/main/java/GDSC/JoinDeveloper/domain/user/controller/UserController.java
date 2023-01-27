package GDSC.JoinDeveloper.domain.user.controller;

import GDSC.JoinDeveloper.domain.user.dto.request.CreateUserDto;
import GDSC.JoinDeveloper.domain.user.dto.request.LoginDto;
import GDSC.JoinDeveloper.domain.user.dto.response.ShowUserInfoDto;
import GDSC.JoinDeveloper.domain.user.service.UserService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody CreateUserDto createUserDto){
        Long userId = userService.signUp(createUserDto);

        return userId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료!", userId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto){
        Long userId = userService.login(loginDto);

        return userId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 완료!", userId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }

    //내정보 보여주기
    @GetMapping("/{userId}/show-info")
    public ResponseEntity showMyInfo(@PathVariable Long userId){

        ShowUserInfoDto result = userService.showUserInfo(userId);

        return result != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "내정보 조회 완료!", result), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
