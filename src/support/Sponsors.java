package support;

import java.util.ArrayList;

public class Sponsors {

    private String name;
    private int supportAmount;
    public static ArrayList<Sponsors> sponsors = new ArrayList<>();

    public Sponsors (String name, int supportAmount){
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }else {
            new RuntimeException("Не указано имя спонсора");
        }
        setSupportAmount(supportAmount);
        sponsors.add(this);
    }

    public String getName() {
        return name;
    }

    public int getSupportAmount() {
        return supportAmount;
    }

    public void setSupportAmount(int supportAmount) {
        if(supportAmount > 0){
            this.supportAmount = supportAmount;
        }else {
            new RuntimeException("Сумма поддержки не может быть отрицательной");
        }
    }

    @Override
    public String toString() {
        return "\"" + name + "\"";
    }
}
