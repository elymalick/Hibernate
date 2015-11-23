import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Person  implements Serializable {

	private static final long serialVersionUID = -7209279858153584388L;
	
	// primary key
	private Integer id;

	// fields
	private String nom;
	private String prenom;
	private int age;
	private String ville;


	// constructors
	public Person() {};
	
	public Person (String nom, String prenom, String ville, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.ville = ville;
	}

	public Person (Integer id) {
		this.setId(id);
	}

	public Integer getId () {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public String getNom () {
		return nom;
	}

	public void setNom (String nom) {
		this.nom = nom;
	}
	public String getPrenom () {
		return prenom;
	}

	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}
	public String getVille () {
		return ville;
	}

	public void setVille (String ville) {
		this.ville = ville;
	}

	public int getAge () {
		return age;
	}

	public void setAge (int age) {
		this.age = age;
	}


	public String toString () {	
		return new ToStringBuilder(this).
	       append("Nom", nom + "\n").
	       append("Prenom", prenom + "\n").
	       append("Age", age + "\n").
		   append("Ville", ville + "\n").  
	       toString();
 	}
}