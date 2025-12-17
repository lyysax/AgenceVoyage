package test.test1.modele;

import java.util.ArrayList;
import java.util.List;

public class Destination {

    private String pays;
    private String ville;
    private String description;

    // >>> NOUVEAU : les hôtels de cette destination
    private List<Hotel> hotels = new ArrayList<>();

    public Destination(String pays, String ville,
                       String description, boolean visaRequis) {
        this.pays = pays;
        this.ville = ville;
        this.description = description;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getDescription() {
        return description;
    }

    // >>> NOUVEAU
    public void ajouterHotel(Hotel hotel) {
        if (hotel != null && !hotels.contains(hotel)) {
            hotels.add(hotel);
        }
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public String toString() {
        return ville + ", " + pays;
    }
}

