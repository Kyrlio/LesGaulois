package personnages;

import java.security.PublicKey;
import java.util.Iterator;
import personnages.*;

public class Gaulois {
	private String nom;
	private int force; 
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force	 + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}
	
	public void faireUneDonnation(Musee museeGaule) {
		if (this.nbTrophees > 0) {
			parler("Je donne au musee tous mes trophees :");
			for(int i = 0 ; i < this.nbTrophees ; i++) {
				System.out.println("- " + trophees[i]);
				museeGaule.donnerTrophees(this, trophees[i]);
			}
		}
		this.nbTrophees = 0;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Musee musee = new Musee();
		asterix.trophees[0] = Equipement.BOUCLIER;
		asterix.nbTrophees = 2;
//		Romain achille = new Romain("Achille", 2);
//		System.out.println(asterix);
//		asterix.prendreParole();
//		asterix.parler("oui");
//		asterix.boirePotion(3);
//		asterix.frapper(achille);
		asterix.faireUneDonnation(musee);
	}
}


