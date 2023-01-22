package GDSC.JoinDeveloper.domain.user.service;

import GDSC.JoinDeveloper.domain.user.dto.request.CreateUserDto;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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


    //
}
