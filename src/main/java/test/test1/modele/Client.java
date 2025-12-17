package test.test1.modele;

public class Client {

    private String nom;
    private String numero; // numéro de téléphone

    public Client(String nom, String numero) {
        this.nom = nom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return nom + " (" + numero + ")";
    }
}
