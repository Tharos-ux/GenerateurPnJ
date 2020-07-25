package generateur_pnj;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		System.setProperty( "file.encoding", "UTF-16" );
		Pnj.init(); // initalisation des tables de création de noms
		@SuppressWarnings("unused")
		Ui fenetre = new Ui(); // génération de l'UI
	}
}

