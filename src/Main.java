/**
 * Main class demonstrating the transport vehicle hierarchy
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Transport Vehicle System Demo ===\n");
        
        // Run unit tests
        RoadTest test = new RoadTest();
        test.testBusWithRegularPassengers();
        test.testTaxiWithMixedPassengers();
        test.testFireTruckWithFirefighters();
        test.testPoliceCarWithPoliceOfficers();
        test.testVehicleFullException();
        test.testPassengerNotInVehicleException();
        test.testRoadWithMultipleVehicles();
        
        System.out.println("\n=== All tests completed successfully! ===");
    }
}
