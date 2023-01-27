package GDSC.JoinDeveloper.domain.comment.entity;

import GDSC.JoinDeveloper.domain.post.entity.Post;
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
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String letter;
    private LocalDateTime writeTime;

    @Builder
    public Comment(Post post, User user, String letter, LocalDateTime writeTime){
        this.post = post;
        this.user = user;
        this.letter = letter;
        this.writeTime = writeTime;
    }

    //비즈니스 로직

    //댓글 변경
    public Long changeComment(String letter){
        this.letter = letter;
        return this.getId();
    }


}
