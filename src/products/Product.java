package products;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {

    private String name;
    private double cost;
    private double requiredQuantity;
    private String purchaseStatus;

    public static HashMap<String, Double> listOfProducts = new HashMap<>();
    public Product(String name, double cost) {
        this.name = name;
        this.setCost(cost);
    }

    public Product(String name) {
        this(name, 0);
    }

    public void buy() {
        this.name = "Куплен";
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getRequiredQuantity() {
        return requiredQuantity;
    }

    public void setRequiredQuantity(double requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public static void addListOfProduct(Product product, double requiredQuantity){
        if (product.getCost() == 0){
            throw new RuntimeException("Не указана цена " + product.getName());
        }else if (findMatches(product, listOfProducts)){
            throw  new RuntimeException(product.getName() + " уже есть в списке покупок");
        }else {
            product.setPurchaseStatus("Необходимо купить");
            product.setRequiredQuantity(requiredQuantity);
            listOfProducts.put(product.getName(), requiredQuantity);
        }
    }

    public static boolean findMatches(Product product, HashMap<String, Double> listOfProducts) {

        boolean matches = false;

        for (String key : listOfProducts.keySet()) {
            if (product.getName().equals(key)) {
                matches = true;
                break;
            }
        }
        return matches;
    }

    @Override
    public String toString() {
        return "\nНазвание: " + name +
                "\nЦена: " + cost +
                "\nКоличество: " + requiredQuantity +
                "\nСтатус покупки: " + purchaseStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.cost, cost) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
