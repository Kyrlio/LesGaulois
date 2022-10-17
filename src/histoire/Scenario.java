package histoire;
import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 10);
		Romain minus = new Romain("Minus", 6);
		Druide panoramix = new Druide("Panomarix", 5, 10);
		
		panoramix.parler("Je vais aller préparer une petite potion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bénélos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU...");
		for (int i = 0 ; i < 3 ; i++) {
			asterix.frapper(minus);
		}
	}

}
