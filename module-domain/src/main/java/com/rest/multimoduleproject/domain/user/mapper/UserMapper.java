package com.rest.multimoduleproject.domain.user.mapper;


import com.rest.multimoduleproject.domain.user.dto.UserDto;
import com.rest.multimoduleproject.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * Mapstruct 사용 시 DTO 와 Entity 맵핑정보가 모두 동일해야 됨.
 * 만약 동일하지 않으면 @Mapping 사용해여 해결
 * Mapstruct 핵심 장점
 * 1. 객체 필드의 변경 사항이 다른 로직에 영향을 주지 않는다.
 * 2. 컴파일 시점에 코드를 생성하기에 코드의 문제가 있는 경우 컴파일 에러가 발생시키기에 상대적으로 안전하게 사용할 수 있다.
 * 3. 리플렉션을 사용하지 않고 메서드 호출을 사용해서 빠른 실행
 * */
@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDto.Response> toDto(List<User> user);
    UserDto.Response toDto(User user);
    User toEntity(UserDto.Request userDto);

    UserMapper instance = Mappers.getMapper(UserMapper.class);
}
