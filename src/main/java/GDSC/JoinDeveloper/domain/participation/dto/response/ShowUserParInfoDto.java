package GDSC.JoinDeveloper.domain.participation.dto.response;

import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import lombok.Getter;

@Getter
public class ShowUserParInfoDto {

    private String name;
    private String title;

    public ShowUserParInfoDto(Participation participation){
        this.name = participation.getUser().getName();
        this.title = participation.getPost().getTitle();
    }
}
