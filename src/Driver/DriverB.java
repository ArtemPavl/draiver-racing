package Driver;

import transport.Cars;
import transport.Transport;

public class DriverB<T extends Cars> extends Driver {

    private T transport;
    public DriverB (String name, int drivingExperience) {
        super(name, 'B', drivingExperience);
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
