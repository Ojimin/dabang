package mission1.demo.web.controller;

import lombok.RequiredArgsConstructor;
import mission1.demo.converter.RecipeConverter;
import mission1.demo.domain.Recipe;
import mission1.demo.service.RecipeService;
import mission1.demo.web.dto.RecipeRequestDto;
import mission1.demo.web.dto.RecipeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RecipeRestController {
    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public ResponseEntity<RecipeResponseDto.RecipeListDto> getRecipeList(){
        List<Recipe> recipeList = recipeService.findAll();
        return ResponseEntity.ok(RecipeConverter.toRecipeListDto(recipeList)); //reponseentity.ok는 성공했다는 상태코드와 함꼐, 빌더 패턴의 일부인가?
    }

    @PostMapping("/recipe/new")
    public ResponseEntity<RecipeResponseDto.CreateRecipeDto> createRecipe(@RequestBody RecipeRequestDto.CreateRecipeDto request){
        Recipe recipe = recipeService.create(request);
        return ResponseEntity.ok(RecipeConverter.toCreateRecipeDto(recipe));
    }

    @PostMapping("/recipe/like")
    public ResponseEntity
}
