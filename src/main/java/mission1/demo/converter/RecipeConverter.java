package mission1.demo.converter;

import mission1.demo.domain.Recipe;
import mission1.demo.web.dto.RecipeRequestDto;
import mission1.demo.web.dto.RecipeResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeConverter { //torecipe, toCreateRecipeDto, toRecipeListDto
    //craete controller response
    public static RecipeResponseDto.CreateRecipeDto toCreateRecipeDto(Recipe recipe){
        return RecipeResponseDto.CreateRecipeDto.builder()
                .recipe_id(recipe.getId())
                .createdAt(recipe.getCreated_at())
                .build();
    }

    //create service 요청
    public static Recipe toRecipe(RecipeRequestDto.CreateRecipeDto request){
        return Recipe.builder()
                .recipe_title(request.getRecipe_title())
                .introduction(request.getIntroduction())
                .build();
    }
    public static RecipeResponseDto.RecipeDto toRecipeDto(Recipe recipe){

        return RecipeResponseDto.RecipeDto.builder()
                .recipe_id(recipe.getId())
                .recipe_title(recipe.getRecipe_title())
                .introduction(recipe.getIntroduction())
                .build();
    }

    public static List<RecipeResponseDto.RecipeDto> toRecipeDtoList(List<Recipe> recipeList){
        return recipeList.stream()
                .map(recipe -> toRecipeDto(recipe))
                .collect(Collectors.toList());
    }

    public static RecipeResponseDto.RecipeListDto toRecipeListDto(List<Recipe> recipeList){
        return RecipeResponseDto.RecipeListDto.builder()
                .recipeDtoList(toRecipeDtoList(recipeList))
                .size(recipeList.size())
                .build();
    }
}
