package GDSC.JoinDeveloper.domain.participation.exception;

import GDSC.JoinDeveloper.global.error.ErrorCode;
import GDSC.JoinDeveloper.global.error.JDException;

public class OvercapacityException extends JDException {

    public static final JDException EXCEPTION = new OvercapacityException();


    public OvercapacityException() {
        super(ErrorCode.OVERCAPACITY_NOT_ALLOWED);
    }
}
