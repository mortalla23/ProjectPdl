package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import DAO.coursdao;
import DAO.justificatifdao;
import model.cours;
import model.justifiactif;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EtudiantJuAbs {

	public JFrame frame;
	private JTextField textFielddateAbs;
	private JTextField textField_ID;
	private JTextField textFieldtypejust;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtudiantJuAbs window = new EtudiantJuAbs();
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
	public EtudiantJuAbs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 773);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("DEPOT JUSTIFICATIF ETUDIANT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(309, 61, 333, 26);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("DateAbs");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(148, 161, 68, 26);
		frame.getContentPane().add(lblNewLabel_1_1);


		textFielddateAbs = new JTextField();
		textFielddateAbs.setColumns(10);
		textFielddateAbs.setBounds(448, 167, 244, 19);
		frame.getContentPane().add(textFielddateAbs);

		JLabel lblNewLabel_1_1_2 = new JLabel("ID");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(148, 281, 68, 26);
		frame.getContentPane().add(lblNewLabel_1_1_2);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(448, 287, 244, 19);
		frame.getContentPane().add(textField_ID);

		JLabel lblNewLabel_1_1_3_1 = new JLabel("Depot justificatif");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3_1.setBounds(146, 415, 164, 26);
		frame.getContentPane().add(lblNewLabel_1_1_3_1);

		textFieldtypejust = new JTextField();
		textFieldtypejust.setBounds(439, 417, 253, 115);
		frame.getContentPane().add(textFieldtypejust);
		textFieldtypejust.setColumns(10);

		JButton btnNewButton = new JButton("valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				justificatifdao util = new justificatifdao ();
				int idetudiant;
				String dateAbs;
				String typeJustificatif;



				dateAbs = textFielddateAbs.getText();
				typeJustificatif =textFieldtypejust.getText();
				idetudiant = Integer.parseInt( textField_ID.getText());
				justifiactif newUtil = new justifiactif(idetudiant,dateAbs,typeJustificatif);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "justificatif ajouté(e) avec succès");



			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(359, 614, 120, 31);
		frame.getContentPane().add(btnNewButton);
	}
}
