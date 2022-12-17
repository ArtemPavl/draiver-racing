package Driver;

import transport.Buses;

public class DriverD <T extends Buses> extends Driver {

    private T transport;

    public DriverD(String name, int drivingExperience) {
        super(name,'D', drivingExperience);
    }

    public T getTransport(){
        return this.transport;
    }

    public void setTransport(T transport){
        if (this.transport == null) {
            this.transport = transport;
            this.transport.setDriver(this);
        }
    }
}
