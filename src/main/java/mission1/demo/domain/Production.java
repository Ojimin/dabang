package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Production {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    private int num; //과정번호

    @Column(length = 1000)
    private String img_url;

    @Column(length = 5000)
    private String content; //설명

}
