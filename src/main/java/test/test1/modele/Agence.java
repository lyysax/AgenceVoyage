package test.test1.modele;

import java.util.ArrayList;
import java.util.List;

public class Agence {

    private String nom;
    private List<String> voyages; // simplifié pour le test JavaFX

    public Agence(String nom) {
        this.nom = nom;
        this.voyages = new ArrayList<>();
        // données de test
        voyages.add("Circuit Bali 7j");
        voyages.add("Séjour Bali 10j");
        voyages.add("Du Bled à Bali - All Inclusive");
    }

    public String getNom() {
        return nom;
    }

    public List<String> getVoyages() {
        return voyages;
    }
}
