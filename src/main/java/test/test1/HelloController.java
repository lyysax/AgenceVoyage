package test.test1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Agence;
import test.test1.modele.Voyage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Label labelTitre;

    @FXML
    private ListView<Voyage> listViewVoyages;

    private Agence agence;

    @FXML
    public void initialize() {
        agence = new Agence("CLIMAgence");

        labelTitre.setText(agence.getNom());
        listViewVoyages.getItems().addAll(agence.getVoyages());

        listViewVoyages.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Voyage selected = listViewVoyages.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    afficherDetailsDansMemeFenetre(selected);
                }
            }
        });
    }

    private void afficherDetailsDansMemeFenetre(Voyage voyage) {
        try {
            // root actuel = page de base
            Stage stage = (Stage) listViewVoyages.getScene().getWindow();
            Scene scene = stage.getScene();
            Pane previousRoot = (Pane) scene.getRoot();

            // charger le FXML détail
            FXMLLoader loader = new FXMLLoader(getClass().getResource("voyage-detail.fxml"));
            Pane detailRoot = loader.load();

            // configurer le contrôleur détail
            VoyageDetailController controller = loader.getController();
            controller.setVoyage(voyage);
            controller.setPreviousRoot(previousRoot);

            // remplacer le root de la scène par la page détail
            scene.setRoot(detailRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
