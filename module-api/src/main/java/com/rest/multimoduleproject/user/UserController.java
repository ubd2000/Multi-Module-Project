package com.rest.multimoduleproject.user;


import com.rest.multimoduleproject.user.dto.UserDto;
import com.rest.multimoduleproject.user.entity.User;
import com.rest.multimoduleproject.user.repository.UserRepository;
import com.rest.multimoduleproject.user.service.UserService;
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

    @ApiOperation(value = "회원 리스트 조회", notes = "모든 회원을 조회한다.")
    @GetMapping(value = "/users")
    public List<UserDto> findAllUser() {
        return null;
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