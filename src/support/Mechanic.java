package support;

import transport.Transport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mechanic  {

    private String name;
    private String company;
    public static Set<Mechanic> mechanics = new HashSet<>();
    private ArrayList<Transport> transports = new ArrayList<>();
    private ArrayList<Class> typeTransport = new ArrayList<>();

    public Mechanic(String name, String company, Class... typeTransports) {
        this.name = name;
        this.company = company;
        for (Class typeTransport : typeTransports) {
            this.typeTransport.add(typeTransport);
        }
        mechanics.add(this);
    }

    public void fixTheCar(Transport transport){
        System.out.println("Машина " + transport.getBrand() + " " + transport.getModel() + " отремонтирована");
    }

    public void carryOutMaintenance(Transport transport){
        System.out.println("Машина " + transport.getBrand() + " " + transport.getModel() + " прошла техобслуживание");
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public ArrayList<Class> getTypeTransport() {
        return typeTransport;
    }

    @Override
    public String toString() {
        return "Механик" +
                "\nИмя: " + name +
                "\nКомпания: " + company +
                "\nСпециализация: " + this.typeTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company) && Objects.equals(transports, mechanic.transports) && Objects.equals(typeTransport, mechanic.typeTransport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, transports, typeTransport);
    }
}
