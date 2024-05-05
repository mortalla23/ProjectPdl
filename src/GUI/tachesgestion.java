package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DAO.absencedao;
import model.Absence;

public class tachesgestion {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tachesgestion window = new tachesgestion();
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
	public tachesgestion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TACHES DU GESTIONNAIRE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(140, 24, 293, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GERER COURS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(83, 173, 104, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GERER ETUDIANTS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(83, 234, 114, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("GERER JUSTIFICATIF ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(83, 308, 147, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjoutmodsupCOURS window = new AjoutmodsupCOURS();
					window.getFrame().setVisible(true);
				} catch (Exception j) {
					j.printStackTrace();
				}		
				frame.dispose();
			}
		});
		btnNewButton.setBounds(303, 169, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VALIDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ajoutmodsupEtudiant window = new ajoutmodsupEtudiant();
					window.frmAjouterEtudiant.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Window frmAjouterEtudiant = null;
				frmAjouterEtudiant.dispose();
			}
		});
		btnNewButton_1.setBounds(303, 231, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VALIDER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(303, 305, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("GERER ENSEIGNANT");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(83, 375, 125, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("VALIDER");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					ajoutmodsupenseignant window = new ajoutmodsupenseignant();
					window.frame.setVisible(true);
				} catch (Exception e55) {
					e55.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(303, 371, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
	}
}
