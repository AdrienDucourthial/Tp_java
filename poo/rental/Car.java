package poo.rental;

public class Car extends Vehicle {

    public Car(String modele, Integer year) {
        super(modele, year);
        setBeforeSell(2);
    }

    public String toString() {
        return getModele() + " " + getYear();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
