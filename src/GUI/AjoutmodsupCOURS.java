package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import DAO.etudiantDAO;
import DAO.coursdao;
import model.Utilisateur;
import model.cours;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjoutmodsupCOURS {

	private JFrame frame;
	private JTextField textFieldIDCOURS;
	private JTextField textField_matiere;
	private JTextField textFieldnbreheure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutmodsupCOURS window = new AjoutmodsupCOURS();
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
	public AjoutmodsupCOURS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1105, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(53, 52, 964, 457);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IDCOURS");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(152, 78, 93, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MATIERE");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(152, 159, 93, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("NBREHEURE");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(152, 267, 164, 26);
		panel_1.add(lblNewLabel_1_1_3);
		
		textFieldIDCOURS = new JTextField();
		textFieldIDCOURS.setColumns(10);
		textFieldIDCOURS.setBounds(452, 84, 244, 19);
		panel_1.add(textFieldIDCOURS);
		
		textField_matiere = new JTextField();
		textField_matiere.setColumns(10);
		textField_matiere.setBounds(452, 165, 244, 19);
		panel_1.add(textField_matiere);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursdao util = new coursdao ();
				int idcours;
				String matiere;
				Double nbreheure;
				
				matiere = textField_matiere.getText();
				nbreheure = Double.parseDouble(textFieldnbreheure.getText());
				idcours = Integer.parseInt(textFieldIDCOURS.getText());
				cours newUtil = new cours(matiere,nbreheure,idcours);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "cours ajouté(e) avec succès");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(546, 418, 93, 21);
		panel_1.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(152, 372, 554, 11);
		panel_1.add(separator);
		
		textFieldnbreheure = new JTextField();
		textFieldnbreheure.setBounds(452, 273, 251, 19);
		panel_1.add(textFieldnbreheure);
		textFieldnbreheure.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					coursdao util = new coursdao ();
					int idcours;
					String matiere;
					Double nbreheure;
					
					matiere = textField_matiere.getText();
					nbreheure = Double.parseDouble(textFieldnbreheure.getText());
					idcours = Integer.parseInt(textFieldIDCOURS.getText());
					cours newUtil = new cours(matiere,nbreheure,idcours);
					util.update(newUtil);
					JOptionPane.showMessageDialog(null, "cours mis à jour avec succès");
					
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(211, 419, 93, 21);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					coursdao util = new coursdao ();
					int idcours;
					String matiere;
					Double nbheure;
					
					matiere = textField_matiere.getText();
				    nbheure = Double.parseDouble(textFieldnbreheure.getText());
					idcours = Integer.parseInt(textFieldIDCOURS.getText());
					cours cours = new cours(matiere,nbheure,idcours);
					util.delete(idcours);
					JOptionPane.showMessageDialog(null, "cours supprimé(e) avec succès");
					
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(375, 419, 93, 21);
		panel_1.add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("AJOUT/MOD/SUPP COURS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 10, 964, 32);
		frame.getContentPane().add(lblNewLabel);
	}
	

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
