package test.test1.modele;

public class Vol {

    private String compagnie;
    private String numeroVol;
    private String aeroportDepart;
    private String aeroportArrivee;
    private String dateDepart;   // pour l’instant en String, tu pourras passer à LocalDateTime
    private String dateArrivee;
    private double prix;
    private int placesDisponibles;

    public Vol(String compagnie, String numeroVol,
               String aeroportDepart, String aeroportArrivee,
               String dateDepart, String dateArrivee,
               double prix, int placesDisponibles) {
        this.compagnie = compagnie;
        this.numeroVol = numeroVol;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prix = prix;
        this.placesDisponibles = placesDisponibles;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public String getAeroportDepart() {
        return aeroportDepart;
    }

    public String getAeroportArrivee() {
        return aeroportArrivee;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public String getDateArrivee() {
        return dateArrivee;
    }

    public double getPrix() {
        return prix;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public boolean aDesPlacesDisponibles() {
        return placesDisponibles > 0;
    }

    public void reserverPlace() {
        if (placesDisponibles > 0) {
            placesDisponibles--;
        }
    }

    @Override
    public String toString() {
        return compagnie + " " + numeroVol + " - " +
                aeroportDepart + " → " + aeroportArrivee +
                " (" + prix + "€)";
    }
}
