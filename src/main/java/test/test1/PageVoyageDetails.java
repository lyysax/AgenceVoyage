package test.test1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;
import java.io.IOException;

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

    private Voyage voyageCourant;

    public void setVoyage(Voyage voyage) {
        if (voyage == null) return;
        this.voyageCourant = voyage;

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

    @FXML
    private void onReserver() {
        if (voyageCourant == null) {
            return;
        }

        try {
            // vue actuelle (page de détails)
            Pane currentRoot = (Pane) labelNom.getScene().getRoot();

            FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("PageReservation.fxml"));
            Pane reservationRoot = loader.load();

            PageReservation controller = loader.getController();
            controller.setVoyage(voyageCourant);
            controller.setPreviousRoot(currentRoot);

            Stage stage = (Stage) labelNom.getScene().getWindow();
            stage.getScene().setRoot(reservationRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
