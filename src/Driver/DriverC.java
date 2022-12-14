package Driver;

import transport.Trucks;

public class DriverC <T extends Trucks> extends Driver {

    private T transport;

    public DriverC(String name, int drivingExperience) {
        super(name, 'C', drivingExperience);
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
