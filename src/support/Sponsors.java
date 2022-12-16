package support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Sponsors {

    private String name;
    private int supportAmount;
    public static Set<Sponsors> sponsors = new HashSet<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsors sponsors = (Sponsors) o;
        return supportAmount == sponsors.supportAmount && Objects.equals(name, sponsors.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supportAmount);
    }
}
