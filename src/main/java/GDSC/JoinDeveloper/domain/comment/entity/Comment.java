package GDSC.JoinDeveloper.domain.comment.entity;

import GDSC.JoinDeveloper.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private String letter;
    private LocalDateTime writeTime;

    @Builder
    public Comment(String letter, LocalDateTime writeTime){
        this.letter = letter;
        this.writeTime = writeTime;
    }
}
