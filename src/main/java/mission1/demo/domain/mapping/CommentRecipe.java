package mission1.demo.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import mission1.demo.domain.Comment;
import mission1.demo.domain.Recipe;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRecipe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;
}
