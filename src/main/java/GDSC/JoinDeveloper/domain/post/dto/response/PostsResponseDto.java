package GDSC.JoinDeveloper.domain.post.dto.response;

import GDSC.JoinDeveloper.domain.post.entity.PersonnelStatus;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private String title;
    private Integer recruitmentNum;
    private Integer currentNum;

    private String name;

    public PostsResponseDto(Post post) {
        this.title = post.getTitle();
        this.recruitmentNum = post.getRecruitmentNum();
        this.currentNum = post.getCurrentNum();
        this.name = post.getUser().getName();
    }
}
