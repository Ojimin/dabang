package mission1.demo.converter;

import mission1.demo.domain.Comment;
import mission1.demo.domain.Recipe;
import mission1.demo.domain.User;
import mission1.demo.web.dto.CommentRequestDto;
import mission1.demo.web.dto.CommentResponseDto;
import mission1.demo.web.dto.RecipeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter { //toComment, toCommentListDto, toCreateCommentDto

    //comment dto 빌더 역할
    public static CommentResponseDto.CreateCommentDto toCreateCommentDto(Comment comment){
        return CommentResponseDto.CreateCommentDto.builder()
                .comment_id(comment.getId())
                .content(comment.getContent())
                .username(comment.getUser().getName())
                .recipe_id(comment.getRecipe().getId())
                .createdAt(comment.getCreated_at())
                .build();
    }
    //service에서 객체 만들때 사용, domain의 comment 빌더 역할
    public static Comment toComment(CommentRequestDto.CreateCommentDto request, Recipe r, User u){
        return Comment.builder()
                .content(request.getContent())
                .recipe(r)
                .user(u)
                .build();
    }

    public static CommentResponseDto.CommentDto toCommentDto(Comment comment){

        return CommentResponseDto.CommentDto.builder()
                .comment_id(comment.getId())
                .content(comment.getContent())
                .username(comment.getUser().getName())
                .recipe_id(comment.getRecipe().getId())
                .createdAt(comment.getCreated_at())
                .updatedAt(comment.getUpdated_at())
                .build();
    }

    public static List<CommentResponseDto.CommentDto> toCommentDtoList(List<Comment> commentList){
        return commentList.stream()
                .map(comment -> toCommentDto(comment))
                .collect(Collectors.toList());
    }
    //근데 왜이렇게 많이 감싸지?
    public static CommentResponseDto.CommentListDto toCommentListDto(List<Comment> commentList){
        return CommentResponseDto.CommentListDto.builder()
                .commentDtoList(toCommentDtoList(commentList))
                .size(commentList.size())
                .build();
    }


}
