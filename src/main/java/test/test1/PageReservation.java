package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;
import javafx.scene.control.ComboBox;

public class PageReservation {

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfContract;

    @FXML
    private ComboBox<Integer> cbNbPersonnes;

    @FXML
    private TextArea taDescription;

    private Pane previousRoot;
    private Voyage voyage;

    public void setPreviousRoot(Pane previousRoot) {
        this.previousRoot = previousRoot;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    @FXML
    private void initialize() {
        // Ajouter les nombres 1 à 10 dans le menu déroulant
        for (int i = 1; i <= 10; i++) {
            cbNbPersonnes.getItems().add(i);
        }

        // Sélectionner 1 par défaut
        cbNbPersonnes.getSelectionModel().select(Integer.valueOf(1));
    }

    @FXML
    private void onRetour() {
        if (previousRoot == null) return;

        Stage stage = (Stage) ((Node) tfEmail).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }

    @FXML
    private void onValider() {
        Integer nbPers = cbNbPersonnes.getValue();  // valeur choisie dans le menu

        System.out.println("Réservation pour le voyage : "
                + (voyage != null ? voyage.getNom() + " " + voyage.getDestination() : "?")
                + ", email = " + tfEmail.getText()
                + ", nombre de personnes = " + nbPers);
    }
}
