package GDSC.JoinDeveloper.domain.post.dto.response;

import GDSC.JoinDeveloper.domain.comment.dto.response.CommentDetailResponseDto;
import GDSC.JoinDeveloper.domain.post.entity.PersonnelStatus;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostDetailResponseDto {

    private String title;
    private String contents;
    private Integer recruitmentNum;
    private Integer currentNum;

    private String name;

    private List<CommentDetailResponseDto> comments ;

    public PostDetailResponseDto(Post post){
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.recruitmentNum = post.getRecruitmentNum();
        this.currentNum = post.getCurrentNum();
        this.name = post.getUser().getName();
        this.comments = post.getComments().stream()
                .map(comment -> new CommentDetailResponseDto(comment))
                .collect(Collectors.toList());
    }
}
