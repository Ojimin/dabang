package mission1.demo.web.controller;

import lombok.RequiredArgsConstructor;
import mission1.demo.converter.CommentConverter;
import mission1.demo.converter.RecipeConverter;
import mission1.demo.domain.Comment;
import mission1.demo.domain.Recipe;
import mission1.demo.service.CommentService;
import mission1.demo.web.dto.CommentRequestDto;
import mission1.demo.web.dto.CommentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentRestController {

    private final CommentService commentService;

    @GetMapping("/recipe/{recipe_id}/comment")
    public ResponseEntity<CommentResponseDto.CommentListDto> getCommentList(@PathVariable(name = "recipe_id") Long recipe_id){
        List<Comment> commentList = commentService.findByRecipeId(recipe_id);
        return ResponseEntity.ok(CommentConverter.toCommentListDto(commentList));

    }

    @PostMapping("/recipe/{recipe_id}/comment/new")
    public ResponseEntity<CommentResponseDto.CreateCommentDto> createComment(@PathVariable(name = "recipe_id") Long recipe_id, @RequestBody CommentRequestDto.CreateCommentDto request){
        Comment comment = commentService.create(request, recipe_id);
        return ResponseEntity.ok(CommentConverter.toCreateCommentDto(comment));
    }


}
