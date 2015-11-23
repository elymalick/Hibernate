import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;;

public class PremierTest {
	Session uneSession = null;
    // configuration: parametres + mapping
    public Configuration config = null;

    // Usine a  fabriquer des sessions
    public SessionFactory factory = null;

    PremierTest() {
        // par defaut hibernate.cfg.xml est utilise
        config = new Configuration();
        config.configure();
        factory = config.buildSessionFactory();
       // uneSession =factory.openSession();
        

    }

    // les methodes 
    // lire dans la base
    public void readPersonne(int key) {
    	uneSession =factory.openSession();
    	Transaction uneTransaction = uneSession.beginTransaction();
        Person p = new Person();
        uneSession.load(p, key);
        System.out.println("Lecture de " + p.toString());
        uneTransaction.commit();
        uneSession.close();
    }
    
//  les methodes 
    // utiliser HQL
    public void readPersons(int ageMin) {
    	uneSession =factory.openSession();
    	Transaction uneTransaction = uneSession.beginTransaction();
        List persons = uneSession.createQuery(
                "from Person as p where p.age >= :ageMin").
                    setInteger("ageMin", ageMin).
                    list();
        for (Object o : persons) {
            System.out.println("liste " + o);
        }
        uneTransaction.commit();
        uneSession.close();
    }
    public void readPersons(String ville) {
    	uneSession =factory.openSession();
    	Transaction uneTransaction = uneSession.beginTransaction();
        List persons = uneSession.createQuery(
                "from Person as p where p.ville like :ville").
                    setString("ville", ville).
                    list();
        for (Object o : persons) {
            System.out.println("liste " + o);
        }
        uneTransaction.commit();
        uneSession.close();
    }
    // sauvegarder des instances
    public Person addPerson(String fname, String lname, String town, int age) {
          
        uneSession =factory.openSession();
    	Transaction uneTransaction = uneSession.beginTransaction();
    	 Person p = new Person(fname, lname, town, age);
        uneSession.save(p);
        System.out.println("Ajout de " + p);
        uneTransaction.commit();
        uneSession.close();
        return (p);
    }
    
    
    public static void main(String[] args) {
        try {
            PremierTest ex1 = new PremierTest();
            System.out.println("Debut Lecture dans la base");
            // appels aux methodes
            ex1.readPersonne(1);
            System.out.println("Fin Lecture  dans la base");
            System.out.println("Debut Lecture HQL dans la base");
            ex1.readPersons("Montpellier");
            System.out.println("Fin Lecture HQL dans la base");
            System.out.println("Debut insertion dans la base");
            ex1.addPerson("Polignac","Paule","Agde",29);
            System.out.println("Fin insertion dans la base");
            System.out.println("Debut Lecture HQL dans la base");
            ex1.readPersons(20);
            System.out.println("Fin Lecture HQL dans la base");
        } catch (Exception e) {
            System.err.println("Main error : " + e);
            e.printStackTrace();
        }
    }

}
