package GDSC.JoinDeveloper.domain.user.exception;

import GDSC.JoinDeveloper.global.error.ErrorCode;
import GDSC.JoinDeveloper.global.error.JDException;

public class NotMatchPasswordException extends JDException{

    public static final JDException EXCEPTION = new NotMatchPasswordException();

    public NotMatchPasswordException() {
        super(ErrorCode.PASSWORD_NOT_FOUND);
    }
}
