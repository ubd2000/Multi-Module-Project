package com.rest.multimoduleproject.domain.user;

import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.repository.UserRepository;
import com.rest.multimoduleproject.domain.user.service.UserService;
import com.rest.multimoduleproject.response.CommonResult;
import com.rest.multimoduleproject.response.SingleResult;
import com.rest.multimoduleproject.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final ResponseService responseService;

    @PostMapping(value = "/signin")
    public CommonResult signin(UserDto.Request userDto) {
        userService.signin(userDto);
        return responseService.getSuccessResult();
    }

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
