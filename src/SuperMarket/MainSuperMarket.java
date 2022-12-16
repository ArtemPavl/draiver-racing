package SuperMarket;

public class MainSuperMarket {
    public static void main(String[] agrs) {
//        Задание 2
        System.out.println("Задание 2");

        SuperMarket.addCheckcout();
        SuperMarket.addCheckcout();


        SuperMarket.addInQueue("Артем", "Егор", "Полина", "Генадий", "Евгений", "Миша");
        SuperMarket.addInQueue("Даниил", "Андрей", "Ангелина", "Фома", "Галина", "Матвей", "Гоша");
        System.out.println(SuperMarket.getCheckouts().get(0));
        System.out.println(SuperMarket.getCheckouts().get(1));
        System.out.println(SuperMarket.getCheckouts().get(2));

        SuperMarket.removeRandom();

        System.out.println(SuperMarket.getCheckouts().get(0));
        System.out.println(SuperMarket.getCheckouts().get(1));
        System.out.println(SuperMarket.getCheckouts().get(2));

        SuperMarket.removeRandom();

        System.out.println(SuperMarket.getCheckouts().get(0));
        System.out.println(SuperMarket.getCheckouts().get(1));
        System.out.println(SuperMarket.getCheckouts().get(2));

        SuperMarket.removeRandom();

        System.out.println(SuperMarket.getCheckouts().get(0));
        System.out.println(SuperMarket.getCheckouts().get(1));
        System.out.println(SuperMarket.getCheckouts().get(2));

        SuperMarket.removeRandom();

        System.out.println(SuperMarket.getCheckouts().get(0));
        System.out.println(SuperMarket.getCheckouts().get(1));
        System.out.println(SuperMarket.getCheckouts().get(2));

    }
}
