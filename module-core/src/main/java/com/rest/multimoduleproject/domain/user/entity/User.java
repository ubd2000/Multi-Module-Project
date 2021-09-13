package com.rest.multimoduleproject.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity // jpa entity임을 알립니다.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 무분별한 생성자 생성 방지
@Table(name = "user") // 'user' 테이블과 매핑됨을 명시
public class User {

    @Id // primaryKey임을 알립니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  pk생성전략을 DB에 위임한다는 의미입니다. mysql로 보면 pk 필드를 auto_increment로 설정해 놓은 경우로 보면 됩니다.
    private Long id;

    @Column(nullable = false, unique = true, length = 100) // uid column을 명시합니다. 필수이고 유니크한 필드이며 길이는 30입니다.
    private String uid;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 100) // name column을 명시합니다. 필수이고 길이는 100입니다.
    private String name;

    @Builder
    public User(Long id, String uid, String password, String name) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.name = name;
    }
}