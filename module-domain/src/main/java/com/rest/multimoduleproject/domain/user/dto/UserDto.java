package com.rest.multimoduleproject.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserDto {

    private Long msrl;
    private String uid;
    private String password;
    private String name;

    @Getter
    @Setter
    public static class Request {
        private String uid;
        private String password;
        private String name;
    }

    @Getter
    @Setter
    public static class Response {
        private String uid;
        private String password;
        private String name;
    }

}
