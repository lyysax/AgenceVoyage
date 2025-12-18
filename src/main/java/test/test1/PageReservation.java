package test.test1;

import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Facturable;
import test.test1.modele.Voyage;
import javafx.scene.control.ComboBox;

public class PageReservation implements Facturable {

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
    private int nbPersonnes = 1;

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

        cbNbPersonnes.setOnAction(e -> nbPersonnes = cbNbPersonnes.getValue());
    }

    @FXML
    private void onRetour() {
        if (previousRoot == null) return;

        Stage stage = (Stage) ((Node) tfEmail).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }


    @FXML
    private Label Resume;

    @FXML
    private void onValider() {
        Integer nbPers = cbNbPersonnes.getValue();  // valeur choisie dans le menu

        String recap = "Réservation pour le voyage : "
                + (voyage != null ? voyage.getNom() + " " + voyage.getDestination() : "?")
                + ", \n email = " + tfEmail.getText()
                + ", \n nombre de personnes = " + nbPers
                + ", \n" + genererFacture();

        Resume.setText(recap);
    }

    @Override
    public double calculerPrixTotal() {
        return voyage.getPrix() * cbNbPersonnes.getValue();
    }

    @Override
    public String genererFacture() {
        return "Prix du voyage : " + calculerPrixTotal();
    }
}
