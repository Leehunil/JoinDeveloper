package GDSC.JoinDeveloper.domain.participation.service;

import GDSC.JoinDeveloper.domain.participation.dto.request.ParticipationDto;
import GDSC.JoinDeveloper.domain.participation.entity.Participation;
import GDSC.JoinDeveloper.domain.participation.repository.ParticipationRepository;
import GDSC.JoinDeveloper.domain.post.entity.Post;
import GDSC.JoinDeveloper.domain.post.repository.PostRepository;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //참여하기
    @Transactional
    public void saveParticipation(ParticipationDto participationDto){
        User findUser = userRepository.findById(participationDto.getUserId()).get();
        Post findPost = postRepository.findById(participationDto.getPostId()).get();

        participationRepository.save(Participation.builder()
                .user(findUser)
                .post(findPost)
                .build());
        findUser.selectLanguage(participationDto.getLanguage());
        findPost.addCurrentNum();
    }

}
