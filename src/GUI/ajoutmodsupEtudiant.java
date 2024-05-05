package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAO.etudiantDAO;
import model.Etudiant;
import model.Utilisateur;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ajoutmodsupEtudiant {

	public JFrame frmAjouterEtudiant;
	private JTextField textField_nom;
	private JTextField textField_id;
	private JTextField textField_prenom;
	private JPasswordField passwordField;
	private JTextField textFieldEMAIL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajoutmodsupEtudiant window = new ajoutmodsupEtudiant();
					window.frmAjouterEtudiant.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ajoutmodsupEtudiant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterEtudiant = new JFrame();
		frmAjouterEtudiant.setTitle("Ajouter Etudiant");
		frmAjouterEtudiant.setBounds(100, 100, 1116, 548);
		frmAjouterEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterEtudiant.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AJOU/MOD/SUP etudiant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(109, 28, 930, 61);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOM");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(298, 112, 68, 26);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel_1_1);
		
		textField_nom = new JTextField();
		textField_nom.setColumns(10);
		textField_nom.setBounds(598, 118, 244, 19);
		frmAjouterEtudiant.getContentPane().add(textField_nom);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("PRENOM");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(298, 227, 68, 26);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(298, 295, 68, 26);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("MOT DE PASSE");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(298, 342, 164, 26);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel_1_1_3);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(598, 301, 244, 19);
		frmAjouterEtudiant.getContentPane().add(textField_id);
		
		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(598, 233, 244, 19);
		frmAjouterEtudiant.getContentPane().add(textField_prenom);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(598, 348, 244, 19);
		frmAjouterEtudiant.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiantDAO util = new etudiantDAO();
				int id;
				String nometudiant;
				String prenometudiant;
				String adresseMail;
				String mdp;
				nometudiant = textField_nom.getText();
				prenometudiant = textField_prenom.getText();
				adresseMail= textFieldEMAIL.getText();
				mdp = passwordField.getText();
				id = Integer.parseInt(textField_id.getText());
			
				Etudiant newUtil = new Etudiant(adresseMail,nometudiant,prenometudiant,id,mdp);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "Etudiant ajouté(e) avec succès");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(692, 452, 93, 21);
		frmAjouterEtudiant.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(298, 406, 554, 11);
		frmAjouterEtudiant.getContentPane().add(separator);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiantDAO util = new etudiantDAO();
				int idetudiant;
				String nometudiant;
				String prenometudiant;
				String adresseMail;
				String mdp;
				nometudiant = textField_nom.getText();
				prenometudiant = textField_prenom.getText();
				adresseMail= textFieldEMAIL.getText();
				mdp = passwordField.getText();
				idetudiant = Integer.parseInt(textField_id.getText());
				Etudiant newUtil = new Etudiant(adresseMail,nometudiant,prenometudiant,idetudiant,mdp);
				util.update(newUtil);
				JOptionPane.showMessageDialog(null, "Etudiant mis à jour avec succès");
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(512, 452, 93, 21);
		frmAjouterEtudiant.getContentPane().add(btnUpdate);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiantDAO util = new etudiantDAO();
				int idetudiant;
				String nometudiant;
				String adresseMail;
				String prenometudiant;
				String mdp;
				nometudiant = textField_nom.getText();
				prenometudiant = textField_prenom.getText();
				adresseMail= textFieldEMAIL.getText();
				mdp = passwordField.getText();
				idetudiant = Integer.parseInt(textField_id.getText());
				Etudiant newUtil = new Etudiant(nometudiant,adresseMail,prenometudiant,idetudiant,mdp);
				util.delete(idetudiant);
				JOptionPane.showMessageDialog(null, "Etudiant supprimé(e) avec succès");
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupprimer.setBounds(309, 453, 93, 21);
		frmAjouterEtudiant.getContentPane().add(btnSupprimer);
		
		textFieldEMAIL = new JTextField();
		textFieldEMAIL.setBounds(598, 180, 244, 19);
		frmAjouterEtudiant.getContentPane().add(textFieldEMAIL);
		textFieldEMAIL.setColumns(10);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_4.setBackground(Color.BLACK);
		lblNewLabel_1_1_4.setBounds(298, 174, 68, 26);
		frmAjouterEtudiant.getContentPane().add(lblNewLabel_1_1_4);
		
		JButton btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tachesgestion window = new tachesgestion();
					window.frame.setVisible(true);
				} catch (Exception j) {
					j.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(153, 453, 85, 21);
		frmAjouterEtudiant.getContentPane().add(btnNewButton_1);
	}

}
