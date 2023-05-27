package mission1.demo.web.dto;

import lombok.*;
import mission1.demo.domain.Recipe;
import mission1.demo.domain.User;

import java.time.LocalDateTime;
import java.util.List;
//연관관계 정보는 다뺴야함?
public class CommentResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentDto {
        private Long comment_id;
        private String content;
        private String username;
        private Long recipe_id;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentListDto{
        private List<CommentResponseDto.CommentDto> commentDtoList;
        private Integer size;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateCommentDto {
        private Long comment_id;
        private String content;
        private String username;
        private Long recipe_id;
        private LocalDateTime createdAt;
    }
}
