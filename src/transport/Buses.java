package transport;

public class Buses extends Transport implements Competing{

    public enum BodyTypes{
        ESPECIALLY_SMALL(null, 10),
        SMALL(10, 25),
        MEDIUM(40, 50),
        BIG(60, 80),
        ESPECIALLY_BIG(100, 120);

        private final Integer lowerCapacityLimit;
        private final Integer upperCapacityLimit;

        BodyTypes(Integer lowerWeightLimit, Integer upperWeightLimit) {
            this.lowerCapacityLimit = lowerWeightLimit;
            this.upperCapacityLimit = upperWeightLimit;
        }

        public Integer getLowerCapacityLimit() {
            return lowerCapacityLimit;
        }

        public Integer getUpperCapacityLimit() {
            return upperCapacityLimit;
        }

        @Override
        public String toString() {
            if (getLowerCapacityLimit() == null){
                return "\nВместимоть: до " + getUpperCapacityLimit() + " мест";
            }else if (getUpperCapacityLimit() == null){
                return "\nВместимоть: от " + getLowerCapacityLimit() + " мест";
            }else {
                return "\nВместимоть: от " + getLowerCapacityLimit() + " до "
                        + getUpperCapacityLimit() + " мест";
            }
        }
    }

    private BodyTypes bodyType;
    public Buses(String brand, String model, double engineVolume, BodyTypes bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }
    public Buses(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, null);
    }
    @Override
    public void pitStop() {
        stop();
        System.out.println(getBrand() + " на пит-стопе");
        start();
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
    public void passDiagnostics() throws NoDiagnosticsRequired {
        throw new NoDiagnosticsRequired("Автобус " + getBrand() + " не нуждается в диагностике.", this);
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
        return super.toString() + getBodyType().toString();
    }
}
