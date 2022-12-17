package products;
import java.util.HashSet;
import java.util.Set;

public class ProductMain {
    public static void main(String[] args) {
        System.out.println("Домашка по Хэш-функции");

        Product apple = new Product("Яблоко", 30.5);
        Product watermelon = new Product("Арбуз", 40.0);
        Product butter = new Product("Сливочное масло", 120.3);
        Product broad = new Product("Хлеб", 39.0);
        Product eggs = new Product("Яйца", 88.4);
        Product banana = new Product("Банан", 58.1);
        Product pear = new Product("Груша", 44.1);

//        Product.addListOfProduct(pear, 1.5);
//        Product.addListOfProduct(apple, 2);
//        Product.addListOfProduct(butter, 1);

//        System.out.println(Product.listOfProducts);
//
//        Product.addListOfProduct(pear, 0);

        Recipe recipe1 = new Recipe("Рецепт 1");
//        Recipe recipe2 = new Recipe("Рецепт 1");

        recipe1.addInLostOfProducts(apple, 1);
        recipe1.addInLostOfProducts(banana, 0.5);
        recipe1.addInLostOfProducts(pear, 1);

        System.out.println(recipe1.getLostOfProducts());
        System.out.println(recipe1.getCostRecipe());


    }
}
