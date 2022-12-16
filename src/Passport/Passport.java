package Passport;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Passport {

    private String number;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;

    public static Set<Passport> passportsList = new HashSet<>();

    public Passport() {
       this(null, null, null, null, null);
    }

    public Passport(String number, String name, String surname, String dateOfBirth) {
        this(number, name, null,surname,  dateOfBirth);
    }

    public Passport(String number, String name, String patronymic,String surname,  String dateOfBirth) {
        if(Pattern.matches("[0-9]{4}[ ][0-9]{6}", number)){
            this.number = number;
        }else {
            throw new RuntimeException("Не верный формат номера. Пожалуйста введите номер паспорта" +
                    " в формате 1234 567890");
        }
        this.number = number;
        setName(name);
        setSurname(surname);
        this.patronymic = patronymic;

        if(dateOfBirth != null && !dateOfBirth.isEmpty() && !dateOfBirth.isBlank()){
            this.dateOfBirth = dateOfBirth;
        }else {
         throw new RuntimeException("Введите дату рождения в паспорт " + this.getNumber());
        }
    }

    public static void addPasport(Passport... passports){
        for (Passport passport : passports) {
            if(!searchForMathes(passport)){
                passportsList.add(passport);
            }
        }
    }

    public static void printPassportsList(){
        for (Passport passport : passportsList) {
            System.out.println(passport);
        }
    }

    public static Passport passportSearch(String number){
        for (Passport passport : passportsList) {
            if (number.equals(passport.getNumber())){
                return passport;
            }
        }
        return null;
    }

    private static boolean searchForMathes(Passport passport){

        boolean presenceOfMatches = false;

        for (Passport passportList : passportsList) {
            if(passport.equals(passportList)){
                presenceOfMatches = true;
                passportList.setName(passport.getName());
                passportList.setSurname(passport.getSurname());
                passportList.setPatronymic(passport.getPatronymic());
                break;
            }
        }
        return presenceOfMatches;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }else {
            throw new RuntimeException("Введите имя в паспорт " + this.getNumber());
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname != null && !surname.isEmpty() && !surname.isBlank()){
            this.surname = surname;
        }else {
            throw new RuntimeException("Введите фамилию в паспорт " + this.getNumber());
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "\nПаспорт: " + number +
                "\nФИО: " + surname + " " + name + " " + patronymic +
                "\nДата рождения: " + dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
