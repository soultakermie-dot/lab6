/**
 * Represents an automobile vehicle
 * @param <T> Type of passenger this automobile can carry (must extend Human)
 */
public abstract class Automobile<T extends Human> extends TransportVehicle<T> {
    public Automobile(int maxSeats) {
        super(maxSeats);
    }
}

