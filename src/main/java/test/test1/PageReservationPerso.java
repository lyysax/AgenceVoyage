package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Voyage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PageReservationPerso {

    @FXML
    private TextField tfEmail;

    @FXML
    private ComboBox<String> cbPays;

    @FXML
    private ComboBox<Integer> cbNbPersonnes;

    @FXML
    private ComboBox<String> cbActivites;

    @FXML
    private TextArea taRemarques;

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
        cbPays.getItems().addAll("Belgique", "Colombie", "Cuba", "Espagne" , "Italie", "Pérou", "Portugal", "Royaume-Uni");
        for (int i = 1; i <= 10; i++) {
            cbNbPersonnes.getItems().add(i);
        }
        cbActivites.getItems().addAll(
                "Visite guidée",
                "Randonnée",
                "Plage",
                "Musées",
                "Gastronomie"
        );

        cbPays.getSelectionModel().selectFirst();
        cbNbPersonnes.getSelectionModel().select(Integer.valueOf(1));
        cbActivites.getSelectionModel().selectFirst();
    }

    @FXML
    private void onRetour() {
        if (previousRoot == null) return;

        Stage stage = (Stage) ((Node) tfEmail).getScene().getWindow();
        stage.getScene().setRoot(previousRoot);
    }

    @FXML
    private void onValider() {
        String email = tfEmail.getText();
        String pays = cbPays.getValue();
        Integer nbPers = cbNbPersonnes.getValue();
        String activite = cbActivites.getValue();
        String remarques = taRemarques.getText();

        System.out.println("=== Réservation voyage personnalisé ===");
        System.out.println("Voyage : " + (voyage != null ? voyage.getNom() : "?"));
        System.out.println("Email : " + email);
        System.out.println("Pays choisi : " + pays);
        System.out.println("Nombre de personnes : " + nbPers);
        System.out.println("Activité : " + activite);
        System.out.println("Remarques : " + remarques);
        System.out.println("=======================================");

        // Fenêtre d'information pour l'utilisateur
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informations sur le prix");
        alert.setHeaderText(null); // pas de gros titre au-dessus
        alert.setContentText(
                "Pour plus d'informations sur le prix du voyage,\n" +
                        "contactez l'agence CLIM."
        );
        alert.showAndWait();
    }
}
