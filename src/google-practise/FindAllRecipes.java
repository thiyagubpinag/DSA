import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAllRecipes {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> suppliesSet = new HashSet();
        for (String supply : supplies) {
            suppliesSet.add(supply);
        }

        List<String> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }

        for (String recipe : recipes) {
            if (dfs(map, recipe, suppliesSet)) {
                result.add(recipe);
            }
        }

        return result;
    }

    boolean dfs(HashMap<String, List<String>> map, String recipe, HashSet<String> suppliesSet) {
        List<String> missingIngredients = getInterSection(map.get(recipe), suppliesSet);

        if (missingIngredients.isEmpty()) {
            suppliesSet.add(recipe);
            return true;
        }

        for (int i = 0; i < missingIngredients.size(); i++) {
            if (!map.containsKey(missingIngredients.get(i))) {
                return false;
            }
        }

        for (int i = 0; i < missingIngredients.size(); i++) {
            if (!dfs(map, missingIngredients.get(i), suppliesSet)) {
                return false;
            }
        }

        return true;

    }

    List<String> getInterSection(List<String> ingredients, HashSet<String> suppliesSet) {
        List<String> missingIngredients = new ArrayList<>();
        for (int i = 0; i < ingredients.size(); i++) {
            if (!suppliesSet.contains(ingredients.get(i))) {
                missingIngredients.add(ingredients.get(i));
            }
        }
        return missingIngredients;
    }

    public static void main(String[] args) {
        String[] recipes = { "ju", "fzjnm", "x", "e", "zpmcz", "h", "q" };
        String[][] ingredients = { { "d" }, { "hveml", "f", "cpivl" }, { "cpivl", "zpmcz", "h", "e", "fzjnm", "ju" },
                { "cpivl", "hveml", "zpmcz", "ju", "h" }, { "h", "fzjnm", "e", "q", "x" },
                { "d", "hveml", "cpivl", "q", "zpmcz", "ju", "e", "x" }, { "f", "hveml", "cpivl" } };
        String[] supplies = { "f", "hveml", "cpivl", "d" };
        List<List<String>> ingredientList = new ArrayList<>();
        for (String[] ingredientArray : ingredients) {
            List<String> ingredientTemp = new ArrayList<>();
            for (String ingredient : ingredientArray) {
                ingredientTemp.add(ingredient);
            }
            ingredientList.add(ingredientTemp);
        }
        FindAllRecipes findAllRecipes = new FindAllRecipes();
        findAllRecipes.findAllRecipes(recipes, ingredientList, supplies);
    }
}
