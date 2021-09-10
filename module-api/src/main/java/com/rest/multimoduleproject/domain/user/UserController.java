package com.rest.multimoduleproject.domain.user;


import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.service.UserService;
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
     *
     * @return
     */
    @GetMapping(value = "/users")
    public ListResult<UserDto.Response> findAllUser() {
        return responseService.getListResult(userService.findAllUser());
    }

    /**
     * 회원 조회
     * @param userId
     * @return
     */
    @GetMapping(value = "/user/{userId}")
    public SingleResult<UserDto.Response> findUserById(@PathVariable Long userId) {
        return responseService.getSingleResult(userService.findUserById(userId));
    }

    @PutMapping(value = "/user")
    public User modifyUser(UserDto userDto) {
        return null;
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