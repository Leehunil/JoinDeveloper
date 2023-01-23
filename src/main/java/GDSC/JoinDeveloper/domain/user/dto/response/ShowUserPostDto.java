package GDSC.JoinDeveloper.domain.user.dto.response;

import GDSC.JoinDeveloper.domain.post.dto.response.PostsResponseDto;
import GDSC.JoinDeveloper.domain.user.entity.User;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ShowUserPostDto {

    private List<PostsResponseDto> postsResponseDto;

    public ShowUserPostDto(User user){
        this.postsResponseDto = user.getPosts().stream()
                .map(post -> new PostsResponseDto(post))
                .collect(Collectors.toList());
    }
}
