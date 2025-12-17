package test.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import test.test1.modele.Client;

import java.io.IOException;

public class PageConnexion {

    @FXML
    private TextField fieldNom;

    @FXML
    private Label labelMessage;

    @FXML
    private void onSeConnecter(ActionEvent event) throws IOException {
        String nom = fieldNom.getText().trim();

        if (nom.isEmpty()) {
            labelMessage.setText("Veuillez entrer un nom.");
            return;
        }

        // Chercher dans l'Agence partagée
        Client client = AgenceContexte.getAgence().trouverClientParNom(nom);

        // Si tu veux accepter même les nouveaux noms :
        if (client == null) {
            client = new Client(nom, "");
            AgenceContexte.getAgence().ajouterClient(client);
        }

        // Mémoriser le client connecté
        AgenceContexte.setClientConnecte(client);

        // Aller à la page des voyages
        chargerPageVoyages(event);
    }

    private void chargerPageVoyages(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageVoyages.fxml"));
        Pane newRoot = loader.load();

        Node source = (Node) event.getSource();
        source.getScene().setRoot(newRoot);
    }
}
