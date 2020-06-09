package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.converters.IngredientToIngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Ingredient> getIngredients() {
        return null;
    }

    @Override
    public Recipe findById(Long id) {
        return null;
    }

    @Override
    public IngredientCommand saveIngredientCommand(IngredientCommand recipeCommand) {
        return null;
    }

    @Override
    public IngredientCommand findIngredientCommandById(Long id) {
        return null;
    }

    @Override
    public IngredientCommand findRecipeIdAndIngredientId(Long recipeId, Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()){
            log.error("recipe id {} not found", recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(id))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst();


        if (!ingredientCommandOptional.isPresent()){
            log.error("Ingredient id {} not found", id);
        }

        return ingredientCommandOptional.get();
    }

    @Override
    public void deleteById(Long id) {

    }
}
