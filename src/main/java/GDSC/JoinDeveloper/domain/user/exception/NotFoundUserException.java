package GDSC.JoinDeveloper.domain.user.exception;

import GDSC.JoinDeveloper.global.error.ErrorCode;
import GDSC.JoinDeveloper.global.error.JDException;

public class NotFoundUserException extends JDException {

    public static final JDException EXCEPTION = new NotFoundUserException();
    public NotFoundUserException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
