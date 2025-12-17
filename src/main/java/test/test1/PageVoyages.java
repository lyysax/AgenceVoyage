package test.test1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Agence;
import test.test1.modele.Client;
import test.test1.modele.Voyage;

import java.io.IOException;

public class PageVoyages {

    @FXML
    private Label labelTitre;

    @FXML
    private ListView<Voyage> listViewVoyages;

    private Agence agence;

    @FXML
    public void initialize() {
        agence = AgenceContexte.getAgence();

        // récupérer le client connecté
        Client client = AgenceContexte.getClientConnecte();
        if (client != null) {
            labelTitre.setText("Client : " + client.getNom());
        }
        // IMPORTANT : pas de else -> si client == null,
        // on laisse le texte mis dans le FXML ("Voyages disponibles")

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
            Stage stage = (Stage) listViewVoyages.getScene().getWindow();
            Scene scene = stage.getScene();
            Pane previousRoot = (Pane) scene.getRoot();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("PageVoyageDetails.fxml"));
            Pane detailRoot = loader.load();

            PageVoyageDetails controller = loader.getController();
            controller.setVoyage(voyage);
            controller.setPreviousRoot(previousRoot);

            scene.setRoot(detailRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
