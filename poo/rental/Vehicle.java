package poo.rental;

public class Vehicle {
    private String modele;
    private Integer year;
    private Integer beforeSell;

    public Vehicle(String modele, Integer year) {
        this.modele = modele;
        this.year = year;
    }

    public String getModele() {
        return modele;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getBeforeSell() {
        return beforeSell;
    }

    public void setBeforeSell(Integer beforeSell) {
        this.beforeSell = beforeSell;
    }
}
