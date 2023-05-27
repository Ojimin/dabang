package mission1.demo.web.dto;

import lombok.Getter;
import lombok.Setter;

public class RecipeRequestDto {

    @Getter
    @Setter
    public static class CreateRecipeDto{
        private String recipe_title;
        private String introduction;
    }

    @Getter
    public static class UpdateRecipeDto{
        private String introduction;
    }

}
