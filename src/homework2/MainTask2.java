package homework2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainTask2 {
    public static void main(String[] agrs){

        Map<Integer, String> stringMap = new LinkedHashMap<>();

        addString(stringMap, 10);
        System.out.println(printStringMap(stringMap));
    }

    public static void addString(Map<Integer, String> stringMap, int amount){
        for (int i = 0; i < amount; i++) {
            stringMap.put((int)(Math.random()*100), "string" + (i + 1));
        }
    }
    public static StringBuilder printStringMap(Map<Integer, String> stringMap){

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<Integer, String> entry : stringMap.entrySet()) {
            builder.append("\"").append(entry.getKey()).append(":").append(entry.getValue()).append("\"").append("\n");
        }
        return builder;
    }
}
