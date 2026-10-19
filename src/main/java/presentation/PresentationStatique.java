package presentation;

import dao.DaoIMP;
import metier.MetierIMP;

public class PresentationStatique {

    public static void main(String[] args) {
        // Instanciation statique : classes concrètes écrites en dur
        DaoIMP dao = new DaoIMP();
        MetierIMP metier = new MetierIMP();

        // Injection de la dépendance via le setter
        metier.setDao(dao);

        System.out.println("Résultat = " + metier.calcul());
    }
}