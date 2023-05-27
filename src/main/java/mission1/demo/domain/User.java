package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import mission1.demo.domain.base.BaseEntity;
import mission1.demo.domain.common.UserStatus;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private int is_admin; //관리자인지 아닌지 체크

    private String name; //사용자닉네임

    private String username; //사용자 이름

    @Column(unique = true, nullable = false)
    private String email;//겹치면 안되니까 unique

    @Column(unique = true, nullable = false)
    private String phone_num;

    private int birthday;

    private int gender;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

}
