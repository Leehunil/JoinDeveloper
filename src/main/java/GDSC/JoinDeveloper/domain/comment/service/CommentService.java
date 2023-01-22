package GDSC.JoinDeveloper.domain.comment.service;

import GDSC.JoinDeveloper.domain.comment.dto.request.CreateCommentDto;
import GDSC.JoinDeveloper.domain.comment.dto.request.UpdateCommentDto;
import GDSC.JoinDeveloper.domain.comment.dto.response.CommentDetailResponseDto;
import GDSC.JoinDeveloper.domain.comment.entity.Comment;
import GDSC.JoinDeveloper.domain.comment.repository.CommentRepository;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import GDSC.JoinDeveloper.domain.post.repository.PostRepository;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //댓글 저장
    @Transactional
    public Long save(CreateCommentDto createCommentDto){
        User findUser = userRepository.findById(createCommentDto.getUserId()).get();
        Post findPost = postRepository.findById(createCommentDto.getPostId()).get();

        Long commentId = commentRepository.save(Comment.builder()
                .post(findPost)
                .user(findUser)
                .letter(createCommentDto.getLetter())
                .writeTime(LocalDateTime.now())
                .build()
        ).getId();
        //Post에 comment 추가
        findPost.addComment(commentRepository.findById(commentId).get());

        return commentId;
    }

    //댓글 보여주기
    public CommentDetailResponseDto showComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).get();
        CommentDetailResponseDto commentDetailResponseDto = new CommentDetailResponseDto(comment);
        return commentDetailResponseDto;
    }

    //댓글 수정
    @Transactional
    public Long updateComment(UpdateCommentDto updateCommentDto){
        Comment comment = commentRepository.findById(updateCommentDto.getCommentId()).get();
        Long id = comment.changeComment(updateCommentDto.getLetter());
        return id;
    }

    //댓글 삭제
    @Transactional
    public boolean deleteComment(Long commentId){
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
        boolean exists = commentRepository.existsById(commentId);
        return exists;
    }
}
