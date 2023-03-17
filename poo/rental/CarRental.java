package poo.rental;

import java.time.LocalDate;
import java.util.*;

public class CarRental {
    private Vehicle[] carListe;
    private Integer size;
    private Integer index;

    public CarRental() {
        this.size = 10;
        this.carListe = new Vehicle[this.size];
        this.index = 0;
    }

    public void add(Vehicle v) {
        if (this.index >= this.size) {
            this.size *= 2;
            this.carListe = Arrays.copyOf(this.carListe, this.size);
        }
        this.carListe[index++] = Objects.requireNonNull(v);
    }

    public void remove(Vehicle v) {
        for (int i = 0; i < index; i++) {
            if (this.carListe[i] == v) {
                this.carListe[i] = null;
            }
        }
        var tmp = new Vehicle[this.size];
        int j = 0;
        for (int i = 0; i < index; i++) {
            if (this.carListe[i] != null) {
                tmp[j] = this.carListe[i];
                j++;
            }
        }
        this.carListe = tmp;
        index--;
    }

    public List<Vehicle> toSell() {
        int currentYear = LocalDate.now().getYear();
        List<Vehicle> tosell = new ArrayList<Vehicle>();
        int j = 0;
        for (int i = 0; i < index; i++) {
            if (currentYear - this.carListe[i].getYear() >= this.carListe[i].getBeforeSell()) {
                tosell.add(this.carListe[i]);
                j++;
            }
        }
        return tosell;
    }

    public Optional<Vehicle> findACarByModel(String modele){
        for (int i = 0; i < index; i++) {
            if (this.carListe[i].getModele() == modele) {
                Vehicle car =  this.carListe[i];
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < index; i++) {
            output += this.carListe[i];
            if (i != index-1) {
                output += "\n";
            }
        }
        return output;
    }
}
