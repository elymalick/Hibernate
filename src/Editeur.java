

	

	import java.util.*;

	public class Editeur
	{
	        private String  nomEditeur ;
	        private String  ville ;
	        private Set lesLivres = new HashSet();

	        // Constructeur vide requis
	        public Editeur(){}

	        public Editeur(String nomEditeur, String ville ){
	                this.nomEditeur = nomEditeur;
	                this.ville = ville;
	        }

	        public String getNomEditeur(){return nomEditeur;}
	        public String getVille(){return ville;}
	        public Set getLesLivres(){return lesLivres;}

	        public void setNomEditeur(String nomEditeur)
		{this.nomEditeur = nomEditeur;}
	        public void setVille(String ville){this.ville = ville;}

	        // Gestion explicite des associations par attributs
	        public void setLesLivres(Set lesLivres ){
	                this.lesLivres = lesLivres ;
	        }
	}

