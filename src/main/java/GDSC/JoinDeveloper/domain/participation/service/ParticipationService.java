package GDSC.JoinDeveloper.domain.participation.service;

import GDSC.JoinDeveloper.domain.participation.dto.request.ParticipationDto;
import GDSC.JoinDeveloper.domain.participation.dto.response.ShowPostParUserInfoDto;
import GDSC.JoinDeveloper.domain.participation.dto.response.ShowUserParInfoDto;
import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import GDSC.JoinDeveloper.domain.participation.repository.ParticipationRepository;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import GDSC.JoinDeveloper.domain.post.repository.PostRepository;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //참여 하기
    @Transactional
    public Boolean saveParticipation(ParticipationDto participationDto){
        User findUser = userRepository.findById(participationDto.getUserId()).get();
        Post findPost = postRepository.findById(participationDto.getPostId()).get();

        Participation participation = participationRepository.save(Participation.builder()
                .user(findUser)
                .post(findPost)
                .build());
        findUser.selectLanguage(participationDto.getLanguage());
        findPost.addCurrentNum();
        return participationRepository.existsById(participation.getId());
    }

    //사용자 참여한 게시물들 보여주기
    public List<ShowUserParInfoDto> showUserParInfo(Long userId){
        List<Participation> participations = participationRepository.findByUserId(userId);
        return participations.stream()
                .map(participation -> new ShowUserParInfoDto(participation))
                .collect(Collectors.toList());
    }

    //방에 참여한 인원들 보여주기
    public List<ShowPostParUserInfoDto> showPostParUserInfo(Long postId){
        List<Participation> participations = participationRepository.findByPostId(postId);
        return participations.stream()
                .map(participation -> new ShowPostParUserInfoDto(participation))
                .collect(Collectors.toList());
    }

}
