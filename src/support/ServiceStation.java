package support;

import transport.Buses;
import transport.Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation {

    private Transport transport;
    public static Queue<Transport> transportQueue = new LinkedList<>();

    public static void addTransportInQueue(Transport... transports){
        for (Transport transport : transports) {
            if (!transport.getClass().equals(Buses.class)) {
                transportQueue.add(transport);
            } else {
                throw new RuntimeException("Автобусы не нуждаются в техосмотре");
            }
        }
    }

    public static void conductTechnicalInspection(){
        do {
            System.out.println("Машина " + transportQueue.element().getBrand() + " " +
                    transportQueue.element().getModel() + " прошла техобслуживание и готова к заезду");
            transportQueue.remove();
        }while (transportQueue.size() != 0);
    }
}
