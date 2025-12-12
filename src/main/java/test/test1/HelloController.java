package test.test1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import test.test1.modele.Agence;

public class HelloController {

    @FXML
    private Label labelTitre;

    @FXML
    private ListView<String> listViewVoyages;

    private Agence agence;

    @FXML
    public void initialize() {
        // créer l'agence et charger les données
        agence = new Agence("Du Bled à Bali");

        labelTitre.setText("Voyages disponibles - " + agence.getNom());
        listViewVoyages.getItems().setAll(agence.getVoyages());
    }
}
