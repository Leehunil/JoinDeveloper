package GDSC.JoinDeveloper.domain.participation.dto.request;

import lombok.Getter;

@Getter
public class ParticipationDto {

    private Long userId;
    private Long postId;
    private String language;

    public ParticipationDto(Long userId, Long postId, String language){
        this.userId = userId;
        this.postId = postId;
        this.language = language;
    }
}
