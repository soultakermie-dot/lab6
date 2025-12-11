/**
 * Exception thrown when trying to alight a passenger who is not in the vehicle
 */
public class PassengerNotInVehicleException extends Exception {
    public PassengerNotInVehicleException(String message) {
        super(message);
    }
}

