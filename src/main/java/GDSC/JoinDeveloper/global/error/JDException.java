package GDSC.JoinDeveloper.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JDException extends RuntimeException{
    ErrorCode errorCode;
}
