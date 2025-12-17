package test.test1.modele;

import java.util.ArrayList;
import java.util.List;

public class Agence {

    private String nom;
    private List<Voyage> voyages;
    private List<Client> clients;// <<< liste de clients

    public Agence(String nom) {
        this.nom = nom;
        this.voyages = new ArrayList<>();
        this.clients = new ArrayList<>();

        voyages.addAll(Voyage.voyagesParDefaut());
    }

    public String getNom() {
        return nom;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void ajouterClient(Client client) {
        if (client != null && !clients.contains(client)) {
            clients.add(client);
        }
    }

    public Client trouverClientParNom(String nom) {
        for (Client c : clients) {
            if (c.getNom().equalsIgnoreCase(nom)) {
                return c;
            }
        }
        return null;
    }
}
