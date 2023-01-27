package GDSC.JoinDeveloper.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    //404 NOT_FOUND: 해당 자원을 찾을 수 없습니다.
    USER_NOT_FOUND(404, "해당 email과 일치하는 회원이 없습니다."),
    PASSWORD_NOT_FOUND(404, "패스워드가 일치 하지 않습니다."),
    DUPLICATE_PARTICIPATION_NOT_FOUND(404,"이미 참여한 방입니다."),

    //405 METHOD NOT ALLOWED : 메소드를 수행하기 위한 해당 자원의 이용이 허용되지 않았을 경우 발생함
    OVERCAPACITY_NOT_ALLOWED(405,"이 게시물의 인원이 꽉 차있습니다.");

    private int status;
    private String reason;
}
