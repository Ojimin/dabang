package mission1.demo.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import mission1.demo.converter.RecipeConverter;
import mission1.demo.domain.Recipe;
import mission1.demo.repository.RecipeRepository;
import mission1.demo.web.dto.RecipeRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Transactional
    public Recipe create(RecipeRequestDto.CreateRecipeDto request) {
        Recipe recipe = RecipeConverter.toRecipe(request);
        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }
}