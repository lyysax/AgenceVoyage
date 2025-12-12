package test.test1.modele;

public class Voyage implements Facturable {

    private String nom;
    private String destination;
    private double prix;

    public Voyage(String nom, String destination, double prix) {
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        // ce sera affiché dans la ListView
        return nom + " - " + destination + " (" + prix + "€)";
    }

    @Override
    public double calculerPrixTotal() {
        return 0;
    }

    @Override
    public String genererFacture() {
        return "Facture voyage : " + calculerPrixTotal() + "€.";
    }
}
