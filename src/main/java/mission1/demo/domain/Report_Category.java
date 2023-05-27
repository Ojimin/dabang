package mission1.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)//BUILD 패턴 쓰는 것이 좋음
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Report_Category { //신고 카테고리 - 게시글인지, 댓글인지?

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_category_id")
    private Long id;

    private String name;

}
