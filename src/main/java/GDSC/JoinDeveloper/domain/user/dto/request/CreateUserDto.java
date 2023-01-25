package GDSC.JoinDeveloper.domain.user.dto.request;

import GDSC.JoinDeveloper.domain.user.entity.Part;
import lombok.Getter;

@Getter
public class CreateUserDto {

    private String email;
    private String password;
    private String name;
    private String phoneNum;
    private Part part;

    public CreateUserDto(String email, String password, String name, String phoneNum, Part part){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.part = part;
    }

    public CreateUserDto() {
    }
}
