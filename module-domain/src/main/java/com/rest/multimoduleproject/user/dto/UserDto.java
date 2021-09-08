package com.rest.multimoduleproject.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    }

}
