package generateur_pnj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Pnj {
	public String Nom;
	public Tuple Sexe;
	public String Age;
	public String Race;
	public String Metier;
	public String Personnalite;
	public String Signe;
	public String Yeux;
	public String Cheveux;
	public String Poids;
	public String Taille;
	public String Voix;
	public String Tic;
	public String Regard;

	
	public Pnj() {
		this.Sexe = defSexe();
		this.Nom = defNom(this.Sexe);
		this.Age = defAge();
		this.Cheveux = defCheveux(this.Sexe);
		this.Race = defWithinArray(races);
		this.Yeux = defWithinArray(yeuxcouleur)+" / "+defWithinArray(yeuxforme);
		this.Metier = defWithinArray(metiers);
		this.Personnalite = defWithinArray(personnalite);
		this.Signe = defWithinArray(signe);
		this.Taille = defWithinArray(taille);
		this.Poids = defWithinArray(poids);
		this.Voix = defWithinArray(voix)+" / "+defWithinArray(parole);
		this.Tic = defWithinArray(tic);
		this.Regard = defWithinArray(regard);
	}

	// une méthode pour afficher une boite de dialogue TRES informative
	public static void promptInformation(String texte) {
		JOptionPane info = new JOptionPane(texte,JOptionPane.INFORMATION_MESSAGE);
		JDialog dialoge = info.createDialog("Information");
		dialoge.setAlwaysOnTop(true);
		dialoge.setVisible(true);
	}
	
	// va falloir les initilaiser un jour mon coco
	// constructeurs de noms
	public static ArrayList<String> open = new ArrayList<String>();
	public static ArrayList<String> closeM = new ArrayList<String>(); // hommes
	public static ArrayList<String> closeF = new ArrayList<String>(); // femmes
	public static ArrayList<String> mid = new ArrayList<String>();
	public static ArrayList<String> metiers = new ArrayList<String>();
	public static ArrayList<String> personnalite = new ArrayList<String>();
	public static ArrayList<String> cheveuxF = new ArrayList<String>();
	public static ArrayList<String> cheveuxH = new ArrayList<String>();
	public static ArrayList<String> signe = new ArrayList<String>();
	public static ArrayList<String> races = new ArrayList<String>();
	public static ArrayList<String> cheveuxcouleurs = new ArrayList<String>();
	public static ArrayList<String> poids = new ArrayList<String>();
	public static ArrayList<String> taille = new ArrayList<String>();
	public static ArrayList<String> voix = new ArrayList<String>();
	public static ArrayList<String> tic = new ArrayList<String>();
	public static ArrayList<String> parole = new ArrayList<String>();
	public static ArrayList<String> regard = new ArrayList<String>();
	public static ArrayList<String> yeuxcouleur = new ArrayList<String>();
	public static ArrayList<String> yeuxforme = new ArrayList<String>();
	// techniquement, ça doit tout contenir
	public static ArrayList<Duet> container = new ArrayList<Duet>(); 
	
	/*
	 * Renvoie un élément aléatoire de la liste passée en paramètre
	 */
	public static String defWithinArray(ArrayList<String> liste) {
		return liste.get((int)(Math.random()*liste.size()));
	}
	
	
	/******** INIT ********/
	
	/*
	 * Fonction d'initialisation des ressources
	 */
	public static void init() throws IOException {
		// création du container
		container.add(Duet.newDuet("start.txt",open));
		container.add(Duet.newDuet("closerF.txt",closeF));
		container.add(Duet.newDuet("closerM.txt",closeM));
		container.add(Duet.newDuet("middle.txt",mid));
		container.add(Duet.newDuet("metiers.txt",metiers));
		container.add(Duet.newDuet("personnalite.txt",personnalite));
		container.add(Duet.newDuet("cheveuxF.txt",cheveuxF));
		container.add(Duet.newDuet("cheveuxH.txt",cheveuxH));
		container.add(Duet.newDuet("signe.txt",signe));
		container.add(Duet.newDuet("ethnies.txt",races));
		container.add(Duet.newDuet("cheveuxcouleurs.txt",cheveuxcouleurs));
		container.add(Duet.newDuet("poids.txt",poids));
		container.add(Duet.newDuet("voix.txt",voix));
		container.add(Duet.newDuet("taille.txt",taille));
		container.add(Duet.newDuet("tic.txt",tic));
		container.add(Duet.newDuet("parole.txt",parole));
		container.add(Duet.newDuet("regard.txt",regard));
		container.add(Duet.newDuet("yeuxcouleur.txt",yeuxcouleur));
		container.add(Duet.newDuet("yeuxforme.txt",yeuxforme));
		// variables
		BufferedReader lecteur = null;
		
		String lecture;
		String filepath="";
		String apath="";
		
		// String path = Pnj.class.getResource(".").getFile();
		// promptInformation("Etape 1 : "+path);
		// path = URLDecoder.decode(path, "UTF-8");
		// promptInformation("Etape 2 : "+path);
		// File file = new File(path);
		
		
			File test = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
			URI a = (test.toURI());
			apath = URLDecoder.decode(a.getPath(),"UTF-8");
			//promptInformation("Fichier : "+apath);

		ArrayList<String> devidoir=open; // c'est un alias mobile !
		for(int i=0;i<container.size();i++) {
				devidoir=container.get(i).list;
				filepath=apath+"//"+container.get(i).path;
				//promptInformation("Fichier : "+filepath);
			try {
				// buffer de lecture
				lecteur = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),"UTF-8"));
			} catch(Exception e){
				// takru j'allais traiter l'erreur mdr
				promptInformation("Erreur de chargement. "+filepath+" n'existe pas.");
			}
			// on charge fichier dans array tmtc
			while((lecture=lecteur.readLine())!=null) {
				devidoir.add(lecture);
			}
		}
		lecteur.close();
		// promptInformation("Initialisation accomplie avec succès !");
	}	
	
	/******** NOM ********/

	/*
	 * Génération de noms
	 * Max 4 morceaux
	 * Un opener, une fin
	 * deux middle // trois switch
	 */
	public static String defNom(Tuple sexe) {
		// construction des parties ; sexe = 0 => homme
		String opener = open.get((int)(Math.random()*open.size()));
		String closer = sexe.nombre==0?closeM.get((int)(Math.random()*closeM.size())):closeF.get((int)(Math.random()*closeF.size()));
		String part1 = mid.get((int)(Math.random()*mid.size()));
		String part2 = mid.get((int)(Math.random()*mid.size()));
		// construction du nom
		switch ((int)(Math.random()*4)) {
		case 1: return opener+part1+closer;
		case 2: return opener+part1+part2+closer;	
		default: return opener+closer;
		}		
	}
	
	/*
	 * Permet de reroll un nom
	 */
	public static Pnj changeNom(Pnj monPnj) {
		monPnj.Nom = defNom(monPnj.Sexe);
		return monPnj;
	}
	
	/******** CHEVEUX ********/

	/*
	 * Génération de cheveux : couleur + forme
	 */
	public static String defCheveux(Tuple sexe) {
		// construction des parties ; sexe = 0 => homme
		String couleur = defWithinArray(cheveuxcouleurs);
		String forme = sexe.nombre==0?defWithinArray(cheveuxH):defWithinArray(cheveuxF);
		// construction du nom
		return couleur+" / "+forme;
		}		
	
	/******** SEXE ********/
	
	/*
	 * Définit le sexe biologique et l'orientation sexuelle.
	 * 25% de la pop. n'est pas hétérosexuelle.
	 * Environ 50/50 en termes de répartition de sexe biologique.
	 * Retoure un putain de tuple ses grands morts pour avoir un chiffre pour l'autre fonction débile.
	 * Cf classe Tuple
	 */
	public static Tuple defSexe() {
		Tuple sexe = new Tuple();
		// variables
		String orientation = new String();
		String sexe_bio = new String();
		// orientation
		switch ((int)(Math.random()*16)) {
		case 2: case 3: case 4: orientation="homosexuel(le)";
		break;
		case 5: orientation="asexuel(le)";	
		break;
		case 6: orientation="bisexuel(le)";	
		break;
		default: orientation="hétérosexuel(le)";
		}
		// sexe biologique
		if ((int)(Math.random()*10)<=4) {
			sexe_bio="homme";
			sexe.nombre=0;
		}
		else {	
			sexe_bio="femme";
			sexe.nombre=1;
		}
		// retour
		sexe.string=sexe_bio+" "+orientation;
		return sexe;
	}
	
	/******** AGE ********/
	
	/*
	 * Définit un archétype d'âge.
	 */
	public static String defAge() {
		// variables
		String age = new String();
		// age
		switch ((int)(Math.random()*7)) {
		case 2: age="enfant";
		break;
		case 3: age="jeune adulte";	
		break;
		case 4: age="agé(e)";	
		break;
		default: age="médian";
		}
		// retour
		return age;
	}
	
}
