package test.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PageAccueil {

    @FXML
    private void onInscription(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageInscription.fxml"));
        Pane newRoot = loader.load();

        Node source = (Node) event.getSource();
        source.getScene().setRoot(newRoot);
    }

    @FXML
    private void onConnexion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageConnexion.fxml"));
        Pane newRoot = loader.load();

        Node source = (Node) event.getSource();
        source.getScene().setRoot(newRoot);
    }

    private void changerVue(ActionEvent event, String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Pane newRoot = loader.load();

        Node source = (Node) event.getSource();
        source.getScene().setRoot(newRoot);
    }
}
