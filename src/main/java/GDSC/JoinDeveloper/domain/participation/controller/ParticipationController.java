package GDSC.JoinDeveloper.domain.participation.controller;

import GDSC.JoinDeveloper.domain.participation.dto.request.ParticipationDto;
import GDSC.JoinDeveloper.domain.participation.service.ParticipationService;
import GDSC.JoinDeveloper.global.response.DefaultRes;
import GDSC.JoinDeveloper.global.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participation")
public class ParticipationController {

    private final ParticipationService participationService;

    @PostMapping("/save")
    public ResponseEntity participationSave(@RequestBody ParticipationDto participationDto){
        Boolean bool = participationService.saveParticipation(participationDto);

        return bool != false ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "참여 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }
}
