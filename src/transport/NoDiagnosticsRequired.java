package transport;

public class NoDiagnosticsRequired extends Exception{

    private Transport transport;

    public NoDiagnosticsRequired(String message, Buses transport) {
        super(message);
        this.transport = transport;
    }
}
