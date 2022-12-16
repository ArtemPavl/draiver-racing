package multiplicationTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultipcationTable {
    public static void main(String[] agrs){
        Set<List<Integer>> examples = new HashSet<>(15);
        List<Integer> example;
        do{
            example = new ArrayList<>();
            example.add(0, generateNamber());
            example.add(1, generateNamber());
            examples.add(example);
        }while (examples.size() < 15);


        prinExamples(examples);
    }
    public static int generateNamber(){

        int resoult = 0;

        do{
            resoult = (int) (Math.random()*10);
        }while (resoult == 0);
        return resoult;
    }

    public static void prinExamples(Set<List<Integer>> examples){
        int count = 0;
        for (List<Integer> example : examples) {
            count++;
            System.out.println(count + ". " + example.get(0) + " * " + example.get(1) + " = ?");
        }
    }

}
