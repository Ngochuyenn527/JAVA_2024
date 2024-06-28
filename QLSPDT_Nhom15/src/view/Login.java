package view;

import connection.MyConnection;
import connection.UserDao;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class Login extends javax.swing.JFrame {

	public Login() {
		initComponents();
		this.setLocationRelativeTo(null); // background center
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/icons/ypp.png")));
		setTitle("Login");
		lblOk1.setVisible(false);
		lblOk2.setVisible(false);
		lblErrorUsernameL.setVisible(false);
		lblErrorPassL.setVisible(false);
	}

	private boolean isEmpty() {
		if (txtUsername.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Username is required", "Warning", 2);
			return false;
		}
		if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Password is required", "Warning", 2);
			return false;
		}

		if (txtCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Captcha code is required", "Warning", 2);
			return false;
		}
		return true;
	}

	/**
	 * kiểm tra tính hợp lệ
	 *
	 * @return
	 */
	public boolean checkValidation() {
		// kiểm tra tính hợp lệ của username.
		if (!lblErrorUsernameL.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Incorrect username. Please enter username again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// kiểm tra password.
		if (!lblErrorPassL.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Incorrect password. Please enter password again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		//kiểm tra mã captcha
		if (!txtCode.getText().equalsIgnoreCase(txtCaptchaL.getText())) {
			JOptionPane.showMessageDialog(this, "Captcha code does not match. Please enter code again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		lblCaption = new javax.swing.JLabel();
		lblUsername = new javax.swing.JLabel();
		txtUsername = new javax.swing.JTextField();
		lblPassword = new javax.swing.JLabel();
		btnLogin = new javax.swing.JButton();
		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel9 = new javax.swing.JLabel();
		lblSignUp = new javax.swing.JLabel();
		lblForgotPassword = new javax.swing.JLabel();
		lblHideEye1 = new javax.swing.JLabel();
		lblVisibleEye1 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		lblErrorUsernameL = new javax.swing.JLabel();
		lblErrorPassL = new javax.swing.JLabel();
		lblOk1 = new javax.swing.JLabel();
		lblOk2 = new javax.swing.JLabel();
		txtCaptchaL = new javax.swing.JTextField();
		lblOTPCode = new javax.swing.JLabel();
		txtCode = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImages(null);
		setResizable(false);

		jPanel1.setBackground(new Color(224, 255, 255));

		jLabel2.setIcon(new ImageIcon(Login.class.getResource("/icons/ypp.png"))); // NOI18N

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		jLabel1.setText("WELCOME TO");

		jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		jLabel3.setText("YP");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(33).addComponent(jLabel2,
										GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(56).addComponent(jLabel1))
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(195).addComponent(jLabel3)))
						.addContainerGap(63, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(62, Short.MAX_VALUE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(jLabel1).addGap(45).addComponent(jLabel3).addGap(160)));
		jPanel1.setLayout(jPanel1Layout);

		jPanel2.setBackground(new Color(255, 255, 240));

		lblCaption.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
		lblCaption.setText("Login");

		lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblUsername.setText("Username");

		txtUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		txtUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtUsernameKeyReleased(evt);
			}
		});

		lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblPassword.setText("Password");

		btnLogin.setBackground(new java.awt.Color(0, 153, 255));
		btnLogin.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/loginn.png"))); // NOI18N
		btnLogin.setText("Login");
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLoginActionPerformed(evt);
			}
		});

		jPasswordField1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				jPasswordField1KeyReleased(evt);
			}
		});

		jLabel9.setBackground(new java.awt.Color(255, 204, 102));
		jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		jLabel9.setForeground(new java.awt.Color(0, 102, 102));
		jLabel9.setText("Don't have an account?");

		lblSignUp.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblSignUp.setForeground(new java.awt.Color(0, 153, 153));
		lblSignUp.setText("Sign Up");
		lblSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblSignUpMouseClicked(evt);
			}
		});

		lblForgotPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblForgotPassword.setForeground(new java.awt.Color(0, 153, 153));
		lblForgotPassword.setText("Forgotten Password?");
		lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblForgotPasswordMouseClicked(evt);
			}
		});

		lblHideEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
		lblHideEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHideEye1MouseClicked(evt);
			}
		});

		lblVisibleEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
		lblVisibleEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblVisibleEye1MouseClicked(evt);
			}
		});

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N

		lblErrorUsernameL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorUsernameL.setForeground(new java.awt.Color(255, 0, 51));
		lblErrorUsernameL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblErrorUsernameL.setText("error");

		lblErrorPassL.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorPassL.setForeground(new java.awt.Color(255, 0, 0));
		lblErrorPassL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblErrorPassL.setText("Incorrect password");

		lblOk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblOk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		txtCaptchaL.setEditable(false);
		txtCaptchaL.setBackground(new java.awt.Color(204, 204, 204));
		txtCaptchaL.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
		txtCaptchaL.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtCaptchaL.setText("neyu7");

		lblOTPCode.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblOTPCode.setText("Enter Captcha code");

		txtCode.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtCode.setActionCommand("40");

		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reload.png"))); // NOI18N
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel6MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(71, 71, 71)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(lblErrorPassL)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(lblOk2))
										.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 403,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblVisibleEye1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHideEye1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(70, 70, 70).addComponent(lblPassword))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(70, 70, 70).addComponent(lblOTPCode))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(70, 70, 70)
								.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(80, 80, 80)
								.addComponent(txtCaptchaL, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(30, 30, 30).addComponent(jLabel6))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(126, 126, 126).addComponent(jLabel9)
								.addGap(50, 50, 50).addComponent(lblSignUp))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(70, 70, 70)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(lblUsername)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblErrorUsernameL)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(lblOk1))
										.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 403,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(21, 21, 21).addComponent(jLabel5))
						.addGroup(jPanel2Layout.createSequentialGroup().addGap(203, 203, 203)
								.addComponent(lblForgotPassword)))
						.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel2Layout.createSequentialGroup().addComponent(lblCaption)
														.addGap(216, 216, 216))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel2Layout.createSequentialGroup()
														.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE,
																220, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(176, 176, 176)))));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42).addComponent(lblCaption)
						.addGap(32, 32, 32)
						.addGroup(jPanel2Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(lblUsername).addComponent(lblErrorUsernameL))
												.addComponent(lblOk1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel5).addComponent(txtUsername,
														javax.swing.GroupLayout.PREFERRED_SIZE, 50,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(43, 43, 43)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblPassword).addComponent(lblErrorPassL)))
								.addComponent(lblOk2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(28, 28, 28))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createSequentialGroup()
												.addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblVisibleEye1).addComponent(lblHideEye1))
												.addGap(38, 38, 38)))
						.addComponent(lblOTPCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(10, 10, 10)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCaptchaL, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(
										jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(jLabel6)))
						.addGap(33, 33, 33)
						.addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(lblSignUp))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(lblForgotPassword).addContainerGap(44, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 457, Short.MAX_VALUE).addComponent(
								jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(575, 575, 575))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
		// TODO add your handling code here:
		if (isEmpty()) {
			if (checkValidation()) {
				JOptionPane.showMessageDialog(this, "Login succcessfully!");
				MainMenu ud = new MainMenu();
				ud.setVisible(true);
				this.dispose();
			}
		}
	}// GEN-LAST:event_btnLoginActionPerformed

	private void lblSignUpMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblSignUpMouseClicked
		// TODO add your handling code here:
		new SignUp().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_lblSignUpMouseClicked

	private void lblForgotPasswordMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblForgotPasswordMouseClicked
		// TODO add your handling code here:
		new ForgotPass().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_lblForgotPasswordMouseClicked

	private void lblHideEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye1MouseClicked
		// TODO add your handling code here:
		jPasswordField1.setEchoChar((char) 0);
		lblHideEye1.setVisible(false);
		lblVisibleEye1.setVisible(true);
	}// GEN-LAST:event_lblHideEye1MouseClicked

	private void lblVisibleEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye1MouseClicked
		// TODO add your handling code here:
		jPasswordField1.setEchoChar('*');
		lblHideEye1.setVisible(true);
		lblVisibleEye1.setVisible(false);
	}// GEN-LAST:event_lblVisibleEye1MouseClicked

	private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtUsernameKeyReleased
		// TODO add your handling code here:
		String username = txtUsername.getText();
		try {
			Connection con = MyConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where uname = '" + username + "' ");

			// username đã tồn tại
			if (rs.next()) {
				lblErrorUsernameL.setText("");
				txtUsername.setForeground(new Color(0, 102, 51));
				lblErrorUsernameL.setVisible(false);
				// khi txtUsername bỏ trống 0 điền gì thì lblOk sẽ biến mất
				if (username.equalsIgnoreCase("")) {
					lblOk1.setVisible(false);
				} else {
					lblOk1.setVisible(true);
				}
			} // username hợp lệ
			else {
				// kiểm tra tên người dùng phải dài hơn 5 ký tự
				int length = username.length();
				if (length < 5) {
					lblErrorUsernameL.setText("Username must be longer than 5 char");
					txtUsername.setForeground(Color.red);
					lblErrorUsernameL.setVisible(true);
					lblOk1.setVisible(false);
				} else {
					lblErrorUsernameL.setText("Sorry..Username does not exists");
					txtUsername.setForeground(Color.red);
					lblErrorUsernameL.setVisible(true);
					lblOk1.setVisible(false);
				}
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_txtUsernameKeyReleased

	private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jPasswordField1KeyReleased
		// TODO add your handling code here:
		String username = txtUsername.getText();
		String password = String.valueOf(jPasswordField1.getPassword());
		try {
			Connection con = MyConnection.getConnection();

			// Câu truy vấn SQL với tham số
			String sql = "SELECT * FROM user where uname = ? and upassword = ?";

			// Tạo PreparedStatement Đảm bảo import java.sql.Connection chứ không phải
			// com.sun.jdi.connect.spi.Connection.
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				lblErrorPassL.setText("");
				jPasswordField1.setForeground(new Color(0, 102, 51));
				lblErrorPassL.setVisible(false);
				// khi txtUsername bỏ trống 0 điền gì thì lblOk sẽ biến mất
				if (username.equalsIgnoreCase("")) {
					lblOk2.setVisible(false);
				} else {
					lblOk2.setVisible(true);
				}
			} else {
				lblErrorPassL.setText("Incorrect password");
				jPasswordField1.setForeground(Color.red);
				lblErrorPassL.setVisible(true);
				lblOk2.setVisible(false);
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_jPasswordField1KeyReleased

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
		// TODO add your handling code here:
		txtCaptchaL.setText(new UserDao().createCaptchaValue());
	}// GEN-LAST:event_jLabel6MouseClicked

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLogin;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JLabel lblCaption;
	private javax.swing.JLabel lblErrorPassL;
	private javax.swing.JLabel lblErrorUsernameL;
	private javax.swing.JLabel lblForgotPassword;
	private javax.swing.JLabel lblHideEye1;
	private javax.swing.JLabel lblOTPCode;
	private javax.swing.JLabel lblOk1;
	private javax.swing.JLabel lblOk2;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblSignUp;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JLabel lblVisibleEye1;
	private javax.swing.JTextField txtCaptchaL;
	private javax.swing.JTextField txtCode;
	private javax.swing.JTextField txtUsername;
	// End of variables declaration//GEN-END:variables
}
