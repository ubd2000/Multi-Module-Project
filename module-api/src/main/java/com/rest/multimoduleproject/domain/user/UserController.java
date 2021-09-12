package com.rest.multimoduleproject.domain.user;


import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.service.UserService;
import com.rest.multimoduleproject.response.CommonResult;
import com.rest.multimoduleproject.response.ListResult;
import com.rest.multimoduleproject.response.SingleResult;
import com.rest.multimoduleproject.response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    private final UserService userService;
    private final ResponseService responseService;

    /**
     * 전체 회원 조회
     *
     * @return
     */
    @GetMapping(value = "/users")
    public ListResult<UserDto.Response> findAllUser() {
        return responseService.getListResult(userService.findAllUser());
    }

    /**
     * 회원 조회
     *
     * @param userUid
     * @return
     */
    @GetMapping(value = "/user/{userUid}")
    public SingleResult<UserDto.Response> findUserById(@PathVariable String userUid) {
        return responseService.getSingleResult(userService.findUserById(userUid));
    }

    @PutMapping(value = "/user")
    public CommonResult modifyUser(UserDto.Request userDto) {

        return responseService.getSuccessResult();
    }

    @DeleteMapping(value = "/user/{uid}")
    public User deleteUser(@PathVariable String uid) {
        return null;
    }

    @GetMapping("/pageUsers")
    public Page<User> findAllUserPage(Pageable pageable) {
        return null;
    }
}