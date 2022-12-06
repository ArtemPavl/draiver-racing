import transport.*;

public class Main {
    public static void main(String[] agrs) {
        System.out.println("Приложение для автогонок");

        Cars vesta = new Cars("Lada", "Vesta", 2.0, Cars.BodyTypes.SEDAN);
        Cars solaris = new Cars("Hyundai", "Solaris", 1.8, Cars.BodyTypes.SEDAN);
        Cars rio = new Cars("Kia", "Rio", 2.0, Cars.BodyTypes.SEDAN);
        Cars golf = new Cars("Volkswagen", "Golf", 1.8, Cars.BodyTypes.HATCHBACK);

        Trucks kamaz = new Trucks("KamAZ", "4326-9", 10.8, Trucks.BodyTypes.N1);
        Trucks tatra = new Trucks("Tatra", "Phoenics G2", 11.2, Trucks.BodyTypes.N2);
        Trucks meredes = new Trucks("Mersedes-Benz", "Tankpool24", 11.0, Trucks.BodyTypes.N3);
        Trucks renault = new Trucks("Renault", "Kerax", 10.8, Trucks.BodyTypes.N1);

        Buses mersedes = new Buses("Mersedes-Benz", "eCitaro G", 10.7, Buses.BodyTypes.MEDIUM);
        Buses kingLong = new Buses("KING LONG", "XMQ6129Y5", 8.8);
        Buses liaz = new Buses("ЛиАЗ", "4292", 7.8, Buses.BodyTypes.BIG);
        Buses yutong = new Buses("Yutong", "6122", 8.2, Buses.BodyTypes.ESPECIALLY_BIG);

        Driver<Buses> artem = new Driver<>("Павленко Артем Евгеньевич", "B", 10);
        Driver<Cars> margarita = new Driver<>("Павленко Марграрита Юрьевна", "C", 12);
        Driver<Trucks> ivan = new Driver<>("Финашин Иван Леонидович", "D", 8);

        margarita.setTransport(vesta);
        artem.setTransport(liaz);
        ivan.setTransport(tatra);

        Driver.addDriversparticipatingInTheRace(margarita, artem, ivan);
        participateInTheRace(Driver.getDriversParticipatingInTheRace());

        solaris.printType();
        kamaz.printType();
        kingLong.printType();

        solaris.passDiagnostics();
        kamaz.passDiagnostics();

        chekDiagnostics(solaris, kamaz, meredes);


    }

    public  static void participateInTheRace(Driver[] drivers){
        for (Driver driver : drivers) {
            System.out.println("Водитель " + driver.getName() + " управляет автомобилем "
                    + driver.getTransport().getBrand() + " " + driver.getTransport().getModel()
                    + " и будет участвовать в заезде");
        }
    }

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
