package GDSC.JoinDeveloper.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class UpdateCommentDto {

    private Long commentId;
    private String letter;

    public UpdateCommentDto(Long commentId, String letter){
        this.commentId = commentId;
        this.letter = letter;
    }
}
