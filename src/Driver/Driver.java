package Driver;

import transport.Cars;
import transport.Transport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public abstract class Driver<T extends Transport> {

    private String name;
    private char typeDriverLicense;
    private int drivingExperience;
    public static ArrayList<Driver> drivers = new ArrayList<>();
    private static Driver[] driversParticipatingInTheRace = new Driver[0];

    public Driver(String name, char typeDriverLicense, int drivingExperience) {
        if(name != null && !name.isEmpty() && !name.isBlank()){
            this.name = name;
        }else {
            this.name = "Водитель";
        }

        this.typeDriverLicense = typeDriverLicense;

        setDrivingExperience(drivingExperience);

        drivers.add(this);
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
