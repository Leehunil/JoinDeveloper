package GDSC.JoinDeveloper.domain.participation.exception;

import GDSC.JoinDeveloper.global.error.ErrorCode;
import GDSC.JoinDeveloper.global.error.JDException;

public class DuplicateParticipationException extends JDException {

    public static final JDException EXCEPTION = new DuplicateParticipationException();


    public DuplicateParticipationException() {
        super(ErrorCode.DUPLICATE_PARTICIPATION_NOT_FOUND);
    }
}
