package taskThree;

import products.Recipe;

import java.util.HashMap;
import java.util.Map;

public class TaskThreeMain {
    public static void main(String[] agrs){
        Map<String, Integer> stringIntegerMap = new HashMap<>();

        addStringIntegermap(stringIntegerMap, "str1",2);
        System.out.println(stringIntegerMap);

        addStringIntegermap(stringIntegerMap, "str2",1);
        System.out.println(stringIntegerMap);

//        addStringIntegermap(stringIntegerMap, "str1",2);
//        System.out.println(stringIntegerMap);

        addStringIntegermap(stringIntegerMap, "str1",5);
        System.out.println(stringIntegerMap);
    }

    public static void addStringIntegermap(Map<String, Integer> stringIntegerMap, String str, int numbers){

        boolean matches = false;

        for (String key : stringIntegerMap.keySet()) {
            if (str.equals(key) && stringIntegerMap.get(key).equals(numbers)) {
                matches = true;
                throw new RuntimeException("такой объект уже есть");
            } else if (str.equals(key) && !stringIntegerMap.get(key).equals(numbers)) {
                stringIntegerMap.replace(key, numbers);
                matches = true;
            }
        }
        if (!matches){
            stringIntegerMap.put(str, numbers);
        }
    }
}
