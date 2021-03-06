package com.rest.multimoduleproject.domain.user.service;

import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import com.rest.multimoduleproject.domain.user.mapper.UserMapper;
import com.rest.multimoduleproject.domain.user.repository.UserRepository;
import com.rest.multimoduleproject.exception.CUserSigninFailedException;
import com.rest.multimoduleproject.exception.CUserNotFoundException;
import com.rest.multimoduleproject.exception.DataIntegrityViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto.Response> findAllUser() {
        List<User> user = userRepository.findAll();
        return UserMapper.instance.toDto(user);
    }

    public void signin(UserDto.Request userDto) {
        User user = userRepository.findByUid(userDto.getUid()).orElseThrow(CUserNotFoundException::new);
        if (!passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new CUserSigninFailedException();
        }
    }

    public UserDto.Response findUserById(String userUid) {
        User user = userRepository.findByUid(userUid).orElseThrow(CUserNotFoundException::new);
        return UserMapper.instance.toDto(user);
    }

    public void save(UserDto.Request userDto) {
        Optional<User> optionalUser = userRepository.findByUid(userDto.getUid());
        optionalUser.ifPresent(user -> {
            throw new DataIntegrityViolationException();
        });
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = UserMapper.instance.toEntity(userDto);
        userRepository.save(user);
    }

    public void modifyUser(UserDto.Request userDto) {
        User user = userRepository.findByUid(userDto.getUid()).orElseThrow(CUserNotFoundException::new);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.modify(userDto);
        userRepository.save(user);
    }

    public User init(Long msrl) {
        long epochTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();

        User.UserBuilder user = User.builder();
        user.uid("dosel2" + epochTime)
                .password("dosel2")
                .name("name123");

        return user.build();
    }
}
