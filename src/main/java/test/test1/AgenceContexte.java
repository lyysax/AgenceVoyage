package test.test1;

import test.test1.modele.Agence;
import test.test1.modele.Client;

public class AgenceContexte {

    // Une seule instance d'Agence partagée partout
    private static final Agence AGENCE = new Agence("CLIMAgence");

    // Le client actuellement connecté
    private static Client clientConnecte;

    public static Agence getAgence() {
        return AGENCE;
    }

    public static Client getClientConnecte() {
        return clientConnecte;
    }

    public static void setClientConnecte(Client client) {
        clientConnecte = client;
    }
}
