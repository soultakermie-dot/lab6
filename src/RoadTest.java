/**
 * Unit tests for Road class and vehicle functionality
 */
public class RoadTest {
    
    public static void main(String[] args) {
        RoadTest test = new RoadTest();
        test.testBusWithRegularPassengers();
        test.testTaxiWithMixedPassengers();
        test.testFireTruckWithFirefighters();
        test.testPoliceCarWithPoliceOfficers();
        test.testVehicleFullException();
        test.testPassengerNotInVehicleException();
        test.testRoadWithMultipleVehicles();
        System.out.println("All tests passed!");
    }

    /**
     * Test Bus with regular passengers
     */
    public void testBusWithRegularPassengers() {
        System.out.println("Testing Bus with Regular Passengers...");
        Bus bus = new Bus(50);
        RegularPassenger p1 = new RegularPassenger("John");
        RegularPassenger p2 = new RegularPassenger("Jane");
        
        try {
            bus.boardPassenger(p1);
            bus.boardPassenger(p2);
            assert bus.getOccupiedSeats() == 2 : "Bus should have 2 passengers";
            assert bus.getMaxSeats() == 50 : "Bus should have 50 max seats";
            System.out.println("  ✓ Bus boarding test passed");
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException";
        }
    }

    /**
     * Test Taxi with mixed passenger types
     */
    public void testTaxiWithMixedPassengers() {
        System.out.println("Testing Taxi with Mixed Passengers...");
        Taxi taxi = new Taxi(4);
        RegularPassenger p1 = new RegularPassenger("Alice");
        Firefighter f1 = new Firefighter("Bob");
        PoliceOfficer po1 = new PoliceOfficer("Charlie");
        
        try {
            taxi.boardPassenger(p1);
            taxi.boardPassenger(f1);
            taxi.boardPassenger(po1);
            assert taxi.getOccupiedSeats() == 3 : "Taxi should have 3 passengers";
            System.out.println("  ✓ Taxi mixed passengers test passed");
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException";
        }
    }

    /**
     * Test FireTruck with firefighters only
     */
    public void testFireTruckWithFirefighters() {
        System.out.println("Testing FireTruck with Firefighters...");
        FireTruck fireTruck = new FireTruck(6);
        Firefighter f1 = new Firefighter("Firefighter1");
        Firefighter f2 = new Firefighter("Firefighter2");
        
        try {
            fireTruck.boardPassenger(f1);
            fireTruck.boardPassenger(f2);
            assert fireTruck.getOccupiedSeats() == 2 : "FireTruck should have 2 passengers";
            System.out.println("  ✓ FireTruck test passed");
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException";
        }
    }

    /**
     * Test PoliceCar with police officers only
     */
    public void testPoliceCarWithPoliceOfficers() {
        System.out.println("Testing PoliceCar with Police Officers...");
        PoliceCar policeCar = new PoliceCar(4);
        PoliceOfficer po1 = new PoliceOfficer("Officer1");
        PoliceOfficer po2 = new PoliceOfficer("Officer2");
        
        try {
            policeCar.boardPassenger(po1);
            policeCar.boardPassenger(po2);
            assert policeCar.getOccupiedSeats() == 2 : "PoliceCar should have 2 passengers";
            System.out.println("  ✓ PoliceCar test passed");
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException";
        }
    }

    /**
     * Test VehicleFullException
     */
    public void testVehicleFullException() {
        System.out.println("Testing VehicleFullException...");
        Taxi taxi = new Taxi(2);
        RegularPassenger p1 = new RegularPassenger("Passenger1");
        RegularPassenger p2 = new RegularPassenger("Passenger2");
        RegularPassenger p3 = new RegularPassenger("Passenger3");
        
        try {
            taxi.boardPassenger(p1);
            taxi.boardPassenger(p2);
            taxi.boardPassenger(p3); // Should throw exception
            assert false : "Should have thrown VehicleFullException";
        } catch (VehicleFullException e) {
            System.out.println("  ✓ VehicleFullException test passed: " + e.getMessage());
        }
    }

    /**
     * Test PassengerNotInVehicleException
     */
    public void testPassengerNotInVehicleException() {
        System.out.println("Testing PassengerNotInVehicleException...");
        Bus bus = new Bus(50);
        RegularPassenger p1 = new RegularPassenger("Passenger1");
        RegularPassenger p2 = new RegularPassenger("Passenger2");
        
        try {
            bus.boardPassenger(p1);
            bus.alightPassenger(p2); // Should throw exception
            assert false : "Should have thrown PassengerNotInVehicleException";
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException";
        } catch (PassengerNotInVehicleException e) {
            System.out.println("  ✓ PassengerNotInVehicleException test passed: " + e.getMessage());
        }
    }

    /**
     * Test Road with multiple vehicles carrying different passenger types
     */
    public void testRoadWithMultipleVehicles() {
        System.out.println("Testing Road with Multiple Vehicles...");
        Road road = new Road();
        
        // Create vehicles with different passenger types
        Bus bus = new Bus(50);
        Taxi taxi = new Taxi(4);
        FireTruck fireTruck = new FireTruck(6);
        PoliceCar policeCar = new PoliceCar(4);
        
        try {
            // Add passengers to bus
            bus.boardPassenger(new RegularPassenger("BusPassenger1"));
            bus.boardPassenger(new RegularPassenger("BusPassenger2"));
            
            // Add passengers to taxi
            taxi.boardPassenger(new RegularPassenger("TaxiPassenger1"));
            taxi.boardPassenger(new Firefighter("TaxiFirefighter"));
            
            // Add passengers to fire truck
            fireTruck.boardPassenger(new Firefighter("Firefighter1"));
            fireTruck.boardPassenger(new Firefighter("Firefighter2"));
            fireTruck.boardPassenger(new Firefighter("Firefighter3"));
            
            // Add passengers to police car
            policeCar.boardPassenger(new PoliceOfficer("Officer1"));
            policeCar.boardPassenger(new PoliceOfficer("Officer2"));
            
            // Add vehicles to road
            road.addCarToRoad(bus);
            road.addCarToRoad(taxi);
            road.addCarToRoad(fireTruck);
            road.addCarToRoad(policeCar);
            
            // Test getCountOfHumans
            int totalHumans = road.getCountOfHumans();
            int expected = 2 + 2 + 3 + 2; // bus + taxi + fireTruck + policeCar
            assert totalHumans == expected : 
                "Expected " + expected + " humans, but got " + totalHumans;
            
            System.out.println("  ✓ Road test passed: Total humans = " + totalHumans);
            
        } catch (VehicleFullException e) {
            assert false : "Should not throw VehicleFullException: " + e.getMessage();
        }
    }
}

