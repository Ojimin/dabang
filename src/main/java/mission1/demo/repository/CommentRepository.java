package mission1.demo.repository;

import mission1.demo.domain.Comment;
import mission1.demo.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    /*
    @Query("select c.content, c.user, c.created_at from Comment c where c.recipe = :recipe")
    List<Object[]> findByRecipeId(Recipe recipe);
    */
    @Query("select c from Comment c join c.recipe r on r.id = :recipe_id")
    List<Comment> findByRecipeId(Long recipe_id); //여러 개를 어떻게 보여주지?? projection?
}

