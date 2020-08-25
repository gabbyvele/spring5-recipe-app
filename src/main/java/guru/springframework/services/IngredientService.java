package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;

import java.util.Set;

public interface IngredientService {

    Set<Ingredient> getIngredients();

    Recipe findById(Long id);

    IngredientCommand findIngredientCommandById(Long id);

    IngredientCommand findRecipeIdAndIngredientId(Long recipeId, Long id);

    IngredientCommand saveIngredientCommand(IngredientCommand recipeCommand);

    void deleteById(Long recipeId, Long id);
}
