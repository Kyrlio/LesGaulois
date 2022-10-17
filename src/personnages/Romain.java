package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert this.forceSup0();
	}
	
	private boolean forceSup0() {
		return (this.force > 0);
	}
	
	private boolean forceDiminue(int ancienne_force) {
		return ( ancienne_force > this.force);
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " :";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert this.forceSup0();
		int ancienne_force = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert this.forceDiminue(ancienne_force);
	}
	
	
	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
			break;
		}
		case 1:{
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " Possède déjà un " + equipement);
			}
			else if (equipements[0] != equipement) {
				equipements[1] = equipement;
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
				nbEquipement++;
			}
			break;
		}
		case 0:{
			equipements[0] = equipement;
			System.out.println("Pas d'équipements");
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement);
			nbEquipement++;
			break;
		}
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
//		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.nbEquipement = 1;
		System.out.println(minus.nbEquipement);
		minus.equipements[0] = Equipement.BOUCLIER;
		minus.sEquiper(Equipement.CASQUE);
		System.out.println(minus.nbEquipement);
		for (int i = 0 ; i < 2 ; i++) {
			System.out.println(minus.equipements[i]);
		}
	}
	
}
