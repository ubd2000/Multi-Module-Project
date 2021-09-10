package com.rest.multimoduleproject.domain.user;

import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.repository.UserRepository;
import com.rest.multimoduleproject.domain.user.service.UserService;
import com.rest.multimoduleproject.response.CommonResult;
import com.rest.multimoduleproject.response.SingleResult;
import com.rest.multimoduleproject.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final ResponseService responseService;

//    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
//    @PostMapping(value = "/signin")
//    public String signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
//                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {
//        User user = boardRepository.findByUid(id).orElseThrow(RuntimeException::new);
//        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getMsrl()), user.getRoles()));
//    }

    /**
     *
     * @param userDto
     * @return
     */
    @PostMapping(value = "/signup")
    public CommonResult signUp(@RequestBody UserDto.Request userDto) {
        userService.save(userDto);
        return responseService.getSuccessResult();
    }
}
