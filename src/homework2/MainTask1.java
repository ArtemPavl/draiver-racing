package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTask1 {
    public static void main(String[] agrs){
        Map<String, List<Integer>> stringMap = new HashMap<>();

        addString(stringMap,"string1", 3);
        addString(stringMap,"string2", 3);

        System.out.println(stringMap);

        Map<String, Integer> convertedStringMap= convert(stringMap);

        System.out.println(convertedStringMap);

    }

    public static void addString (Map<String, List<Integer>> stringMap, String str, int amount){

        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            numbersList.add((int) (Math.random()*1000));
        }

        stringMap.put(str, numbersList);
    }

    public static Map<String, Integer> convert(Map<String, List<Integer>> stringMap){

        Map<String, Integer> convertedStringMap = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : stringMap.entrySet()) {
            int sum = 0;
            for (Integer value : entry.getValue()){
                sum = sum + value;
            }
            convertedStringMap.put(entry.getKey(), sum);

        }
        return convertedStringMap;
    }
}
