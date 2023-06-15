package LoginTCP;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JframeLogin extends JFrame  {

	
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP";
    String user = "sa";
	String pass = "phanvanhieu01102004";
	Statement st ;
	ResultSet rs ;
	
	
	private JPanel contentPane;
	public JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeLogin frame = new JframeLogin();
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
	public JframeLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(89, 231, 304, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		URL urlIcon_image = JframeLogin.class.getResource("mess.png") ;
		URL urlIcon_image_lock = JframeLogin.class.getResource("lock.png") ;
		URL urlIcon_image_key = JframeLogin.class.getResource("key.png") ;
		URL urlIcon_image_User = JframeLogin.class.getResource("User.png") ;
		URL urlIcon_image_register = JframeLogin.class.getResource("register.png") ;
		Image img = Toolkit.getDefaultToolkit().createImage(urlIcon_image);
		this.setIconImage(img);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")) {
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setBounds(10, 10, 230, 34);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUser = new JLabel("");
		lblIconUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUser.setBounds(254, 0, 40, 54);
		panel.add(lblIconUser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(89, 309, 304, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('●');
					txtPassword.setText("");
				}else {
					txtPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setText("Password");
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPassword.setHorizontalAlignment(SwingConstants.LEFT);
		txtPassword.setBounds(10, 10, 230, 34);
		panel_1.add(txtPassword);
		
		JLabel lblIconPass = new JLabel("");
		lblIconPass.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIconPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPass.setBounds(254, 0, 40, 54);
		panel_1.add(lblIconPass);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("phieu0110@gmail.com") && txtPassword.getText().equals("01102004")||
						(txtUsername.getText().equals("0796609752") && txtPassword.getText().equals("123456"))) {
					lblLoginMessage.setText("");
					JOptionPane.showConfirmDialog(null, "Login Successfull");
					
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") ||
						txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
					lblLoginMessage.setText("Please input all requirement !");
				}else {
					lblLoginMessage.setText("Username and password didn't match!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(60, 80, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(30, 60, 60));
			}
		});
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		pnlBtnLogin.setBounds(89, 421, 304, 77);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 22, 118, 34);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setBounds(28, 10, 66, 54);
		pnlBtnLogin.add(lblIconLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					JframeLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.red);
			}
		});
		lblX.setForeground(Color.RED);
		lblX.setHorizontalAlignment(SwingConstants.LEFT);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBounds(449, 0, 19, 32);
		contentPane.add(lblX);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(89, 23, 304, 198);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(urlIcon_image));
		lblIconUser.setIcon(new ImageIcon(urlIcon_image_User));
//		lblIconUser.setSize(40,40);
		lblIconPass.setIcon(new ImageIcon(urlIcon_image_lock));
		lblIconLogin.setIcon(new ImageIcon(urlIcon_image_key));
//		lblIconRegister.setIcon(new ImageIcon(urlIcon_image_register));

		
		lblLoginMessage.setForeground(new Color(165, 42, 42));
		lblLoginMessage.setFont(new Font("Arial", Font.PLAIN, 13));
		lblLoginMessage.setBounds(89, 373, 304, 23);
		contentPane.add(lblLoginMessage);
		
		JLabel lblNewLabel_1 = new JLabel("+ THÊM TÀI KHOẢN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(25, 10, 304, 32);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
	}
}
