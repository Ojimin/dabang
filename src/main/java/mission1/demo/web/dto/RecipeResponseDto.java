package mission1.demo.web.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class RecipeResponseDto {
    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RecipeDto {
        private Long recipe_id;
        private String recipe_title;
        private Integer like_num;
        private String introduction;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RecipeListDto{
        private List<RecipeDto> recipeDtoList;
        private Integer size;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreateRecipeDto {
        private Long recipe_id;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdateRecipeDto {
        private Long recipe_Id;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class DeleteRecipeDto{
        private Long recipe_id;
        private LocalDateTime deletedAt;
    }


}
