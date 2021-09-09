package com.rest.multimoduleproject.domain.user;


import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.repository.UserRepository;
import com.rest.multimoduleproject.domain.user.service.UserService;
import com.rest.multimoduleproject.exception.CUserNotFoundException;
import com.rest.multimoduleproject.response.CommonResult;
import com.rest.multimoduleproject.response.ListResult;
import com.rest.multimoduleproject.response.SingleResult;
import com.rest.multimoduleproject.response.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"2. User"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final ResponseService responseService;

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/users")
    public ListResult<UserDto> findAllUser() {
        return responseService.getListResult(userService.findAllUser());
    }

    @ApiOperation(value = "회원 단건 조회", notes = "회원을 조회한다.")
    @GetMapping(value = "/user/{userId}")
    public SingleResult<UserDto> findUserById(@PathVariable Long userId) throws CUserNotFoundException {
        return responseService.getSingleResult(userService.findUserById(userId));
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다.")
    @PutMapping(value = "/user")
    public User modifyUser(UserDto userDto) {
        return null;
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다.")
    @DeleteMapping(value = "/user/{uid}")
    public User deleteUser(@ApiParam(value = "회원아이디", required = true) @PathVariable String uid) {
        return null;
    }

    @GetMapping("/pageUsers")
    public Page<User> findAllUserPage(Pageable pageable) {
        return null;
    }
}