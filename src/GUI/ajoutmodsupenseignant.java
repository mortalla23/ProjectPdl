package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.coursdao;
import DAO.enseignantdao;
import model.Enseignant;
import model.cours;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajoutmodsupenseignant {

	public JFrame frame;
	private JTextField textFieldNOMENSEI;
	private JTextField textField_IDENSEI;
	private JPasswordField passwordField;
	private JTextField textField_NUMTEL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutmodsupenseignant window = new ajoutmodsupenseignant();
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
	public ajoutmodsupenseignant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AJOU/MOD/SUP ENSEIGNANT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(319, 41, 187, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMENSEI");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(142, 143, 106, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(142, 206, 45, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NUM TEL");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(142, 265, 96, 21);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MOT DE PASSE");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(142, 332, 126, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textFieldNOMENSEI = new JTextField();
		textFieldNOMENSEI.setBounds(470, 143, 140, 19);
		frame.getContentPane().add(textFieldNOMENSEI);
		textFieldNOMENSEI.setColumns(10);
		
		textField_IDENSEI = new JTextField();
		textField_IDENSEI.setBounds(470, 207, 140, 19);
		frame.getContentPane().add(textField_IDENSEI);
		textField_IDENSEI.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(470, 333, 140, 19);
		frame.getContentPane().add(passwordField);
		
		textField_NUMTEL = new JTextField();
		textField_NUMTEL.setBounds(470, 267, 140, 19);
		frame.getContentPane().add(textField_NUMTEL);
		textField_NUMTEL.setColumns(10);
		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignantdao util = new enseignantdao ();
				int idenseignant;
				String nomensei;
				int numTel;
				String mdp;
				
				nomensei = textFieldNOMENSEI.getText();
				idenseignant = (int) Double.parseDouble(textField_IDENSEI.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp=passwordField.getText()	;	
				Enseignant newUtil = new Enseignant(nomensei,idenseignant,numTel,mdp);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "enseignant ajouté(e) avec succès");
			}
		});
		btnNewButton.setBounds(492, 416, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignantdao util = new enseignantdao ();
				int idenseignant;
				String nomensei;
				int numTel;
				String mdp;
				
				nomensei = textFieldNOMENSEI.getText();
				idenseignant = (int) Double.parseDouble(textField_IDENSEI.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp=passwordField.getText()	;	
				Enseignant newUtil = new Enseignant(nomensei,idenseignant,numTel,mdp);
				util.update(newUtil);
				JOptionPane.showMessageDialog(null, "enseignant mis à jour avec succès");
				
			}
		});
		btnNewButton_1.setBounds(319, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseignantdao util = new enseignantdao ();
				int idenseignant;
				String nomensei;
				int numTel;
				String mdp;
				
				nomensei = textFieldNOMENSEI.getText();
				idenseignant = (int) Double.parseDouble(textField_IDENSEI.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp=passwordField.getText()	;	
				Enseignant newUtil = new Enseignant(nomensei,idenseignant,numTel,mdp);
				util.delete(idenseignant);
				JOptionPane.showMessageDialog(null, "enseignant supprimé(e) avec succès");
			}
		});
		btnNewButton_2.setBounds(163, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RETOUR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tachesgestion window = new tachesgestion();
					window.frame.setVisible(true);
				} catch (Exception e200) {
					e200.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(661, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
	}
}
