package GDSC.JoinDeveloper.domain.comment.dto.response;

import GDSC.JoinDeveloper.domain.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDetailResponseDto {

    private String name;
    private String letter;
    private LocalDateTime writeTime;

    public CommentDetailResponseDto(Comment comment){
        this.name = comment.getUser().getName();
        this.letter = comment.getLetter();
        this.writeTime = comment.getWriteTime();
    }
}
