import transport.Transport;

import java.util.Arrays;

public class Driver<T extends Transport> {

    private String name;
    private String driverLicense;
    private int drivingExperience;
    private T transport;
    private static Driver[] driversParticipatingInTheRace = new Driver[0];



    public Driver(String name, String driverLicense, int drivingExperience) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }else {
            this.name = "Водитель";
        }

        if(driverLicense  != null && !driverLicense .isEmpty() &&
                !driverLicense .isBlank() && !driverLicense.equals("есть")){
            this.driverLicense  = driverLicense ;
        }else {
            this.driverLicense  = "нет";
        }

        if(drivingExperience > 0){
            this.drivingExperience = drivingExperience;
        }else {
            this.drivingExperience = Math.abs(drivingExperience);
        }
    }

    public static void addDriversparticipatingInTheRace(Driver... drivers){
        for (Driver driver : drivers){
        driversParticipatingInTheRace =
                Arrays.copyOf(getDriversParticipatingInTheRace(), getDriversParticipatingInTheRace().length +1);
        driversParticipatingInTheRace[getDriversParticipatingInTheRace().length - 1] = driver;
        }
    }

    public static Driver[] getDriversParticipatingInTheRace() {
        return driversParticipatingInTheRace;
    }

    public T getTransport(){
        return this.transport;
    }
    
    public void setTransport(T transport){
            this.transport = transport;
    }

    public void start(){
        System.out.println("Водитель " + getName() + " начал движение");
    }

    public void stop(){
        System.out.println("Водитель " + getName() + " начал движение");
    }

    public  void refuel(){
        System.out.println("Водитель " +  getName() + " запраляет авто");
    }

    public String getName() {
        return name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        if(driverLicense  != null && !driverLicense .isEmpty() &&
                !driverLicense .isBlank() && !driverLicense.equals("есть")){
            this.driverLicense  = driverLicense ;
        }else {
            this.driverLicense  = "нет";
        }
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(int drivingExperience) {
        if(drivingExperience > 0){
            this.drivingExperience = drivingExperience;
        }else {
            this.drivingExperience = Math.abs(drivingExperience);
        }
    }

//    Водители будут отличаться друг от друга по типу прав (соответственно, это три разных класса):
//
//    для легковых авто нужна категория В,
//    для грузовых нужна категория С,
//    для автобусов — D.
//
//    Водитель с определенным типом прав может управлять только одним авто в выбранной категории.
//    Управлять авто других категорий в наших соревнованиях он не может.
//    Подсказка
//
//    Напишите приложение, которое выводит в консоль информацию в формате:
//
//            “водитель А управляет автомобилем Б и будет участвовать в заезде”.
}
