
import org.hibernate.*;
import java.util.*;

public class LivreEditeurAppli {

    public static void main(String[] args) {

        // Une première session Hibernate qui insère éditeurs et livres
        System.out.println();
        System.out.println("Une premiere session Hibernate et livres");

        Session uneSession = HibernateUtil1.getSessionFactory().openSession();
        Transaction uneTransaction = uneSession.beginTransaction();

      Editeur editeurUn = new Editeur("Actes Sud","Arles");
      Editeur editeurDeux = new Editeur("Jeanne Lafitte","Marseille");
          Livre LivreUn = new Livre("978-2-7427-7688-7","La Reconstruction",
2008,editeurUn);
          editeurUn.getLesLivres().add(LivreUn);
          Livre LivreDeux = new Livre("978-2-7427-7714-3","La Magie du costume",2008,editeurUn);
          editeurUn.getLesLivres().add(LivreDeux);
          Livre LivreTrois = new Livre("978-2-7427-7705-1","Zone",2008,editeurUn);
          editeurUn.getLesLivres().add(LivreTrois);
   Livre LivreQuatre = new Livre("978-2-7427-6953-7","La Princesse et le "
+ " pêcheur",2008,editeurUn);
          editeurUn.getLesLivres().add(LivreQuatre);
          Livre LivreCinq = new Livre("978-2-7427-6953-8","Saint Victor",2008,editeurDeux);
          editeurDeux.getLesLivres().add(LivreCinq);
      uneSession.save(editeurUn);
      uneSession.save(editeurDeux);

        uneTransaction.commit();
        uneSession.close();


        // Une deuxième session Hibernate qui lit les données de la première 
	// session et les affiche
        System.out.println();
 System.out.println("deuxieme session qui lit les donnees de session 1 et les affiche");

        uneSession = HibernateUtil1.getSessionFactory().openSession();
        uneTransaction = uneSession.beginTransaction();

        List lesEditeurs =
            uneSession.createQuery("from Editeur e order by e.nomEditeur asc").list();

        System.out.println( lesEditeurs.size() + " editeurs trouves:" );

        for ( Iterator iterEditeurs = lesEditeurs.iterator(); iterEditeurs.hasNext(); ) {
            Editeur unEditeurCharge = (Editeur) iterEditeurs.next();
            System.out.println("Editeur:"+ unEditeurCharge.getNomEditeur() );
                System.out.println("Livres de l'editeur:" );

                for ( Iterator iterLivres = 
 unEditeurCharge.getLesLivres().iterator(); iterLivres.hasNext(); ) {
                Livre unLivreCharge = (Livre) iterLivres.next();
                System.out.println("   "+unLivreCharge.getTitre() );
  }
        }

        uneTransaction.commit();
        uneSession.close();


        // Arrêt de l'application Hibernate
        HibernateUtil1.shutdown();
    }
}