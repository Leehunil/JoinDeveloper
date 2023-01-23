package GDSC.JoinDeveloper.domain.post.service;

import GDSC.JoinDeveloper.domain.post.dto.request.CreatePostDto;
import GDSC.JoinDeveloper.domain.post.dto.request.PostUpdateRequestDto;
import GDSC.JoinDeveloper.domain.post.dto.response.PostDetailResponseDto;
import GDSC.JoinDeveloper.domain.post.dto.response.PostsResponseDto;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import GDSC.JoinDeveloper.domain.post.repository.PostRepository;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //게시물 저장
    @Transactional
    public Long create(CreatePostDto createPostDto){
        User findUser = userRepository.findById(createPostDto.getUserId()).get();

        Long postId = postRepository.save(
                Post.builder()
                        .user(findUser)
                        .title(createPostDto.getTitle())
                        .contents(createPostDto.getContents())
                        .postTime(LocalDateTime.now())
                        .recruitmentNum(createPostDto.getRecruitmentNum())
                        .currentNum(1)
                        .build()
        ).getId();
        findUser.addPost(postRepository.findByPostId(postId).get());
        return postId;
    }

    //게시물 목록 보여주기
    public List<PostsResponseDto> showAllPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostsResponseDto> collect = posts.stream()
                .map(post -> new PostsResponseDto(post))
                .collect(Collectors.toList());
        return collect;
    }

    //게시물 세부 사항 보여주기
    public PostDetailResponseDto showPostInfo(Long postId){
        Post post = postRepository.findByPostId(postId).get();
        PostDetailResponseDto postDetailResponseDto = new PostDetailResponseDto(post);
        return postDetailResponseDto;
    }

    //게시물 업데이트
    @Transactional
    public Long update(PostUpdateRequestDto postUpdateRequestDto){
        Post post = postRepository.findById(postUpdateRequestDto.getId()).get();
        Long postId = post.changeInfo(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContents(),
                LocalDateTime.now(), postUpdateRequestDto.getRecruitmentNum());
        return postId;
    }

    //게시물 삭제
    @Transactional
    public boolean delete(Long postId){
        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
        return postRepository.existsById(postId);
    }
}
