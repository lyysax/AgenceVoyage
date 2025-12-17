package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;

public class PageVoyageDetails {

    @FXML
    private Label labelNom;

    @FXML
    private Label labelDestination;

    @FXML
    private Label labelPrix;

    @FXML
    private Label labelDesc;

    private Pane previousRoot;

    public void setVoyage(Voyage voyage) {
        if (voyage == null) return;

        labelNom.setText("Nom du voyage : " + voyage.getNom() + " - " + voyage.getDestination());
        labelDestination.setText("Destination : " + voyage.getDestination());
        labelPrix.setText("Prix : " + voyage.getPrix() + " €");
        labelDesc.setText("Description : " + voyage.getDesc());
    }

    public void setPreviousRoot(Pane previousRoot) {
        this.previousRoot = previousRoot;
    }

    @FXML
    private void onRetour() {
        if (previousRoot == null) return;

        Stage stage = (Stage) ((Node) labelNom).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }
}
