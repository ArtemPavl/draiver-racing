package Driver;

import transport.Cars;
import transport.Transport;

import java.util.*;
import java.util.regex.Pattern;

public abstract class Driver<T extends Transport> {

    private String name;
    private char typeDriverLicense;
    private int drivingExperience;
    public static Set<Driver> drivers = new HashSet<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return typeDriverLicense == driver.typeDriverLicense && drivingExperience == driver.drivingExperience && Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, typeDriverLicense, drivingExperience);
    }
}
