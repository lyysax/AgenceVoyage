package test.test1.modele;

public class Client {

    private String nom;
    private String email;

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return nom + " <" + email + ">";
    }
}
