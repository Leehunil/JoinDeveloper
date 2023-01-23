package GDSC.JoinDeveloper.domain.user.dto.response;

import GDSC.JoinDeveloper.domain.user.entity.User;
import lombok.Getter;

@Getter
public class ShowUserInfoDto {

    private String email;
    private String name;

    public ShowUserInfoDto(User user){
        this.email = user.getEmail();
        this.name = user.getName();
    }
}
