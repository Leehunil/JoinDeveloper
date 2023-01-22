package GDSC.JoinDeveloper.domain.post.dto.request;

import lombok.Getter;

@Getter
public class PostUpdateRequestDto {

    private Long id;
    private String title;
    private String contents;
    private Integer recruitmentNum;

    public PostUpdateRequestDto(String title, String contents, Integer recruitmentNum){
        this.title = title;
        this.contents = contents;
        this.recruitmentNum = recruitmentNum;
    }
}
