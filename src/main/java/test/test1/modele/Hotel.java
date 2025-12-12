package test.test1.modele;

public class Hotel {

    private String nom;
    private String ville;
    private int etoiles;          // 1 à 5
    private double prixParNuit;   // en euros
    private int nbChambresDispo;

    public Hotel(String nom, String ville, int etoiles,
                 double prixParNuit, int nbChambresDispo) {
        this.nom = nom;
        this.ville = ville;
        this.etoiles = etoiles;
        this.prixParNuit = prixParNuit;
        this.nbChambresDispo = nbChambresDispo;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public int getNbChambresDispo() {
        return nbChambresDispo;
    }

    public void reserverChambre() {
        if (nbChambresDispo > 0) {
            nbChambresDispo--;
        }
    }

    public boolean aDesChambresDisponibles() {
        return nbChambresDispo > 0;
    }

    @Override
    public String toString() {
        return nom + " (" + etoiles + "★, " + ville + ") - " + prixParNuit + "€ / nuit";
    }
}
