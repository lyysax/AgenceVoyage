package test.test1.modele;

public class Destination {

    private String pays;
    private String ville;
    private String description;

    public Destination(String pays, String ville,
                       String description, boolean visaRequis) {
        this.pays = pays;
        this.ville = ville;
        this.description = description;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return ville + ", " + pays;
    }
}
