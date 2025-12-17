package test.test1;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import test.test1.modele.Destination;
import test.test1.modele.Hotel;
import test.test1.modele.Voyage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private ComboBox<Hotel> cbHotel;

    @FXML
    private TextArea taRemarques;

    private Pane previousRoot;
    private Voyage voyage;
    private Map<String, List<Hotel>> hotelsParPays = new HashMap<>();

    public void setPreviousRoot(Pane previousRoot) {
        this.previousRoot = previousRoot;
    }

    // UNE SEULE méthode setVoyage
    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;

        if (voyage != null && voyage.getDestinationObjet() != null) {
            Destination dest = voyage.getDestinationObjet();
            cbHotel.getItems().setAll(dest.getHotels());
            if (!dest.getHotels().isEmpty()) {
                cbHotel.getSelectionModel().selectFirst();
            }
        }
    }

    @FXML
    private void initialize() {
        cbPays.getItems().addAll(
                "Belgique", "Colombie", "Cuba",
                "Espagne", "Italie", "Pérou",
                "Portugal", "Royaume-Uni"
        );
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
        initialiserHotelsParPays();

        cbPays.setOnAction(event -> mettreAJourHotels());

        cbPays.getSelectionModel().selectFirst();
        cbNbPersonnes.getSelectionModel().select(Integer.valueOf(1));
        cbActivites.getSelectionModel().selectFirst();

        mettreAJourHotels();
    }

    private void initialiserHotelsParPays() {
        hotelsParPays.put("Cuba", List.of(
                new Hotel("Habana Libre", "La Havane", 4, 120, 15),
                new Hotel("Varadero Beach Resort", "Varadero", 5, 180, 10)
        ));

        hotelsParPays.put("Espagne", List.of(
                new Hotel("Costa del Sol", "Malaga", 3, 90, 20),
                new Hotel("Barcelona Center", "Barcelone", 4, 130, 12)
        ));

        hotelsParPays.put("Italie", List.of(
                new Hotel("Roma Centro", "Rome", 4, 140, 18),
                new Hotel("Venezia Canal View", "Venise", 5, 200, 8)
        ));

        hotelsParPays.put("Belgique", List.of(
                new Hotel("Roma Centro", "Rome", 4, 140, 18),
                new Hotel("Venezia Canal View", "Venise", 5, 200, 8)
        ));
        hotelsParPays.put("Portugal", List.of(
                new Hotel("Roma Centro", "Rome", 4, 140, 18),
                new Hotel("Venezia Canal View", "Venise", 5, 200, 8)
        ));
        hotelsParPays.put("Royaume-Unis", List.of(
                new Hotel("Roma Centro", "Rome", 4, 140, 18),
                new Hotel("Venezia Canal View", "Venise", 5, 200, 8)
        ));
    }

    private void mettreAJourHotels() {
        String paysChoisi = cbPays.getValue();   // pays sélectionné
        cbHotel.getItems().clear();              // on vide la liste actuelle

        List<Hotel> hotels = hotelsParPays.get(paysChoisi);  // on récupère les hôtels du pays
        if (hotels != null && !hotels.isEmpty()) {
            cbHotel.getItems().addAll(hotels);              // on ajoute les hôtels au ComboBox
            cbHotel.getSelectionModel().selectFirst();      // on sélectionne le 1er par défaut
        }
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
        Hotel hotel = cbHotel.getValue();
        String remarques = taRemarques.getText();

        System.out.println("=== Réservation voyage personnalisé ===");
        System.out.println("Voyage : " + (voyage != null ? voyage.getNom() : "?"));
        System.out.println("Email : " + email);
        System.out.println("Pays choisi : " + pays);
        System.out.println("Nombre de personnes : " + nbPers);
        System.out.println("Activité : " + activite);
        System.out.println("Hôtel choisi : "
                + (hotel != null ? hotel.getNom() + " (" + hotel.getEtoiles() + "★)" : "aucun"));
        System.out.println("Remarques : " + remarques);
        System.out.println("=======================================");

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informations sur le prix");
        alert.setHeaderText(null);
        alert.setContentText(
                "Pour plus d'informations sur le prix du voyage,\n" +
                        "contactez l'agence CLIM."
        );
        alert.showAndWait();
    }
}
