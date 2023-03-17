package poo.rental;

public class Vehicle {
    private String modele;
    private Integer year;
    private Integer beforeSell;

    public Vehicle(String modele, Integer year) {
        if (modele == null) {
            throw new NullPointerException("No modele given");
        }
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
    @Override
    public boolean equals(Object o) {
        if (o instanceof Vehicle) {
            if (((Vehicle) o).modele == this.modele && (int)((Vehicle) o).year == (int)this.year) {
                return true;
            }
        }
        return false;
    }
}
