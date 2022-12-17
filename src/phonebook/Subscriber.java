package phonebook;

import java.util.HashMap;
import java.util.Objects;

public class Subscriber {

    private String name;
    private String surname;
    private String phone;

    public static HashMap<String, String> phonebook = new HashMap<>();

    public Subscriber(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        phonebook.put(getSurname() + " " + getName(), getPhone());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "\nАбонент: " + name + " " + surname +
                "\nТелефон: " + phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phone);
    }
}
