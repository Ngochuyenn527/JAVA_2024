package view;

import connection.ForgotPasswordDao;
import connection.UserDao;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class ForgotPass extends javax.swing.JFrame {

	Color notEdit = new Color(204, 204, 204);
	Color edit = new Color(255, 255, 255);

	public ForgotPass() {
		initComponents();
		this.setLocationRelativeTo(null); // background center
		setIconImage(Toolkit.getDefaultToolkit().getImage(ForgotPass.class.getResource("/icons/ypp.png")));
		setTitle("Forgot Password");
		init();

		lblOk2F.setVisible(false);
		lblOk3F.setVisible(false);
		lblOk4F.setVisible(false);
	}

	ForgotPasswordDao fg = new ForgotPasswordDao();

	private void init() {
		txtPasswordF.setBackground(notEdit);
		txtPasswordF.setEditable(false);
		txtVerifyPasswordF.setBackground(notEdit);
		txtVerifyPasswordF.setEditable(false);
		txtCode.setBackground(notEdit);
		txtCode.setEditable(false);
	}

	public boolean isEmpty() {
		if (txtEmailF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Email is required to search", "Warning", 2);
			return false;
		}

		if (String.valueOf(txtPasswordF.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Password is required", "Warning", 2);
			return false;
		}

		if (String.valueOf(txtVerifyPasswordF.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Verify password is required", "Warning", 2);
			return false;
		}

		if (txtCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Captcha code is required", "Warning", 2);
			return false;
		}
		return true;

	}

	public boolean checkEmailExist() {
		if (!lblErrorEmailF.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Email adddress doesn't exists", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public boolean checkValidation() {
		// kiểm tra password.
		if (!lblErrorPassF.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Password does not match.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!txtCode.getText().equalsIgnoreCase(txtCaptchaF.getText())) {
			JOptionPane.showMessageDialog(this, "Captcha code does not match.", "Error",
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
		txtEmailF = new javax.swing.JTextField();
		btnSave = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();
		jLabel8 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		lblEmailF = new javax.swing.JLabel();
		lblNewPassword = new javax.swing.JLabel();
		lblVisibleEye1 = new javax.swing.JLabel();
		lblHideEye1 = new javax.swing.JLabel();
		txtPasswordF = new javax.swing.JPasswordField();
		lblSearch = new javax.swing.JLabel();
		lblVerifyPasswordF = new javax.swing.JLabel();
		txtVerifyPasswordF = new javax.swing.JPasswordField();
		lblVisibleEye2 = new javax.swing.JLabel();
		lblHideEye2 = new javax.swing.JLabel();
		lblErrorEmailF = new javax.swing.JLabel();
		lblErrorPassF = new javax.swing.JLabel();
		lblOk2F = new javax.swing.JLabel();
		lblOk3F = new javax.swing.JLabel();
		lblOk4F = new javax.swing.JLabel();
		txtCaptchaF = new javax.swing.JTextField();
		lblOTPCode = new javax.swing.JLabel();
		txtCode = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setIconImages(null);
		setResizable(false);

		jPanel1.setBackground(new Color(224, 255, 255));

		txtEmailF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		txtEmailF.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtEmailFKeyReleased(evt);
			}
		});

		btnSave.setBackground(new java.awt.Color(0, 153, 255));
		btnSave.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnSave.setForeground(new java.awt.Color(255, 255, 255));
		btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
		btnSave.setText("Save");
		btnSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSaveActionPerformed(evt);
			}
		});

		btnBack.setBackground(new java.awt.Color(255, 51, 51));
		btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnBack.setForeground(new java.awt.Color(255, 255, 255));
		btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
		btnBack.setText("Back");
		btnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnBackActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
		jLabel1.setText("Forgot Password");

		lblEmailF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblEmailF.setText("Email");

		lblNewPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblNewPassword.setText("New Password");

		lblVisibleEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
		lblVisibleEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblVisibleEye1MouseClicked(evt);
			}
		});

		lblHideEye1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
		lblHideEye1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHideEye1MouseClicked(evt);
			}
		});

		txtPasswordF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		txtPasswordF.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtPasswordFKeyReleased(evt);
			}
		});

		lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
		lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblSearchMouseClicked(evt);
			}
		});

		lblVerifyPasswordF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblVerifyPasswordF.setText("Verify Password");

		txtVerifyPasswordF.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		txtVerifyPasswordF.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtVerifyPasswordFKeyReleased(evt);
			}
		});

		lblVisibleEye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
		lblVisibleEye2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblVisibleEye2MouseClicked(evt);
			}
		});

		lblHideEye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
		lblHideEye2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHideEye2MouseClicked(evt);
			}
		});

		lblErrorEmailF.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorEmailF.setForeground(new java.awt.Color(255, 0, 0));

		lblErrorPassF.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorPassF.setForeground(new java.awt.Color(255, 0, 0));

		lblOk2F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblOk3F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblOk4F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		txtCaptchaF.setEditable(false);
		txtCaptchaF.setBackground(new java.awt.Color(204, 204, 204));
		txtCaptchaF.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
		txtCaptchaF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtCaptchaF.setText("neyu7");

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

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jLabel1)
								.addGap(138, 138, 138))
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(75, 75, 75)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtPasswordF, javax.swing.GroupLayout.PREFERRED_SIZE, 391,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5)
												.addComponent(lblNewPassword))
										.addGroup(jPanel1Layout
												.createSequentialGroup().addGap(375, 375, 375).addComponent(lblOk3F)))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblHideEye1).addComponent(lblVisibleEye1)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
								.addComponent(lblVerifyPasswordF).addGap(41, 41, 41).addComponent(lblErrorPassF)
								.addGap(160, 160, 160).addComponent(lblOk4F))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
								.addComponent(txtVerifyPasswordF, javax.swing.GroupLayout.PREFERRED_SIZE, 391,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(19, 19, 19)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblVisibleEye2).addComponent(lblHideEye2)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(lblOTPCode))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(516, 516, 516).addComponent(jLabel8))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup().addGap(80, 80, 80).addComponent(lblEmailF)
												.addGap(169, 169, 169).addComponent(lblErrorEmailF)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblOk2F))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup().addGap(75, 75, 75).addComponent(txtEmailF,
												javax.swing.GroupLayout.PREFERRED_SIZE, 391,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18).addComponent(lblSearch))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(80, 80, 80)
								.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(80, 80, 80)
								.addComponent(txtCaptchaF, javax.swing.GroupLayout.PREFERRED_SIZE, 160,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20).addComponent(jLabel6))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(117, 117, 117)
								.addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 121,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(60, 60, 60).addComponent(btnBack)))
						.addContainerGap(25, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(39, 39, 39)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblEmailF)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblOk2F).addComponent(lblErrorEmailF))))
								.addGap(1, 1, 1)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtEmailF, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout
												.createSequentialGroup().addGap(12, 12, 12).addComponent(lblSearch)))
								.addGap(53, 53, 53)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(
												txtPasswordF, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout
												.createSequentialGroup().addGap(3, 3, 3).addComponent(lblNewPassword))
										.addComponent(lblOk3F)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(28, 28, 28)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblHideEye1).addComponent(lblVisibleEye1))))
								.addGap(52, 52, 52)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblVerifyPasswordF)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblErrorPassF).addComponent(lblOk4F))))
								.addGap(1, 1, 1)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtVerifyPasswordF, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblVisibleEye2).addComponent(lblHideEye2))))
								.addGap(47, 47, 47)
								.addComponent(lblOTPCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCaptchaF, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10)
												.addComponent(jLabel6)))
								.addGap(21, 21, 21).addComponent(jLabel8).addGap(51, 51, 51)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(79, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		new Login().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_btnBackActionPerformed

	private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblSearchMouseClicked
		// TODO add your handling code here:
		if (checkEmailExist()) {
			txtEmailF.setBackground(notEdit);
			txtEmailF.setEditable(false);
			txtPasswordF.setBackground(edit);
			txtPasswordF.setEditable(true);
			txtVerifyPasswordF.setBackground(edit);
			txtVerifyPasswordF.setEditable(true);
			txtCode.setBackground(edit);
			txtCode.setEditable(true);
		}
	}// GEN-LAST:event_lblSearchMouseClicked

	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
		// TODO add your handling code here:
		String email = txtEmailF.getText();
		String pass = String.valueOf(txtPasswordF.getPassword());
		if (isEmpty()) {
			if (checkValidation()) {
				fg.setNewPassword(email, pass);
				new Login().setVisible(true);
				this.dispose();
			}
		}
	}// GEN-LAST:event_btnSaveActionPerformed

	private void lblHideEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye1MouseClicked
		// TODO add your handling code here:
		txtPasswordF.setEchoChar((char) 0);
		lblHideEye1.setVisible(false);
		lblVisibleEye1.setVisible(true);
	}// GEN-LAST:event_lblHideEye1MouseClicked

	private void lblVisibleEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye1MouseClicked
		// TODO add your handling code here:
		txtPasswordF.setEchoChar('*');
		lblHideEye1.setVisible(true);
		lblVisibleEye1.setVisible(false);
	}// GEN-LAST:event_lblVisibleEye1MouseClicked

	private void lblVisibleEye2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye2MouseClicked
		// TODO add your handling code here:
		txtVerifyPasswordF.setEchoChar('*');
		lblHideEye2.setVisible(true);
		lblVisibleEye2.setVisible(false);
	}// GEN-LAST:event_lblVisibleEye2MouseClicked

	private void lblHideEye2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye2MouseClicked
		// TODO add your handling code here:
		txtVerifyPasswordF.setEchoChar((char) 0);
		lblHideEye2.setVisible(false);
		lblVisibleEye2.setVisible(true);
	}// GEN-LAST:event_lblHideEye2MouseClicked

	private void txtEmailFKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtEmailFKeyReleased
		// TODO add your handling code here:
		String email = txtEmailF.getText();
		fg.txtEmailKeyReleased(email);

	}// GEN-LAST:event_txtEmailFKeyReleased

	private void txtPasswordFKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtPasswordFKeyReleased
		// TODO add your handling code here:
		fg.jPasswordField1KeyReleased();

	}// GEN-LAST:event_txtPasswordFKeyReleased

	private void txtVerifyPasswordFKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtVerifyPasswordFKeyReleased
		// TODO add your handling code here:
		fg.jPasswordField2KeyReleased();
	}// GEN-LAST:event_txtVerifyPasswordFKeyReleased

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
		// TODO add your handling code here:
		txtCaptchaF.setText(new UserDao().createCaptchaValue());
	}// GEN-LAST:event_jLabel6MouseClicked

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ForgotPass().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnSave;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblEmailF;
	public static javax.swing.JLabel lblErrorEmailF;
	public static javax.swing.JLabel lblErrorPassF;
	private javax.swing.JLabel lblHideEye1;
	private javax.swing.JLabel lblHideEye2;
	private javax.swing.JLabel lblNewPassword;
	private javax.swing.JLabel lblOTPCode;
	public static javax.swing.JLabel lblOk2F;
	public static javax.swing.JLabel lblOk3F;
	public static javax.swing.JLabel lblOk4F;
	private javax.swing.JLabel lblSearch;
	private javax.swing.JLabel lblVerifyPasswordF;
	private javax.swing.JLabel lblVisibleEye1;
	private javax.swing.JLabel lblVisibleEye2;
	private javax.swing.JTextField txtCaptchaF;
	private javax.swing.JTextField txtCode;
	public static javax.swing.JTextField txtEmailF;
	public static javax.swing.JPasswordField txtPasswordF;
	public static javax.swing.JPasswordField txtVerifyPasswordF;
	// End of variables declaration//GEN-END:variables
}
