package com.rest.multimoduleproject.domain.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {

        private String uid;
        private String password;
        private String name;

        @Builder
        public Request(String uid, String password, String name) {
            this.uid = uid;
            this.password = password;
            this.name = name;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long id;
        private String uid;
        private String password;
        private String name;

        @Builder
        public Response(Long id, String uid, String password, String name) {
            this.id = id;
            this.uid = uid;
            this.password = password;
            this.name = name;
        }
    }

}