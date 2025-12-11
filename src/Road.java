import java.util.ArrayList;
import java.util.List;

/**
 * Represents a road section with vehicles
 */
public class Road {
    public List<TransportVehicle<? extends Human>> carsInRoad = new ArrayList<>();

    /**
     * Count the total number of humans transported by all vehicles on the road
     * @return Total count of humans
     */
    public int getCountOfHumans() {
        int totalCount = 0;
        for (TransportVehicle<? extends Human> vehicle : carsInRoad) {
            totalCount += vehicle.getOccupiedSeats();
        }
        return totalCount;
    }

    /**
     * Add a vehicle to the road
     * @param vehicle The vehicle to add (can be any transport vehicle with any passenger type)
     */
    public void addCarToRoad(TransportVehicle<? extends Human> vehicle) {
        carsInRoad.add(vehicle);
    }
}

