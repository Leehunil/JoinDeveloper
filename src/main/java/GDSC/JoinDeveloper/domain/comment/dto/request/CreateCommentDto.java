package GDSC.JoinDeveloper.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class CreateCommentDto {

    private Long postId;
    private Long userId;
    private String letter;

    public CreateCommentDto(Long postId, Long userId, String name, String letter){
        this.postId = postId;
        this.userId = userId;
        this.letter = letter;
    }
}
