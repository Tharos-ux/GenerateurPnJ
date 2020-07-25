package generateur_pnj;

import java.util.ArrayList;

public class Duet {
	public String path;
	public ArrayList<String> list;
	
	/*
	 * Un tuple constitué de deux éléments
	 */
	public Duet() {
		this.path = new String();
		this.list = new ArrayList<String>();
	}
	
	/*
	 * Fonction pour initier un tuple à base de données
	 */
	public static Duet newDuet(String s, ArrayList<String> a) {
		Duet monDuet = new Duet();
		monDuet.path = s;
		monDuet.list = a;
		return monDuet;
	}
}
