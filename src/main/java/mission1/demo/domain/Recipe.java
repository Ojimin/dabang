package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;
import mission1.demo.domain.base.BaseEntity;
import org.hibernate.id.IncrementGenerator;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Recipe extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User user_id;

    private int is_temp; //임시저장인지?

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category; //일대일 매핑

    @Column(nullable = false)
    private String recipe_title;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer like_num;

    private long bookmark_num;

    private float rating;

    @Column(length=50)
    private String take_time;

    private String introduction;

    private String image_url;

}
