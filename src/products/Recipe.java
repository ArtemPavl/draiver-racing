package products;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {

    private HashMap<String, Double> lostOfProducts;
    private double costRecipe;
    private double requiredQuantity;
    private String name;
    public static Set<Recipe> listOfRecipe = new HashSet<>();

    public Recipe(String name, HashMap<String, Double> lostOfProducts){
        this.name = name;
        this.lostOfProducts = new HashMap<>();
        this.lostOfProducts = lostOfProducts;
        addInListRecipe(this);
    }

    public Recipe(String name){
        this.name = name;
        lostOfProducts = new HashMap<>();
    }

    public HashMap<String, Double> getLostOfProducts() {
        return lostOfProducts;
    }

    public void addInLostOfProducts(Product product, double requiredQuantity) {
        if (product.getCost() == 0){
            throw new RuntimeException("Не указана цена " + product.getName());
        }else if (Product.findMatches(product, lostOfProducts)){
            throw  new RuntimeException(product.getName() + " уже есть в списке покупок");
        }else {
            product.setPurchaseStatus("Необходимо купить");
            product.setRequiredQuantity(requiredQuantity);
            lostOfProducts.put(product.getName(), requiredQuantity);
            costRecipe = costRecipe + product.getCost() * product.getRequiredQuantity();
        }
    }

    public void addInLostOfProducts(Product product) {
        if (product.getCost() == 0){
            throw new RuntimeException("Не указана цена " + product.getName());
        }else if (Product.findMatches(product, lostOfProducts)){
            throw  new RuntimeException(product.getName() + " уже есть в списке покупок");
        }else {
            product.setPurchaseStatus("Необходимо купить");
            product.setRequiredQuantity(1);
            lostOfProducts.put(product.getName(), 1.0);
            costRecipe = costRecipe + product.getCost() * product.getRequiredQuantity();
        }
    }

    public static void addInListRecipe(Recipe recipe){
        if (findMatches(recipe, listOfRecipe)){
            throw  new RuntimeException(recipe.getName() + " уже есть в списке рецептов");
        }else {
            listOfRecipe.add(recipe);
        }
    }

    public static boolean findMatches(Recipe recipe, Set<Recipe> listOfRecipes) {

        boolean matches = false;

        for (Recipe recipeFromTheList : listOfRecipes) {
            if (recipe.equals(recipeFromTheList)) {
                matches = true;
                break;
            }
        }
        return matches;
    }




    public double getCostRecipe() {
        return this.costRecipe;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "lostOfProducts=" + lostOfProducts +
                ", costRecipe=" + costRecipe +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lostOfProducts, costRecipe, name);
    }
}
