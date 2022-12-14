package transport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import Driver.*;
import support.*;

public abstract class Transport<T extends Driver> {

    private String brand;
    private String model;
    private double engineVolume;
    public static ArrayList<Transport> transports = new ArrayList<>();
    protected ArrayList<Mechanic> machineMechanics = new ArrayList<>();
    private ArrayList<Sponsors> machineSponsors = new ArrayList<>();
    private boolean diagnostics = false;

    public Transport(String brand, String model, double engineVolume) {

        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }

        if (brand != null && !brand.isEmpty() && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }

        if (model != null && !model.isEmpty() && !model.isBlank()) {
            this.model = model;
        } else {
            this.model = "default";
        }

        transports.add(this);
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
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
    }

    public abstract void addMechanic(Mechanic... mechanics);
    public ArrayList<Mechanic> getMachineMechanics() {
        return machineMechanics;
    }

    public void addSponsor(Sponsors... sponsors){
        for (Sponsors sponsor : sponsors) {
            this.machineSponsors.add(sponsor);
        }
    }

    public ArrayList<Sponsors> getMachineSponsors() {
        return machineSponsors;
    }

    public void start() {
        System.out.println(getBrand() + " поехал");
    }

    public void stop() {
        System.out.println(getBrand() + " остаовился");
    }

    public abstract void printType();

    public abstract void passDiagnostics() throws NoDiagnosticsRequired;

    public boolean isDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(boolean diagnostics) {
        this.diagnostics = diagnostics;
    }

    public String toString() {
        return "\n" + this.brand +
                "\nМодель: " + this.model +
                "\nОбъем двигателя: " + this.engineVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }
}
