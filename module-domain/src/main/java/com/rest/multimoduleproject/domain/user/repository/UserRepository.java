package com.rest.multimoduleproject.domain.user.repository;

import com.rest.multimoduleproject.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Delete의 경우 Transactional 걸어줘야 정상작동 함
    @Transactional
    User deleteByUid(String email);
}