package transport;

import java.sql.Driver;
import Driver.DriverB;
import support.Mechanic;

public class Cars<T extends DriverB> extends Transport implements Competing{

    public enum BodyTypes{
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кросовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String bodyType;
        BodyTypes (String bodyType){
            this.bodyType = bodyType;
        }

        public String getBodyType() {
            return bodyType;
        }
        @Override
        public String toString() {
            return "\nТип кузова: " + getBodyType();
        }

    };
    private BodyTypes bodyType;
    private T driver;

    public Cars(String brand, String model, double engineVolume, BodyTypes bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Cars(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, null);
    }

    @Override
    public void addMechanic(Mechanic... mechanics) {
        for (Mechanic mechanic : mechanics) {
            for (Class typeTransport : mechanic.getTypeTransport()){
                if(typeTransport.equals(Cars.class)){
                    this.machineMechanics.add(mechanic);
                    break;
                }else {
                    throw new RuntimeException("Механику " + mechanic.getName() +
                            " не хватает квалификации для обслуживания " + getBrand() + " " + getModel());
                }
            }
        }
    }

    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        if (this.driver == null){
            this.driver = driver;
            this.driver.setTransport(this);
        }
    }

    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(getBodyType().toString());
        }else {
            System.out.println("\nДанных по транспортному средству не достаточно");
        }
    }

    @Override
    public void passDiagnostics() {
        this.setDiagnostics(true);
    }

    @Override
    public void pitStop() {
        stop();
        System.out.println(getBrand() + " на пит-стопе");
        start();
    }

    @Override
    public void getBestLapTime(double bestLapTime){
        System.out.println("Лучшее время круга " + getBrand() + ": " + bestLapTime);
    }

    @Override
    public void getMaxSpeed(int maxSpeed) {
        System.out.println("Макимальная скорость " + getBrand() + ": " + maxSpeed);
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }


    @Override
    public String toString() {
        return super.toString() +
                getBodyType().toString();
    }

    private class DriverB {
    }
}
