package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;

public class VoyageDetailController {

    @FXML
    private Label labelNom;

    @FXML
    private Label labelDestination;

    @FXML
    private Label labelPrix;

    // root de la page précédente (hello-view) à réafficher
    private Pane previousRoot;

    public void setVoyage(Voyage voyage) {
        if (voyage == null) return;

        labelNom.setText("Nom du voyage : " + voyage.getNom());
        labelDestination.setText("Destination : " + voyage.getDestination());
        labelPrix.setText("Prix : " + voyage.getPrix() + " €");
    }

    // appelé depuis HelloController
    public void setPreviousRoot(Pane previousRoot) {
        this.previousRoot = previousRoot;
    }

    @FXML
    private void onRetour() {
        if (previousRoot == null) return;

        // récupérer la scène actuelle via n'importe quel noeud (ici labelNom)
        Stage stage = (Stage) ((Node) labelNom).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }
}
