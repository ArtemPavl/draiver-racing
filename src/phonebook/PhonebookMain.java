package phonebook;

import java.util.HashMap;

public class PhonebookMain {
    public static void main(String[] agrs){

        Subscriber pavlenko = new Subscriber("Артем", "Павленко", "+79157955432");
        Subscriber ivanov = new Subscriber("Иван", "Иванов", "+79156044332");
        Subscriber pavlovec = new Subscriber("Максим", "Павловец", "+79056045432");
        Subscriber petrov = new Subscriber("Семен", "Петров", "+79158775032");
        Subscriber shapovalov = new Subscriber("Алексей", "Шаповалов", "+79155675432");
        Subscriber bryanskaya = new Subscriber("Коза", "Брянская", "+79156098432");
        Subscriber koryakina = new Subscriber("Татьяна", "Корякина", "+79155675432");
        Subscriber sidorova = new Subscriber("Ангелина", "Сидорова", "+79156046582");
        Subscriber zyev = new Subscriber("Иван", "Зуев", "+79156045432");
        Subscriber simonova = new Subscriber("Наталья", "Симонова", "+79156057632");
        Subscriber klop = new Subscriber("Юрген", "Клоп", "+79156045432");
        Subscriber philippov = new Subscriber("Леонид", "Филиппов", "+79129045432");
        Subscriber selihov = new Subscriber("Александр", "Селихов", "+79156045736");
        Subscriber malafeeva = new Subscriber("Анна", "Малафеева", "+7915603752");
        Subscriber akinfeev = new Subscriber("Игорь", "Акинфеев", "+79156009432");
        Subscriber pavlov = new Subscriber("Егор", "Павлов", "+79156045098");
        Subscriber narbikov = new Subscriber("Ринат", "Нарбиков", "+79134525432");
        Subscriber malahov = new Subscriber("Андрей", "Малахов", "+79156957432");
        Subscriber eremin = new Subscriber("Андрей", "Еремин", "+79153745432");
        Subscriber zhukova = new Subscriber("Анна", "Жукова", "+79156045364");

        printPhonebook(Subscriber.phonebook);
    }
    public static void printPhonebook(HashMap<String, String> phonebook){
        int count = 0;
        for (String key : phonebook.keySet()) {
            System.out.println(++count + ". " + key + " " + phonebook.get(key));
        }
    }
}
