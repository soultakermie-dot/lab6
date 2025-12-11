/**
 * Represents a regular passenger
 */
public class RegularPassenger extends Human {
    public RegularPassenger(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "RegularPassenger{name='" + getName() + "'}";
    }
}

