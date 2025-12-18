package test.test1.modele;

import java.util.ArrayList;
import java.util.List;

public class Destination {

    private String pays;
    private String description;

    // >>> NOUVEAU : les hôtels de cette destination
    private List<Hotel> hotels = new ArrayList<>();

    public Destination(String pays, String ville,
                       String description) {
        this.pays = pays;
        this.description = description;
    }

    public String getPays() {
        return pays;
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
        return pays;
    }
}

