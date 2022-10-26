package personnages;

import javax.management.openmbean.TabularType;

public class Musee {
	private Trophee[] tabTrophee = new Trophee[200] ;
	private int nbTrophee = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		this.tabTrophee[nbTrophee] = trophee;
		this.nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String caml = "let musee = [\n";
		for (int i = 0 ; i < nbTrophee - 2 ; i++) {
			caml += '"';
			caml += tabTrophee[i].getGaulois().getNom();
			caml += '"';
			caml += '"';
			caml += '"';
			caml += tabTrophee[i].getEquipement().toString();
			caml += '"';
			caml += ";\n";
		}
		caml += '"';
		caml += tabTrophee[nbTrophee-1].getGaulois().getNom();
		caml += '"';
		caml += '"';
		caml += tabTrophee[nbTrophee-1].getEquipement().toString();
		caml += '"';
		caml += "\n";
		caml += "]";
		return caml;
	}

}
