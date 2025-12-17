package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;

public class PageReservation {

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfContract;

    @FXML
    private TextField tfProblem;

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
    private void onRetour() {
        if (previousRoot == null) return;

        Stage stage = (Stage) ((Node) tfEmail).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }

    @FXML
    private void onValider() {
        // Pour l’instant on affiche juste dans la console
        System.out.println("Réservation pour le voyage : "
                + (voyage != null ? voyage.getNom() : "?")
                + ", email = " + tfEmail.getText());
    }
}
