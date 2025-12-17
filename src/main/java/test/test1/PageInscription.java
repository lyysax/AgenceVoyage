package test.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import test.test1.modele.Client;

import java.io.IOException;

public class PageInscription {

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldNumero;

    @FXML
    private Label labelResultat;

    @FXML
    private void onCreerClient(ActionEvent event) throws IOException {
        String nom = fieldNom.getText();
        String numero = fieldNumero.getText();

        if (nom == null || nom.isBlank() || numero == null || numero.isBlank()) {
            labelResultat.setText("Veuillez remplir tous les champs.");
            return;
        }

        // Créer le client
        Client client = new Client(nom, numero);

        // L'ajouter dans l'agence partagée
        AgenceContexte.getAgence().ajouterClient(client);

        // Mémoriser le client actuellement connecté
        AgenceContexte.setClientConnecte(client);

        // Optionnel : message
        labelResultat.setText("Compte créé pour : " + client);

        // Redirection vers la page des voyages
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageVoyages.fxml"));
        Parent voyagesRoot = loader.load();

        Node source = (Node) event.getSource();
        source.getScene().setRoot(voyagesRoot);
    }
}
