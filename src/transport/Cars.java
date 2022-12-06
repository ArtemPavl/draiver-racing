package transport;

import java.sql.Driver;

public class Cars extends Transport implements Competing{

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
    private Driver driver;

    public Cars(String brand, String model, double engineVolume, BodyTypes bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Cars(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, null);
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
}
