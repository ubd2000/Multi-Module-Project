package com.rest.multimoduleproject.user.service;

import com.rest.multimoduleproject.user.entity.User;
import com.rest.multimoduleproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User inliu(Long msrl) {
        long epochTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();

        User.UserBuilder user = User.builder();
        user.uid("dosel2" + epochTime)
                .password("dosel2")
                .name("name123");

        return user.build();
    }
}
