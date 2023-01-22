package GDSC.JoinDeveloper.domain.post.dto.request;

import lombok.Getter;

@Getter
public class CreatePostDto {

    private Long userId;
    private String title;
    private String contents;
    private Integer recruitmentNum;

    public CreatePostDto(Long userId, String title, String contents, Integer recruitmentNum){
        this.userId = userId;
        this.title = title;
        this.contents = contents;
        this.recruitmentNum = recruitmentNum;
    }
}
