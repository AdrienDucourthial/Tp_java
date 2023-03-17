package poo.rental;

public class Camel extends Vehicle {


    public Camel(Integer year) {
        super("", year);
        setBeforeSell(5);
    }

    public String toString() {
        return "camel " + getYear();
    }
}
