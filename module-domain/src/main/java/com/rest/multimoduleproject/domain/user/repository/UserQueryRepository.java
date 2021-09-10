package com.rest.multimoduleproject.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.rest.multimoduleproject.domain.user.entity.QUser.user;

@RequiredArgsConstructor
@Repository
public class UserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<User> findUserById(Long userId) {
        return jpaQueryFactory.selectFrom(user).where(user.msrl.eq(userId)).fetch();
    }
}
