package GDSC.JoinDeveloper.domain.participation.dto.response;

import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import GDSC.JoinDeveloper.domain.user.entity.Part;
import lombok.Getter;

@Getter
public class ShowPostParUserInfoDto {

    private String name;
    private String phoneNum;
    private Part part;

    public ShowPostParUserInfoDto(Participation participation) {
        this.name = participation.getUser().getName();
        this.phoneNum = participation.getUser().getPhoneNum();
        this.part = participation.getUser().getPart();
    }
}
