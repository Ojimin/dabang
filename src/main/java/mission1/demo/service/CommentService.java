package mission1.demo.service;

import lombok.RequiredArgsConstructor;
import mission1.demo.converter.CommentConverter;
import mission1.demo.converter.RecipeConverter;
import mission1.demo.domain.Comment;
import mission1.demo.domain.Recipe;
import mission1.demo.domain.User;
import mission1.demo.repository.CommentRepository;
import mission1.demo.repository.RecipeRepository;
import mission1.demo.repository.UserRepository;
import mission1.demo.web.dto.CommentRequestDto;
import mission1.demo.web.dto.RecipeRequestDto;
import mission1.demo.web.dto.RecipeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Comment create(CommentRequestDto.CreateCommentDto request, Long recipe_id) {
        Recipe recipe = recipeRepository.findById(recipe_id)
                .orElseThrow(()->{return new IllegalArgumentException("게시글 id 없음");
                });
        User user = userRepository.findById(request.getUserid())
                .orElseThrow(()->{return new IllegalArgumentException("user id 없음");
                });
        Comment comment = CommentConverter.toComment(request, recipe, user);
        return commentRepository.save(comment);
    }

    public List<Comment> findByRecipeId(Long recipe_id) {
        return commentRepository.findByRecipeId(recipe_id);
    }
}
