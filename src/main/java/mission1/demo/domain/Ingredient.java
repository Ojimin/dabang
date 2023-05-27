package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String name;

    @Column(length = 20)
    private String amount;

    @Column(length = 1000)
    private String img_url;
}
