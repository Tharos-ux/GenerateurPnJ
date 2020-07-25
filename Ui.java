package generateur_pnj;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Ui extends JFrame implements ActionListener {
		JLabel pnjNom = new JLabel("");
	    JLabel pnjSexe = new JLabel("");
	    JLabel pnjAge = new JLabel("");
	    JLabel pnjRace = new JLabel("");
	    JLabel pnjMetier = new JLabel("");
	    JLabel pnjYeux = new JLabel("");
	    JLabel pnjPersonnalite = new JLabel("");
	    JLabel pnjSigne = new JLabel("");
	    JLabel pnjCheveux = new JLabel("");
	    JLabel pnjTaille = new JLabel("");
	    JLabel pnjPoids = new JLabel("");
	    JLabel pnjVoix = new JLabel("");
	    JLabel pnjTic = new JLabel("");
	    JLabel pnjRegard = new JLabel("");
		JLabel labelNom = new JLabel(" Nom : ");
	    JLabel labelSexe = new JLabel(" Identité : ");
	    JLabel labelAge = new JLabel(" Age : ");
	    JLabel labelRace = new JLabel(" Ethnie : ");
	    JLabel labelMetier = new JLabel(" Métier : ");
	    JLabel labelYeux = new JLabel(" Yeux : ");
	    JLabel labelPersonnalite = new JLabel(" Personnalité : ");
	    JLabel labelSigne = new JLabel(" Signe distinctif : ");
	    JLabel labelCheveux = new JLabel(" Cheveux : ");
	    JLabel labelTaille = new JLabel(" Taille : ");
	    JLabel labelPoids = new JLabel(" Corpulence : ");
	    JLabel labelVoix = new JLabel(" Voix : ");
	    JLabel labelTic = new JLabel(" Tic : ");
	    JLabel labelRegard = new JLabel(" Regard : ");
	    int index = 0;
	    JLabel pnjIndex = new JLabel("");
	    JPanel panbouton = new JPanel();
	    JPanel panprincipal = new JPanel();
	    JPanel pantexte = new JPanel();
	    JPanel pantexte2 = new JPanel();
	    JPanel panlabel = new JPanel();
	    JPanel panlabel2 = new JPanel();
	    JPanel panlayer = new JPanel();
	    JButton generate = new JButton("Générer !");
	    JButton precedent = new JButton("<");
	    JButton suivant = new JButton(">");
	    JButton nouveauNom = new JButton("Changer nom");
	    JButton nouveauPnj = new JButton("Remplacer");
	    
	// buffer de stockage    
	public static ArrayList<Pnj> buffer = new ArrayList<Pnj>();
	
	// fontes
	public Font std = new java.awt.Font(Font.SANS_SERIF,Font.PLAIN,13);
	public Font bold = new java.awt.Font(Font.SANS_SERIF,Font.BOLD,13);
	
	public Ui() {
		
		this.setTitle("Génarateur de Pnj");
		this.setSize(600,340);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.isAlwaysOnTop();
	    
	    try {
			this.setIconImage(ImageIO.read(new File("icon.png")));
		} catch (IOException e) {
			// wheeee
		}	    
	    pantexte.setLayout(new BoxLayout(pantexte, BoxLayout.PAGE_AXIS));
	    // pantexte.setLayout(new BoxLayout(pantexte2, BoxLayout.PAGE_AXIS));
	    pantexte.add(pnjNom);
	    pantexte.add(pnjSexe);
	    pantexte.add(pnjAge);
	    pantexte.add(pnjRace);
	    pantexte.add(pnjMetier);
	    pantexte.add(pnjYeux);
	    pantexte.add(pnjPersonnalite);
	    pantexte.add(pnjSigne);
	    pantexte.add(pnjCheveux);
	    pantexte.add(pnjTaille);
	    pantexte.add(pnjPoids);
	    pantexte.add(pnjVoix);
	    pantexte.add(pnjTic);
	    pantexte.add(pnjRegard);
	    
	    panlabel.setLayout(new BoxLayout(panlabel, BoxLayout.PAGE_AXIS));
	    // panlabel2.setLayout(new BoxLayout(panlabel2, BoxLayout.PAGE_AXIS));
	    panlabel.add(labelNom);
	    panlabel.add(labelSexe);
	    panlabel.add(labelAge);
	    panlabel.add(labelRace);
	    panlabel.add(labelMetier);
	    panlabel.add(labelYeux);
	    panlabel.add(labelPersonnalite);
	    panlabel.add(labelSigne);
	    panlabel.add(labelCheveux);
	    panlabel.add(labelTaille);
	    panlabel.add(labelPoids);
	    panlabel.add(labelVoix);
	    panlabel.add(labelTic);
	    panlabel.add(labelRegard);
	    
	    labelNom.setFont(std);
	    labelSexe.setFont(std);
	    labelAge.setFont(std);
	    labelRace.setFont(std);
	    labelMetier.setFont(std);
	    labelYeux.setFont(std);
	    labelPersonnalite.setFont(std);
	    labelSigne.setFont(std);
	    labelCheveux.setFont(std);
	    labelTaille.setFont(std);
	    labelPoids.setFont(std);
	    labelVoix.setFont(std);
	    labelTic.setFont(std);
	    labelRegard.setFont(std);
	    
	    // actionlisteners
	    nouveauPnj.addActionListener(this);
	    precedent.addActionListener(this);
	    suivant.addActionListener(this);
	    generate.addActionListener(this);
	    nouveauNom.addActionListener(this);
	    
	    panprincipal.setLayout(new GridLayout(0,2));
	    
	    // boutons d'action
	    panbouton.add(nouveauPnj);
	    panbouton.add(precedent);
	    panbouton.add(generate);
	    panbouton.add(suivant);
	    panbouton.add(nouveauNom);
	    
	    panprincipal.add(panlabel);
	    panprincipal.add(pantexte);
	    //panprincipal.add(panlabel2);
	    //panprincipal.add(pantexte2);
	    
	    panlayer.setLayout(new BoxLayout(panlayer, BoxLayout.PAGE_AXIS));
	    //panlayer.add(pnjIndex);
	    panlayer.add(panbouton);
	    
	    this.getContentPane().add(panlayer, BorderLayout.SOUTH);
	    this.getContentPane().add(panprincipal, BorderLayout.NORTH);
	    
	    buildPnj();
	    
	    this.setVisible(true);
	}
	public void buildPnj() {
		Pnj monPnj = new Pnj();
		buffer.add(monPnj); // on stocke le Pnj dans la mémoire
		buildPnj(monPnj);
	}
	
	public void buildPnj(Pnj monPnj) {
		pnjNom.setText(monPnj.Nom);
		pnjNom.setFont(bold);
		pnjAge.setText(monPnj.Age);
		pnjAge.setFont(bold);
		pnjSexe.setText(monPnj.Sexe.string);
		pnjSexe.setFont(bold);
		pnjRace.setText(monPnj.Race);
		pnjRace.setFont(bold);
		pnjMetier.setText(monPnj.Metier);
		pnjMetier.setFont(bold);
		pnjYeux.setText(monPnj.Yeux);
		pnjYeux.setFont(bold);
		pnjPersonnalite.setText(monPnj.Personnalite);
		pnjPersonnalite.setFont(bold);
		pnjSigne.setText(monPnj.Signe);
		pnjSigne.setFont(bold);
		pnjCheveux.setText(monPnj.Cheveux);
		pnjCheveux.setFont(bold);
		pnjTaille.setText(monPnj.Taille);
		pnjTaille.setFont(bold);
		pnjPoids.setText(monPnj.Poids);
		pnjPoids.setFont(bold);
		pnjVoix.setText(monPnj.Voix);
		pnjVoix.setFont(bold);
		pnjRegard.setText(monPnj.Regard);
		pnjRegard.setFont(bold);
		pnjTic.setText(monPnj.Tic);
		pnjTic.setFont(bold);
		this.setTitle("Génarateur de Pnj - "+(index+1)+"/"+buffer.size());
	}
	public void actionPerformed(ActionEvent event){
    	if(event.getSource()==generate) {
    		index = buffer.size();
    		buildPnj();	
    	}
    	if(event.getSource()==suivant) {
    		if(index==buffer.size()-1) index=0;
    		else index+=1;
    		buildPnj(buffer.get(index));
    	}
    	if(event.getSource()==precedent) {
    		if(index==0) index=buffer.size()-1;
    		else index-=1;
    		buildPnj(buffer.get(index));
    	}
    	if(event.getSource()==nouveauNom) {
    		Pnj.changeNom(buffer.get(index));
    		buildPnj(buffer.get(index));
    	}
    	if(event.getSource()==nouveauPnj) {
    		Pnj.changeNom(buffer.get(index));
    		buffer.remove(index);
    		index = buffer.size();
    		buildPnj();
    	}
        }
}
