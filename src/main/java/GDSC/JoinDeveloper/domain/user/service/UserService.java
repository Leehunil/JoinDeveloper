package GDSC.JoinDeveloper.domain.user.service;

import GDSC.JoinDeveloper.domain.user.dto.request.CreateUserDto;
import GDSC.JoinDeveloper.domain.user.dto.request.LoginDto;
import GDSC.JoinDeveloper.domain.user.dto.response.ShowUserInfoDto;
import GDSC.JoinDeveloper.domain.user.entity.User;
import GDSC.JoinDeveloper.domain.user.exception.NotFoundUserException;
import GDSC.JoinDeveloper.domain.user.exception.NotMatchPasswordException;
import GDSC.JoinDeveloper.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
    public Long login(LoginDto loginDto){
        User user = findUser(loginDto.getEmail());
        log.info("user.getPassword() : {}",user.getPassword());
        log.info("loginDto.getPassword() : {}",loginDto.getPassword());
        String password = matchPassword(user.getPassword(), loginDto.getPassword());
        return user.getId();
    }


    //내정보 보여주기
    public ShowUserInfoDto showUserInfo(Long userId){
        User user = userRepository.findById(userId).get();
        return new ShowUserInfoDto(user);
    }

    //해당 유저가 있는지
    public User findUser(String email){
        if (userRepository.findByEmail(email) == null){
            throw NotFoundUserException.EXCEPTION;
        }
        else{
            return userRepository.findByEmail(email);
        }
    }

    //유저의 비밀번호가 일치하는지
    public String matchPassword(String dBPassword, String password){
        if (dBPassword.equals(password)){
            return password;
        } else{
            throw NotMatchPasswordException.EXCEPTION;
        }
    }



}
