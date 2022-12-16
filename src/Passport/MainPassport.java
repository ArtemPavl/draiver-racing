package Passport;

public class MainPassport {
    public static void main(String[] agrs){

        Passport passport1 = new Passport("2912 549707", "Артем", "Евгеньевич", "Павленко", "21.04.1993");
        Passport passport2 = new Passport("2932 544507", "Евгений", "Алексеевич", "Ищенко", "08.11.1988");
        Passport passport3 = new Passport("2892 587907", "Виктор", "Павлович", "Шаповалов", "23.12.1987");
        Passport passport4 = new Passport("2923 549037", "Елизавета", "Петровна", "Гурцкая", "11.08.1990");
        Passport passport5 = new Passport("2312 541117", "Марина", "Игоревна", "Симоненко", "15.01.1956");
        Passport passport6 = new Passport("2878 544507", "Генадий", "Викторович", "Климов", "09.03.1977");

        Passport.addPasport(passport1, passport2, passport3, passport4, passport5, passport6);
        Passport.printPassportsList();

        Passport passport7 = new Passport("2923 549037", "Елизавета", "Петровна", "Шаповалова", "11.08.1990");

        Passport.addPasport(passport7);
        Passport.printPassportsList();

        System.out.println(Passport.passportSearch("2912 549754"));

    }
}
