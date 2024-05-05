package GUI;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.absencedao;
import javax.swing.SwingConstants;
import model.Absence;


import javax.swing.JFrame;


public class listeabsence {

	 public static void main(String[] args) {

	        ArrayList<Absence> listeabsence = new ArrayList<>();

	        listeabsence = absencedao.getListeabsence();

	        // Créer un modèle de table par défaut avec les colonnes appropriées

	        DefaultTableModel model = new DefaultTableModel();

	        //model.addColumn("id absence");

	        model.addColumn("date absence");

	        model.addColumn("type d absence");

	        //model.addColumn("heure");

	        model.addColumn("volume horaire");



	        // Ajouter les données à partir de l'ArrayList à la table

	        for (Absence absence : listeabsence) {



	            model.addRow(new Object[]{ absence.getDateAbs(), absence.getTypeAbs(), absence.getVolumeHoraire()});



	        }



	        // Créer une JTable avec le modèle de table

	        JTable table = new JTable(model);



	        // Afficher la table dans une fenêtre

	        JFrame frame = new JFrame();

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        frame.getContentPane().add(new JScrollPane(table));

	        frame.pack();

	        frame.setVisible(true);

	       

	        JLabel titre = new JLabel("liste des absences");

	        titre.setHorizontalAlignment(SwingConstants.CENTER);

	        frame.getContentPane().add(titre, BorderLayout.NORTH);

	        frame.setLocationRelativeTo(null);

	        frame.setVisible(true);

	    }

	protected Object frame;

	}




	
	
	
	
	
	
	
	/*private JFrame frame;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listeabsence window = new listeabsence();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public listeabsence() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
**/