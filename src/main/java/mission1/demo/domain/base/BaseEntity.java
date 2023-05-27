package mission1.demo.domain.base;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass //이게 있어야 자식클래스에 매핑 정보를 제공
@EntityListeners(AuditingEntityListener.class) //이게 있으면 default 값을 넣어줌
@Getter
public class BaseEntity {
    @CreatedDate
    private LocalDateTime created_at;

    @CreatedDate
    private LocalDateTime updated_at;
}