package support;

import transport.Transport;

import java.util.ArrayList;

public class Mechanic  {

    private String name;
    private String company;
    public static ArrayList<Mechanic> mechanics = new ArrayList<>();
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
}
