package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Blocked_User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blocked_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "target_user_id")
    private User target_user; //신고대상 유저
}
