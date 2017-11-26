import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIisbn {

	private JFrame frmIsbnValidation;
	private JTextField ISBNtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIisbn window = new GUIisbn();
					window.frmIsbnValidation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIisbn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIsbnValidation = new JFrame();
		frmIsbnValidation.setTitle("ISBN Validation");
		frmIsbnValidation.setBounds(100, 100, 301, 202);
		frmIsbnValidation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIsbnValidation.getContentPane().setLayout(null);
		
		ISBNtf = new JTextField();
		ISBNtf.setFont(new Font("Tahoma", Font.BOLD, 13));
		ISBNtf.setBounds(10, 39, 269, 36);
		frmIsbnValidation.getContentPane().add(ISBNtf);
		ISBNtf.setColumns(10);
		
		JLabel lblEnterIsbn = new JLabel("Enter ISBN");
		lblEnterIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterIsbn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterIsbn.setBounds(85, 11, 92, 25);
		frmIsbnValidation.getContentPane().add(lblEnterIsbn);
		JLabel resultf = new JLabel("Result here");
		resultf.setHorizontalAlignment(SwingConstants.CENTER);
		resultf.setFont(new Font("Tahoma", Font.BOLD, 12));
		resultf.setBounds(56, 116, 178, 36);
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st =ISBNtf.getText();
				if(st.length()!=10)
				{
					resultf.setText("ISBN Length must be 10");
					return;
				}
				ISBNValidation isbn = new ISBNValidation(st);
				char q = isbn.findQ();
				if(!isbn.isValid())
				{
					resultf.setText("INVALID INPUT");
				}
				else if(q=='?')
				{
					resultf.setText("NO SOLUTION POSSIBLE");
				}
				else if(q=='s')
				{
					if( isbn.validate())
						resultf.setText("Already solved and is valid ");
					else
						resultf.setText("INVALID ISBN");
				}
				else
				{
					isbn.solve();
					resultf.setText("? = "+q+",  ISBN: "+isbn.toString());
				}
			}
		});
		btnCalculate.setBounds(99, 86, 89, 23);
		frmIsbnValidation.getContentPane().add(btnCalculate);
		
		
		frmIsbnValidation.getContentPane().add(resultf);
	}
}
