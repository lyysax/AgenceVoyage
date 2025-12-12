package test.test1.modele;

import java.util.ArrayList;
import java.util.List;

public class Agence {

    private String nom;
    private List<Voyage> voyages; // simplifié pour le test JavaFX

    public Agence(String nom) {
        this.nom = nom;
        this.voyages = new ArrayList<>();
        // données de test
        voyages.add(new Voyage("Circuit Bali 7j", "Bali", 1299.0));
        voyages.add(new Voyage("Séjour Bali 10j", "Bali", 1599.0));
        voyages.add(new Voyage("Du Bled à Bali - All Inclusive", "Bali", 1899.0));
    }

    public String getNom() {
        return nom;
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }
}
