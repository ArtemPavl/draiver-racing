import Driver.*;
import support.Mechanic;
import support.ServiceStation;
import support.Sponsors;
import transport.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] agrs) {
        System.out.println("Приложение для автогонок");

        Cars vesta = new Cars("Lada", "Vesta", 2.0, Cars.BodyTypes.SEDAN);
        Cars solaris = new Cars("Hyundai", "Solaris", 1.8, Cars.BodyTypes.SEDAN);
        Cars rio = new Cars("Kia", "Rio", 2.0, Cars.BodyTypes.SEDAN);
        Cars golf = new Cars("Volkswagen", "Golf", 1.8, Cars.BodyTypes.HATCHBACK);

//        System.out.println(Transport.transports);

//        Trucks kamaz = new Trucks("KamAZ", "4326-9", 10.8, Trucks.BodyTypes.N1);
        Trucks tatra = new Trucks("Tatra", "Phoenics G2", 11.2, Trucks.BodyTypes.N2);
//        Trucks meredes = new Trucks("Mersedes-Benz", "Tankpool24", 11.0, Trucks.BodyTypes.N3);
//        Trucks renault = new Trucks("Renault", "Kerax", 10.8, Trucks.BodyTypes.N1);
//
//        Buses mersedes = new Buses("Mersedes-Benz", "eCitaro G", 10.7, Buses.BodyTypes.MEDIUM);
//        Buses kingLong = new Buses("KING LONG", "XMQ6129Y5", 8.8);
        Buses liaz = new Buses("ЛиАЗ", "4292", 7.8, Buses.BodyTypes.BIG);
        Buses yutong = new Buses("Yutong", "6122", 8.2, Buses.BodyTypes.ESPECIALLY_BIG);
//
        DriverD<Buses> artem = new DriverD<>("Павленко Артем Евгеньевич",  10);
        DriverB<Cars> margarita = new DriverB<>("Павленко Марграрита Юрьевна", 12);
        DriverC<Trucks> ivan = new DriverC<>("Финашин Иван Леонидович",  8);
//
        margarita.setTransport(vesta);
        System.out.println(margarita.getTransport());
        System.out.println(vesta.getDriver().getName());
        artem.setTransport(liaz);
        tatra.setDriver(ivan);

        Mechanic vitor = new Mechanic("Виктор", "Горыныч", Cars.class, Buses.class);
        Mechanic john = new Mechanic("Джон", "Fix", Trucks.class);
        Mechanic nikjlay = new Mechanic("Николай", "Шиомонтаж", Cars.class);


        Sponsors ikea = new Sponsors("IKEA", 20000);
        Sponsors sumsung = new Sponsors("Sumsung", 30000);

        vesta.addMechanic(vitor, nikjlay);
        vesta.addSponsor(ikea, sumsung);

        System.out.println(vesta.getMachineMechanics() + "\n" + vesta.getMachineSponsors());

        ServiceStation.addTransportInQueue(vesta, tatra);
//        System.out.println(ServiceStation.transportQueue);

        ServiceStation.conductTechnicalInspection();
//        Driver.Driver.addDriversparticipatingInTheRace(margarita, artem, ivan);
//        participateInTheRace(Driver.Driver.getDriversParticipatingInTheRace());
//
//        solaris.printType();
//        kamaz.printType();
//        kingLong.printType();
//
//        solaris.passDiagnostics();
//        kamaz.passDiagnostics();
//
//        chekDiagnostics(solaris, kamaz, meredes);


    }

//    public  static void participateInTheRace(Driver[] drivers){
//        for (Driver driver : drivers) {
//            System.out.println("Водитель " + driver.getName() + " управляет автомобилем "
//                    + driver.getTransport().getBrand() + " " + driver.getTransport().getModel()
//                    + " и будет участвовать в заезде");
//        }
//    }

    public static void chekDiagnostics(Transport... transports){
        int count = 0;
        try {
            for (Transport transport : transports) {
                if (transport.isDiagnostics()){
                    count++;
                }else {
                    throw new RuntimeException("Машина " + transport.getBrand() + " " +
                            transport.getModel() + " не прошла диагностику");
                }
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }finally {
            if (transports.length == count) {
                System.out.println("Все машины прошли диагностику");
            }else {
                System.out.println(count + " машин прошли диагностику");
            }
        }
    }
}
