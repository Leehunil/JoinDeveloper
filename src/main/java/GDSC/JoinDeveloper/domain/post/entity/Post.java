package GDSC.JoinDeveloper.domain.post.entity;

import GDSC.JoinDeveloper.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String contents;
    private LocalDateTime postTime;
    private Integer recruitmentNum;
    private Integer currentNum;

    @Builder
    public Post(String title, String contents, LocalDateTime postTime, int recruitmentNum, int currentNum){
        this.title = title;
        this.contents = contents;
        this.postTime = postTime;
        this.recruitmentNum = recruitmentNum;
        this.currentNum = currentNum;
    }



}
