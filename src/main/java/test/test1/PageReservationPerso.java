package test.test1;

import javafx.scene.control.Label;
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
        hotelsParPays.put("Espagne", List.of(
                new Hotel("Costa del Sol", "Malaga", 3, 90, 20),
                new Hotel("Barcelona Center", "Barcelone", 4, 163, 12),
                new Hotel("Hostal Rambla", "Barcelone", 2, 55, 8),
                new Hotel("Gran Vía Palace", "Madrid", 5, 250, 5),
                new Hotel("Seaside Boutique", "Valence", 4, 140, 10)
        ));

        hotelsParPays.put("Italie", List.of(
                new Hotel("Albergo Roma", "Rome", 3, 80, 18),
                new Hotel("Canal View", "Venise", 4, 190, 6),
                new Hotel("Duomo Guesthouse", "Milan", 2, 60, 12),
                new Hotel("Palazzo Storico", "Florence", 5, 220, 4),
                new Hotel("Ligurian Inn", "Gênes", 3, 75, 14)
        ));

        hotelsParPays.put("Belgique", List.of(
                new Hotel("Brussels Central", "Bruxelles", 4, 150, 9),
                new Hotel("Petit Sablon", "Bruxelles", 3, 95, 11),
                new Hotel("Canal Corner", "Anvers", 2, 65, 16),
                new Hotel("Ghent Grand", "Gand", 5, 210, 3),
                new Hotel("Liège Comfort", "Liège", 3, 85, 10)
        ));

        hotelsParPays.put("Portugal", List.of(
                new Hotel("Lisbon Horizon", "Lisbonne", 4, 145, 10),
                new Hotel("Porto Riverside", "Porto", 3, 88, 15),
                new Hotel("Algarve Sunset", "Faro", 5, 230, 6),
                new Hotel("Cozy Braga", "Braga", 2, 50, 20),
                new Hotel("Madeira Retreat", "Funchal", 4, 170, 7)
        ));

        hotelsParPays.put("Colombie", List.of(
                new Hotel("Bogotá Plaza", "Bogota", 4, 120, 10),
                new Hotel("Medellín Suites", "Medellín", 3, 75, 14),
                new Hotel("Cartagena Colonial", "Cartagena", 5, 200, 5),
                new Hotel("Cali Comfort", "Cali", 2, 40, 20),
                new Hotel("Zona Rosa Inn", "Bogota", 3, 68, 12)
        ));

        hotelsParPays.put("Cuba", List.of(
                new Hotel("Habana Vieja", "La Havane", 4, 110, 9),
                new Hotel("Varadero Beach", "Varadero", 5, 210, 6),
                new Hotel("Trinidad Hostal", "Trinidad", 2, 45, 16),
                new Hotel("Santiago Colonial", "Santiago de Cuba", 3, 70, 12),
                new Hotel("Cienfuegos Bay", "Cienfuegos", 3, 65, 11)
        ));

        hotelsParPays.put("Pérou", List.of(
                new Hotel("Lima Miraflores", "Lima", 4, 130, 10),
                new Hotel("Cusco Heritage", "Cusco", 5, 210, 4),
                new Hotel("Arequipa Comfort", "Arequipa", 3, 80, 14),
                new Hotel("Puno Lakeview", "Puno", 2, 50, 18),
                new Hotel("Sacred Valley Lodge", "Urubamba", 4, 150, 7)
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
    private Label ResumePerso;
    @FXML
    private void onValider() {
        String email = tfEmail.getText();
        String pays = cbPays.getValue();
        Integer nbPers = cbNbPersonnes.getValue();
        String activite = cbActivites.getValue();
        Hotel hotel = cbHotel.getValue();
        String remarques = taRemarques.getText();

        String recap =
                "=== Réservation voyage personnalisé ===\n" +
                        "Voyage : " + (voyage != null ? voyage.getNom() : "?") + "\n" +
                        "Email : " + email + "\n" +
                        "Pays choisi : " + pays + "\n" +
                        "Nombre de personnes : " + nbPers + "\n" +
                        "Activité : " + activite + "\n" +
                        "Hôtel choisi : " +
                        (hotel != null ? hotel.getNom() + " (" + hotel.getEtoiles() + "★)" : "aucun") + "\n" +
                        "Remarques : " + remarques + "\n" +
                        "=======================================";


        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informations sur le prix");
        alert.setHeaderText(null);
        alert.setContentText(
                "Vous allez recevoir un mail de CLIMAgence d'ici 24 heures \n pour le prix du voyage."
        );
        ResumePerso.setText(recap);
        alert.showAndWait();
    }
}
