package SuperMarket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SuperMarket {

    private static ArrayList<Queue<String>> checkouts = new ArrayList<>();

    public static void addCheckcout(){
        if (checkouts.size() < 3){
            checkouts.add(new LinkedList<>());
        }
    }

    private static int getSmallestQueue(){
        int resoult = 0;
        for (int i = 1; i < checkouts.size(); i++) {
            if (checkouts.get(resoult).size() > checkouts.get(i).size()) {
                resoult = i;
            }
        }
        if(checkouts.get(resoult).size() < 5){
            return resoult;
        }else {
            throw new RuntimeException("Все очереди заполнены");
        }
    }
    public static void removeRandom(){
        checkouts.get((int) (Math.random()*3)).remove();
    }
//    написать метод удаления элемента очереди
    public static void addInQueue(String... strs){
        for (String str : strs) {
            if(checkouts.get(0).size() == 5 && checkouts.get(1).size() == 5){
                checkouts.add(new LinkedList<>());
            }
            checkouts.get(getSmallestQueue()).add(str);
        }
    }

    public static ArrayList<Queue<String>> getCheckouts() {
        return checkouts;
    }
}
