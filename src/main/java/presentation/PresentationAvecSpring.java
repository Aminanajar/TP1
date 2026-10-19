package presentation;

import dao.IDao;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationAvecSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        IDao dao = context.getBean("dao", IDao.class);
        IMetier metier = context.getBean("metier", IMetier.class);

        System.out.println("Résultat = " + metier.calcul());
    }
}