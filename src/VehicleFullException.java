/**
 * Exception thrown when trying to board a passenger but vehicle is full
 */
public class VehicleFullException extends Exception {
    public VehicleFullException(String message) {
        super(message);
    }
}

