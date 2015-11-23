
public class Livre {
	
	  // variables instances
    private String          ISBN ;
    private String          titre ;
    private int     anneeParution ;
private Editeur editeur;

// Constructeur vide requis
public Livre(){}

public Livre(String ISBN, String titre, int anneeParution, Editeur editeur){
this.ISBN = ISBN;
this.titre = titre;
this.anneeParution = anneeParution;
this.editeur = editeur;
}
// Accesseurs
public String getISBN(){return ISBN;}
public String getTitre(){return titre;}
public int getAnneeParution(){return anneeParution;}
public Editeur getEditeur (){return editeur;}

public void setISBN(String ISBN){this.ISBN = ISBN;}
public void setTitre(String titre){this.titre = titre;}
public void setAnneeParution(int anneeParution){
this.anneeParution = anneeParution;}
public void setEditeur(Editeur editeur){
this.editeur = editeur;
}
}
