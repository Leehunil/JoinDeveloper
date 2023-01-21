package GDSC.JoinDeveloper.domain.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private String phoneNum;

    private Part part;
    private String language;

    @Builder
    public User(String email, String password, String name, String phoneNum, Part part, String language){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.part = part;
        this.language = language;
    }
}
