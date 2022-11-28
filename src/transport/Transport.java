package transport;

import java.sql.Driver;
import java.util.Objects;

public abstract class Transport<T> {

    private String brand;
    private String model;
    private double engineVolume;
    private Driver driver;

    public Transport(String brand, String model, double engineVolume) {

        if (engineVolume > 0){
            this.engineVolume = engineVolume;
        }else {
            this.engineVolume = 1.5;
        }

        if (brand != null && !brand.isEmpty() && !brand.isBlank()){
            this.brand = brand;
        }else {
            this.brand = "default";
        }

        if (model != null && !model.isEmpty() && !model.isBlank()){
            this.model = model;
        }else {
            this.model = "default";
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume > 0){
            this.engineVolume = engineVolume;
        }else {
            this.engineVolume = 1.5;
        }
    }

    public void start(){
        System.out.println(getBrand() + " поехал");
    }

    public void stop(){
        System.out.println(getBrand() + " остаовился");
    }


    public  String toString(){
        return "\n" + this.brand +
                "\nМодель: " + this.model +
                "\nГод выпуска: " + this.engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<T> transport = (Transport<T>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
