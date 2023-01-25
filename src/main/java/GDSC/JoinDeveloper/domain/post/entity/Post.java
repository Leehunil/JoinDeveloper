package GDSC.JoinDeveloper.domain.post.entity;

import GDSC.JoinDeveloper.domain.comment.entity.Comment;
import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import GDSC.JoinDeveloper.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments =  new ArrayList<>();

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Participation> participations = new ArrayList<>();

    private String title;
    private String contents;
    private LocalDateTime postTime;
    private Integer recruitmentNum;
    private Integer currentNum;
    private PersonnelStatus personnelStatus;

    @Builder
    public Post(User user, String title, String contents, LocalDateTime postTime, Integer recruitmentNum, Integer currentNum, PersonnelStatus personnelStatus){
        this.user = user;
        this.title = title;
        this.contents = contents;
        this.postTime = postTime;
        this.recruitmentNum = recruitmentNum;
        this.currentNum = currentNum;
        this.personnelStatus = personnelStatus;
    }

    //비즈니스 로직

    //업데이트
    public Long changeInfo(String title, String contents, LocalDateTime postTime, Integer recruitmentNum){
        this.title = title;
        this.contents = contents;
        this.postTime = postTime;
        this.recruitmentNum = recruitmentNum;
        return this.getId();
    }

    //comments 추가 로직
    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    //현재원 추가 로직
    public void addCurrentNum(){
        this.currentNum+=1;
    }

}
