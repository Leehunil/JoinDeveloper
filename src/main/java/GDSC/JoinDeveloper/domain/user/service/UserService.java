package GDSC.JoinDeveloper.domain.user.service;

import GDSC.JoinDeveloper.domain.user.dto.request.CreateUserDto;
import GDSC.JoinDeveloper.domain.user.dto.response.ShowUserInfoDto;
import GDSC.JoinDeveloper.domain.user.dto.response.ShowUserPostDto;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    @Transactional
    public Long signUp(CreateUserDto createUserDto){
        return userRepository.save(User.builder()
                .email(createUserDto.getEmail())
                .password(createUserDto.getPassword())
                .name(createUserDto.getName())
                .phoneNum(createUserDto.getPhoneNum())
                .part(createUserDto.getPart()).build()).getId();
    }

    //로그인


    //내정보 보여주기
    public ShowUserInfoDto showUserInfo(Long userId){
        User user = userRepository.findById(userId).get();
        return new ShowUserInfoDto(user);
    }

    //내정보 내가 만든 게시물 목록 보여주기
    public ShowUserPostDto showUserPost(Long userId){
        User user = userRepository.findById(userId).get();
        return new ShowUserPostDto(user);
    }
}
