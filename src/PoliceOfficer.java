/**
 * Represents a police officer passenger
 */
public class PoliceOfficer extends Human {
    public PoliceOfficer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "PoliceOfficer{name='" + getName() + "'}";
    }
}

