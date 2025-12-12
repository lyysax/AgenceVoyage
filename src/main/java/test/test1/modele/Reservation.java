package test.test1.modele;

public class Reservation {

    private Client client;
    private Voyage voyage;

    public Reservation(Client client, Voyage voyage) {
        this.client = client;
        this.voyage = voyage;
    }

    public Client getClient() {
        return client;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    @Override
    public String toString() {
        return "Reservation de " + client.getNom() + " pour " + voyage.getNom();
    }
}
