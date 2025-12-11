import java.util.ArrayList;
import java.util.List;

/**
 * Base class for transport vehicles that can carry passengers
 * @param <T> Type of passenger this vehicle can carry (must extend Human)
 */
public abstract class TransportVehicle<T extends Human> {
    protected final int maxSeats;
    protected final List<T> passengers;

    public TransportVehicle(int maxSeats) {
        this.maxSeats = maxSeats;
        this.passengers = new ArrayList<>();
    }

    /**
     * Get the maximum number of seats in the vehicle
     */
    public int getMaxSeats() {
        return maxSeats;
    }

    /**
     * Get the number of occupied seats
     */
    public int getOccupiedSeats() {
        return passengers.size();
    }

    /**
     * Board a passenger into the vehicle
     * @param passenger The passenger to board
     * @throws VehicleFullException if all seats are occupied
     */
    public void boardPassenger(T passenger) throws VehicleFullException {
        if (passengers.size() >= maxSeats) {
            throw new VehicleFullException("Vehicle is full. Cannot board passenger: " + passenger);
        }
        passengers.add(passenger);
    }

    /**
     * Alight a passenger from the vehicle
     * @param passenger The passenger to alight
     * @throws PassengerNotInVehicleException if the passenger is not in the vehicle
     */
    public void alightPassenger(T passenger) throws PassengerNotInVehicleException {
        if (!passengers.contains(passenger)) {
            throw new PassengerNotInVehicleException("Passenger " + passenger + " is not in the vehicle");
        }
        passengers.remove(passenger);
    }

    /**
     * Get the list of passengers (for counting purposes)
     */
    public List<T> getPassengers() {
        return new ArrayList<>(passengers);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{maxSeats=" + maxSeats + ", occupied=" + getOccupiedSeats() + "}";
    }
}

