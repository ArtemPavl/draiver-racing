package transport;

public interface Competing {
    void pitStop();

    void getBestLapTime(double bestLapTime);

    void getMaxSpeed(int maxSpeed);
}
