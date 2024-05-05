package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import DAO.absencedao;
import DAO.coursdao;
import model.Absence;
import model.cours;

public class declareabsence {

	public JFrame frame;
	private JTextField textFieldTYPEABS;
	private JTextField textField_DATEABS;
	private JTextField textField_VOLUMEHO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					declareabsence window = new declareabsence();
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
	public declareabsence() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("DECLARER ABSCENCE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(279, 49, 291, 29);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				absencedao util = new absencedao ();
				String typeAbs;
				int volumeHoraire;
				String dateAbs;

				typeAbs = textFieldTYPEABS.getText();
				dateAbs = textField_DATEABS.getText();
				volumeHoraire=  Integer.parseInt(textField_VOLUMEHO.getText());
				Absence newUtil = new Absence(dateAbs,typeAbs,volumeHoraire);
				util.ajouterAbsence(newUtil);
				JOptionPane.showMessageDialog(null, "absence ajouté(e) avec succès");




			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(337, 405, 108, 32);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("TYPE ABSENCE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(166, 153, 108, 29);
		frame.getContentPane().add(lblNewLabel_3);

		textFieldTYPEABS = new JTextField();
		textFieldTYPEABS.setBounds(389, 159, 96, 19);
		frame.getContentPane().add(textFieldTYPEABS);
		textFieldTYPEABS.setColumns(10);

		textField_DATEABS = new JTextField();
		textField_DATEABS.setBounds(389, 232, 96, 19);
		frame.getContentPane().add(textField_DATEABS);
		textField_DATEABS.setColumns(10);

		textField_VOLUMEHO = new JTextField();
		textField_VOLUMEHO.setBounds(389, 306, 96, 19);
		frame.getContentPane().add(textField_VOLUMEHO);
		textField_VOLUMEHO.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("VOLUME HORAIRE");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(166, 300, 118, 29);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("DATE ABSENCE");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(166, 231, 108, 19);
		frame.getContentPane().add(lblNewLabel_3_2);
	}
}
