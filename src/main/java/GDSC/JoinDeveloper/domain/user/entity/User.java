package GDSC.JoinDeveloper.domain.user.entity;

import GDSC.JoinDeveloper.domain.post.entity.Post;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    private String email;
    private String password;
    private String name;
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private Part part;
    private String language;

    @Builder
    public User(String email, String password, String name, String phoneNum, Part part){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNum = phoneNum;
        this.part = part;
    }

    //비즈니스 로직

    //언어 설정
    public void selectLanguage(String language){
        this.language = language;
    }

    //내가 만든 게시물 추가 로직
    public void addPost(Post post){
        this.posts.add(post);
    }
}
