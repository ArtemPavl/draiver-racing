package transport;

public class Trucks extends Transport implements Competing{

    public enum BodyTypes{
        N1(null, 3.5F),
        N2(3.5F, 12F),
        N3(12F, null);

        private final Float lowerWeightLimit;
        private final Float upperWeightLimit;

        BodyTypes(Float lowerWeightLimit, Float upperWeightLimit) {
            this.lowerWeightLimit = lowerWeightLimit;
            this.upperWeightLimit = upperWeightLimit;
        }

        public Float getLowerWeightLimit() {
            return lowerWeightLimit;
        }

        public Float getUpperWeightLimit() {
            return upperWeightLimit;
        }


        @Override
        public String toString() {
            if (getLowerWeightLimit() == null){
                return "\nГрузоподъемность: до " + getUpperWeightLimit() + " тон";
            }else if (getUpperWeightLimit() == null){
                return "\nГрузоподъемность: от " + getLowerWeightLimit() + " тон";
            }else {
                return "\nГрузоподъемность: от " + getLowerWeightLimit() + " до "
                        + getUpperWeightLimit() + " тон";
            }
        }
    }

    private BodyTypes bodyType;

    public Trucks(String brand, String model, double engineVolume, BodyTypes bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }
    public Trucks(String brand, String model, double engineVolume) {
        this(brand, model, engineVolume, null);
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
    public String toString() {
        return super.toString() + getBodyType().toString();
    }
}
