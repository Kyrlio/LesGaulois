package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int num_villageois) {
		return villageois[num_villageois];
	}
	
	public void afficherVillageois(Chef chef) {
		System.out.println("Dans le village du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0 ; i < nbVillageois ; i++) {
			System.out.println("- " + villageois[i].getNom());}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 0
//		at personnages.Village.trouverHabitant(Village.java:32)
//		at personnages.Village.main(Village.java:41)
//		Le message sera : index out of... le tableau va de 0 a 29 donc 30 est en dehors du tableau
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		null
//		Les tableaux sont initialisés a null donc il m'affiche null car il n'y a aucun gaulois a cette case
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.setChef(abraracourcix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(abraracourcix);
		
	}
	
	

}
