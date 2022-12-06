import transport.Transport;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Driver<T extends Transport> {

    private String name;
    private String typeDriverLicense;
    private int drivingExperience;
    private T transport;
    private static Driver[] driversParticipatingInTheRace = new Driver[0];



    public Driver(String name, String typeDriverLicense, int drivingExperience) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }else {
            this.name = "Водитель";
        }

        setTypeDriverLicense(typeDriverLicense);

        setDrivingExperience(drivingExperience);
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

    public String getTypeDriverLicense() {
        return typeDriverLicense;
    }

    public void setTypeDriverLicense(String typeDriverLicense) {
        if(typeDriverLicense != null && Pattern.matches("[BCD]", typeDriverLicense)){
            this.typeDriverLicense = typeDriverLicense;
        }else {
            throw new IllegalArgumentException("Необходимо указать тип прав!");
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
}
