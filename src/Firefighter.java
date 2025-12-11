/**
 * Represents a firefighter passenger
 */
public class Firefighter extends Human {
    public Firefighter(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Firefighter{name='" + getName() + "'}";
    }
}

