import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RegistrationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField txtUser;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPasword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Desktop\\userimage.jpg"));
		setTitle("Registration Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(198, 198, 255));
		contentPane.setForeground(new Color(166, 166, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 84, 90, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 421, 90, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(32, 176, 90, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(32, 206, 90, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(32, 263, 90, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(32, 133, 90, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("User Name:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(32, 316, 90, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(32, 369, 90, 13);
		contentPane.add(lblNewLabel_7);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(138, 88, 135, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(138, 205, 96, 19);
		contentPane.add(txtAge);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMobile.setColumns(10);
		txtMobile.setBounds(138, 262, 96, 19);
		contentPane.add(txtMobile);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(138, 130, 135, 19);
		contentPane.add(txtEmail);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUser.setColumns(10);
		txtUser.setBounds(132, 316, 96, 19);
		contentPane.add(txtUser);
		
		JTextArea txtAddr = new JTextArea();
		txtAddr.setFont(new Font("Monospaced", Font.BOLD, 14));
		txtAddr.setBounds(132, 430, 209, 61);
		contentPane.add(txtAddr);
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setBackground(new Color(189, 189, 255));
		rbMale.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rbMale);
		rbMale.setBounds(131, 168, 103, 21);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setBackground(new Color(215, 215, 255));
		buttonGroup.add(rbFemale);
		rbFemale.setBounds(252, 168, 103, 21);
		contentPane.add(rbFemale);
		
		txtPasword = new JPasswordField();
		txtPasword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPasword.setBounds(132, 366, 96, 19);
		contentPane.add(txtPasword);
		
		JButton btnValidate = new JButton("Submit");
		btnValidate.setForeground(new Color(0, 0, 0));
		btnValidate.setBackground(new Color(0, 255, 0));
		btnValidate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
					String query = "insert into registration values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setString(2, txtAddr.getText());
					if (rbMale.isSelected())
						ps.setString(3, rbMale.getText());
					else 
						ps.setString(3, rbFemale.getText());
					ps.setInt(4, Integer.parseInt(txtAge.getText()));
					ps.setString(5, txtMobile.getText());
					ps.setString(6, txtEmail.getText());
					ps.setString(7, txtUser.getText());
					ps.setString(8, txtPasword.getText());
					
					int i  = ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidate, i + "Record is successfully! updated");
					ps.close();
					con.close();
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnValidate.setBounds(64, 513, 121, 21);
		contentPane.add(btnValidate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtAddr.setText("");
				buttonGroup.clearSelection();
				txtAge.setText("");
				txtMobile.setText("");
				txtEmail.setText("");
				txtUser.setText("");
				txtPasword.setText("");
				txtName.setText("");
			}
		});
		btnReset.setBackground(new Color(255, 0, 0));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(256, 513, 85, 21);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_8 = new JLabel("Registration Form");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8.setBounds(132, 34, 184, 44);
		contentPane.add(lblNewLabel_8);
	}
}
