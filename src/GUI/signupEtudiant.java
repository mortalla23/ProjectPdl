package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.coursdao;
import DAO.etudiantDAO;
import model.Etudiant;
import model.cours;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signupEtudiant {

	public JFrame frame;
	private JTextField textFieldID;
	private JTextField textField_PRENOM;
	private JPasswordField passwordField;
	private JTextField textField_NOM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupEtudiant window = new signupEtudiant();
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
	public signupEtudiant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 552);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(242, 39, 85, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IDetudiant");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(71, 147, 96, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRENOM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(71, 255, 73, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(309, 153, 112, 19);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textField_PRENOM = new JTextField();
		textField_PRENOM.setBounds(309, 261, 112, 19);
		frame.getContentPane().add(textField_PRENOM);
		textField_PRENOM.setColumns(10);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String  idSaisi = textFieldID.getText();
				String  nomSaisi = textField_NOM.getText();
				String prenomSaisi = textField_PRENOM.getText();
				
				char [] mdpSaisi = passwordField.getPassword();
				
				if (idSaisi.equals("") || nomSaisi.equals("") ||prenomSaisi.equals("") ||mdpSaisi.equals("")) {
		            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
		       // } else if (!idSaisi.contains("2023")) {
		       //     JOptionPane.showMessageDialog(null, "id invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        } else {
		            // Affichage des saisies de l'utilisateur dans la console
		            System.out.println("id : " + idSaisi);
		            System.out.println("nom : " + nomSaisi);
		            System.out.println("prenom : " + prenomSaisi);
		            
		            System.out.println("Mot de passe : " + mdpSaisi);
		            JOptionPane.showMessageDialog(null, "Saisies validées avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
		        }
				
				try {
					tacheetudiant window = new tacheetudiant();
					window.frame.setVisible(true);
				} catch (Exception e9) {
					e9.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(229, 381, 98, 21);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 316, 112, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("MOT DE PASSE");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(71, 308, 112, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NOM");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(71, 209, 45, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField_NOM = new JTextField();
		textField_NOM.setBounds(309, 207, 112, 19);
		frame.getContentPane().add(textField_NOM);
		textField_NOM.setColumns(10);
	}

}
