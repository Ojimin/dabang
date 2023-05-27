package mission1.demo.repository;


import mission1.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id); //optional은 null pointer 에러를 막아줌

}
