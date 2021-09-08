package com.rest.multimoduleproject.user;

import com.rest.multimoduleproject.user.dto.UserDto;
import com.rest.multimoduleproject.user.entity.User;
import com.rest.multimoduleproject.user.repository.UserRepository;
import com.rest.multimoduleproject.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserRepository userRepository;
    private final UserService userService;

//    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
//    @PostMapping(value = "/signin")
//    public String signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
//                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {
//        User user = boardRepository.findByUid(id).orElseThrow(RuntimeException::new);
//        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getMsrl()), user.getRoles()));
//    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public User signUp(UserDto userDto) {

        return null;
    }
}
