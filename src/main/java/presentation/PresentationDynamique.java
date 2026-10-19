package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class PresentationDynamique {

    public static void main(String[] args) throws Exception {
        // Lecture des noms de classes dans config.txt
        InputStream is = PresentationDynamique.class.getResourceAsStream("/config.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String daoClassName = br.readLine();
        String metierClassName = br.readLine();
        br.close();

        // Chargement dynamique des classes
        Class<?> cDao = Class.forName(daoClassName);
        Class<?> cMetier = Class.forName(metierClassName);

        // Création des instances
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        // Injection par réflexion : appel de setDao()
        Method setDao = cMetier.getMethod("setDao", IDao.class);
        setDao.invoke(metier, dao);

        System.out.println("Résultat = " + metier.calcul());
    }
}