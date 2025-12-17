package test.test1.modele;

import java.util.ArrayList;
import java.util.List;


public class Voyage implements Facturable {

    private String nom;
    private String destination;
    private double prix;
    private String desc;

    public Voyage(String nom, String destination, double prix, String desc) {
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
        this.desc = desc;
    }


    public String getDesc() {
        return desc;
    }

    public String getNom() {
        return nom;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        // ce sera affiché dans la ListView
        return nom + " - " + destination + " (" + prix + "€)";
    }

    @Override
    public double calculerPrixTotal() {
        return prix;
    }

    @Override
    public String genererFacture() {
        return "Facture voyage : " + calculerPrixTotal() + "€.";
    }


    public static List<Voyage> voyagesParDefaut() {
        List<Voyage> list = new ArrayList<>();
        list.add(new Voyage("France", "Japon", 1229, "Un voyage entre tradition et modernité, où l’on passe des temples anciens et jardins zen aux grandes villes animées comme Tokyo. C’est l’occasion de découvrir une culture très différente, une gastronomie unique et un mode de vie mêlant respect des traditions et technologies de pointe."));
        list.add(new Voyage("France", "Laos", 1459, "Un voyage calme et dépaysant au cœur de l’Asie du Sud-Est. Le Laos se distingue par ses paysages naturels, ses temples bouddhistes et son rythme de vie paisible. C’est une destination idéale pour découvrir une culture authentique, proche de la nature et des traditions."));
        list.add(new Voyage("(TOUT COMPRIS) France", "Irlande", 5999, "Circuit Légendes d'Irlande + extension Irlande du Nord\n" +
                "J1 FRANCE / DUBLIN\n" +
                "Prise en charge de votre région ou de votre domicile NB et transfert vers l’aéroport (en option). Envol pour l’Irlande et Dublin. Transfert vers l’hôtel.\n" +
                "Travelodge Plus 3*\n" +
                "J2 DUBLIN / COMTE DE KERRY\n" +
                "Petit-déjeuner, déjeuner et dîner\n" +
                "Après la visite du musée national abritant d’immenses trésors datant de 7000 avant J-C, direction Cahir et découverte de son très beau château, certainement l’un des plus grands d’Irlande, perché sur un aplomb rocheux. Continuation vers le comté du Kerry.\n" +
                "Brandon 3*\n" +
                "\n" +
                "J3 COMTE DE KERRY\n" +
                "Petit-déjeuner et dîner\n" +
                "Découverte de l’Anneau de Kerry, une magnifique route panoramique où se succèdent de nombreux petits villages typiques avec arrêts à différents très beaux points de vue. Vous poursuivez avec les très beaux jardins de Muckross House réputés dans le monde entier.\n" +
                "Brandon 3*\n" +
                "\n" +
                "J4 COMTE DE KERRY / COMTE DE CLARE\n" +
                "Petit-déjeuner et déjeuner\n" +
                "Découverte de la péninsule de Dingle à l’envoutante beauté rude et sauvage.  Arrêt et temps libre à Dingle puis route vers Slea Head pour une vue panoramique sur les îles Blasket. Visite de l’Oratoire de Gallarus du IXe siècle et balade sur la magnifique plage de Inch.\n" +
                "George 3*\n" +
                "J5 COMTE DE CLARE / COMTE DE GALWAY\n" +
                "Petit-déjeuner et dîner\n" +
                "Vous sillonnez le comté de Clare avec ses étranges paysages lunaires de la région du Burren. Visite du monastère de Kilmacduagh puis arrêt au dolmen de Poulnabrone datant d’environ 4000 ans av JC. Cet après-midi, balade le long des immenses falaises de Moher.\n" +
                "Shearwater 4*\n" +
                "\n" +
                "J6 COMTE DE GALWAY\n" +
                "Petit-déjeuner, déjeuner et dîner\n" +
                "Une journée complète à la découverte du Connemara, la région la plus sauvage d’Irlande avec ses splendides paysages de montagnes, de lacs et de tourbières. Arrêt à l’Abbaye de Kylemore avant de poursuivre vers Galway qui a conservé tout son charme médiéval.\n" +
                "Shearwater 4*\n" +
                "\n" +
                "J7 COMTE DE GALWAY / DUBLIN\n" +
                "\n" +
                "Petit-déjeuner\n" +
                "Visite d’un musée-distillerie de whiskey avec dégustation avant le tour panoramique de Dublin : Grafton Street, les élégantes places géorgiennes aux portes multicolores, Trinity College… Temps libre pour flâner dans le quartier animé de Temple Bar. En option, soirée et dîner dans un pub typiquement irlandais, \n" +
                "le Merry Ploughboy, ou similaire : 100 € par personne (1)\n" +
                "Travelodge Plus 3*\n" +
                "\n" +
                "J8 DUBLIN / BELFAST\n" +
                "Petit-déjeuner\n" +
                "Route vers l’Irlande du Nord et Belfast, une ville vivante et cosmopolite, au passé turbulent. Après-midi libre pour une découverte personnelle. En option, visite du Titanic et tour panoramique de Belfast : 90€ (1) (minimum 4 inscrits)\n" +
                "Holiday Inn 3*\n" +
                "J9 BELFAST / COMTE DE DERRY\n" +
                "Petit-déjeuner et dîner\n" +
                "Ce matin, vous longez la côte d’Antrim en empruntant la magnifique « Causeway Coastal Route ». Visite du fabuleux site classé par l’UNESCO de la Chaussée de Géants avant de poursuivre vers Derry. Découverte de cette ville fortifiée datant VIème siècle. \n" +
                "Best Western White Horse 3*\n" +
                "J10 COMTE DE DERRY / COMTE D’ARMAGH\n" +
                "Petit-déjeuner, déjeuner de spécialités à la ferme et dîner\n" +
                "Départ vers la ferme Glenshane pour vivre une expérience insolite « la vie d’un berger irlandais ». Démonstration de chiens de bergers et de tonte de moutons. Continuation avec une balade en bateau sur la rivière Bann jusqu’à Church Island pour ses vestiges monastiques.\n" +
                "City Hotel Armagh 3*\n" +
                "J11 COMTE D’ARMAGH / DUBLIN\n" +
                "Petit-déjeuner\n" +
                "Visite de la cidrerie « Long Meadow Cider » avec dégustation avant de poursuivre vers Newcastle. Découverte personnelle de cette charmante ville côtière cernée par les belles montagnes Mourne. Retour à Dublin via la visite de l’ancien site monastique, Monasterboice.\n" +
                "Travelodge Plus 3*\n" +
                "J12 DUBLIN / FRANCE\n" +
                "Petit-déjeuner\n" +
                "Selon vos horaires de vol, transfert à l’aéroport et envol vers la France. A votre arrivée, transfert vers votre ville de départ (si l’option a été souscrite)."));
        list.add(new Voyage("Voyage Personnalisé", "Destination à choisir", 0, "Choisissez votre voyage de rêve avec CLIMAgence !"));
        return list;
    }
}
