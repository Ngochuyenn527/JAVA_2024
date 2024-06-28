package view;

import connection.*;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class SignUp extends javax.swing.JFrame {

	public SignUp() {
		initComponents();
		this.setLocationRelativeTo(null); // background center
		init();

		lblOk1.setVisible(false);
		lblOk2.setVisible(false);
		lblOk3.setVisible(false);
		lblOk4.setVisible(false);
		lblOk5.setVisible(false);
	}

	UserDao user = new UserDao();

	/**
	 * set thuộc tính cho trường ID
	 */
	private void init() {
		txtId.setBackground(new Color(204, 204, 204));
		txtId.setEditable(false);
		txtId.setText(String.valueOf(user.getMaxRow()));
	}

	/**
	 * kiểm tra các trường bị bỏ trống
	 *
	 * @return
	 */
	public boolean isEmpty() {
		if (txtUsername.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Username is required", "Warning", 2);
			return false;
		}

		if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Email is required", "Warning", 2);
			return false;
		}

		if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Password is required", "Warning", 2);
			return false;
		}

		if (String.valueOf(txtVerifyPassword.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Verify password is required", "Warning", 2);
			return false;
		}

		if (txtPhone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Phone number is required", "Warning", 2);
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
		if (!lblErrorUsername.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Invalid username. Please enter username again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// kiểm tra tính hợp lệ của địa chỉ email.
		if (!lblErrorEmail.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Invalid email address. Please enter email again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// kiểm tra password.
		if (!lblErrorPass.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Password does not match. Please enter password again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// sđt phải bắt đầu bằng số 0 và có 10 chữ số
		if (!lblErrorPhone.getText().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter phone number again", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (!txtCode.getText().equalsIgnoreCase(txtCaptchaS.getText())) {
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
		lblPhone = new javax.swing.JLabel();
		txtUsername = new javax.swing.JTextField();
		txtEmail = new javax.swing.JTextField();
		txtPassword = new javax.swing.JPasswordField();
		btnSave = new javax.swing.JButton();
		btnBack = new javax.swing.JButton();
		txtPhone = new javax.swing.JTextField();
		lblSignUp = new javax.swing.JLabel();
		lblUsername = new javax.swing.JLabel();
		lblEmail = new javax.swing.JLabel();
		lblPassword = new javax.swing.JLabel();
		lblId = new javax.swing.JLabel();
		txtId = new javax.swing.JTextField();
		lblHideEye1 = new javax.swing.JLabel();
		lblVisibleEye1 = new javax.swing.JLabel();
		lblVerifyPassword = new javax.swing.JLabel();
		txtVerifyPassword = new javax.swing.JPasswordField();
		lblHideEye2 = new javax.swing.JLabel();
		lblVisibleEye2 = new javax.swing.JLabel();
		lblOTPCode = new javax.swing.JLabel();
		txtCode = new javax.swing.JTextField();
		lblErrorUsername = new javax.swing.JLabel();
		lblOk1 = new javax.swing.JLabel();
		lblErrorEmail = new javax.swing.JLabel();
		lblOk3 = new javax.swing.JLabel();
		lblOk4 = new javax.swing.JLabel();
		lblOk5 = new javax.swing.JLabel();
		lblErrorPass = new javax.swing.JLabel();
		lblErrorPhone = new javax.swing.JLabel();
		lblOk2 = new javax.swing.JLabel();
		txtCaptchaS = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/icons/ypp.png")));
		setTitle("Sign Up");

		jPanel1.setBackground(new Color(224, 255, 255));

		lblPhone.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblPhone.setText("Phone");

		txtUsername.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtUsernameKeyReleased(evt);
			}
		});

		txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtEmailKeyReleased(evt);
			}
		});

		txtPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtPassword.setActionCommand("40");
		txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtPasswordKeyReleased(evt);
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

		txtPhone.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtPhone.setActionCommand("40");
		txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtPhoneKeyReleased(evt);
			}
		});

		lblSignUp.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
		lblSignUp.setText("Sign Up");

		lblUsername.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblUsername.setText("Username");

		lblEmail.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblEmail.setText("Email");

		lblPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblPassword.setText("Password");

		lblId.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblId.setText("Id");

		txtId.setEditable(false);
		txtId.setBackground(new java.awt.Color(204, 204, 204));
		txtId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

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

		lblVerifyPassword.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblVerifyPassword.setText("Verify Password");

		txtVerifyPassword.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtVerifyPassword.setActionCommand("40");
		txtVerifyPassword.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtVerifyPasswordKeyReleased(evt);
			}
		});

		lblHideEye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hide.png"))); // NOI18N
		lblHideEye2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblHideEye2MouseClicked(evt);
			}
		});

		lblVisibleEye2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/visible.png"))); // NOI18N
		lblVisibleEye2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				lblVisibleEye2MouseClicked(evt);
			}
		});

		lblOTPCode.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		lblOTPCode.setText("Enter Captcha code");

		txtCode.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		txtCode.setActionCommand("40");

		lblErrorUsername.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorUsername.setForeground(new java.awt.Color(255, 0, 0));

		lblOk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblErrorEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorEmail.setForeground(new java.awt.Color(255, 0, 0));

		lblOk3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblOk4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblOk5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		lblErrorPass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorPass.setForeground(new java.awt.Color(255, 0, 0));

		lblErrorPhone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		lblErrorPhone.setForeground(new java.awt.Color(255, 0, 0));

		lblOk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tick.png"))); // NOI18N

		txtCaptchaS.setEditable(false);
		txtCaptchaS.setBackground(new java.awt.Color(204, 204, 204));
		txtCaptchaS.setFont(new java.awt.Font("Lucida Handwriting", 2, 24)); // NOI18N
		txtCaptchaS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtCaptchaS.setText("neyu7");

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reload.png"))); // NOI18N
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(88, 88, 88).addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(txtId,
								javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId)
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup().addComponent(lblPassword)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblOk3))
												.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup().addComponent(lblEmail)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblErrorEmail)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(lblOk2))))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblUsername)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblErrorUsername)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblOk1)))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblHideEye1).addComponent(lblVisibleEye1)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblVerifyPassword)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														jPanel1Layout.createSequentialGroup().addComponent(lblErrorPass)
																.addGap(22, 22, 22))
												.addComponent(lblOk4, javax.swing.GroupLayout.Alignment.TRAILING)))
								.addComponent(txtVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lblHideEye2).addComponent(lblVisibleEye2)))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblOTPCode).addGap(284,
										284, 284))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup()
														.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE,
																155, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(90, 90, 90).addComponent(txtCaptchaS,
																javax.swing.GroupLayout.PREFERRED_SIZE, 155,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout
														.createSequentialGroup().addComponent(lblPhone)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGroup(jPanel1Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(lblErrorPhone,
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(lblOk5,
																		javax.swing.GroupLayout.Alignment.TRAILING)))
												.addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 400,
														javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18).addComponent(jLabel1)))))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(140, 140, 140).addComponent(btnSave)
						.addGap(54, 54, 54).addComponent(btnBack))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(228, 228, 228).addComponent(lblSignUp)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(lblSignUp)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblId)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(40, 40, 40)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(lblUsername).addComponent(lblErrorUsername,
														javax.swing.GroupLayout.PREFERRED_SIZE, 16,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblOk1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(37, 37, 37)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(lblErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 19,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(3, 3, 3)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(lblOk2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblPassword)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
														.addComponent(lblVisibleEye1).addComponent(lblHideEye1))))
								.addComponent(lblOk3))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(lblErrorPass)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblOk4))
								.addComponent(lblVerifyPassword))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(txtVerifyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,
												Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(lblPhone, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(lblErrorPhone)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(lblOk5))))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
												.addComponent(lblVisibleEye2).addComponent(lblHideEye2))
										.addGap(0, 0, Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(lblOTPCode)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel1Layout.createSequentialGroup().addComponent(jLabel1).addGap(133, 133,
												133))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCaptchaS, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 59,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(30, 30, 30)))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		new Login().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_btnBackActionPerformed

	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveActionPerformed
		// TODO add your handling code here:
		int id = Integer.parseInt(txtId.getText());
		String username = txtUsername.getText();
		String email = txtEmail.getText();
		String password = String.valueOf(txtPassword.getPassword());
		String phone = txtPhone.getText();
		if (isEmpty()) {
			if (checkValidation()) {
				user.insert(id, username, email, password, phone);
				new Login().setVisible(true);
				this.dispose();
			}
		}
	}// GEN-LAST:event_btnSaveActionPerformed

	private void lblHideEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye1MouseClicked
		// TODO add your handling code here:
		txtPassword.setEchoChar((char) 0);
		lblHideEye1.setVisible(false);
		lblVisibleEye1.setVisible(true);
	}// GEN-LAST:event_lblHideEye1MouseClicked

	private void lblVisibleEye1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye1MouseClicked
		// TODO add your handling code here:
		txtPassword.setEchoChar('*');
		lblHideEye1.setVisible(true);
		lblVisibleEye1.setVisible(false);
	}// GEN-LAST:event_lblVisibleEye1MouseClicked

	private void lblHideEye2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblHideEye2MouseClicked
		// TODO add your handling code here:
		txtVerifyPassword.setEchoChar((char) 0);
		lblHideEye2.setVisible(false);
		lblVisibleEye2.setVisible(true);
	}// GEN-LAST:event_lblHideEye2MouseClicked

	private void lblVisibleEye2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblVisibleEye2MouseClicked
		// TODO add your handling code here:
		txtVerifyPassword.setEchoChar('*');
		lblHideEye2.setVisible(true);
		lblVisibleEye2.setVisible(false);
	}// GEN-LAST:event_lblVisibleEye2MouseClicked

	private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtUsernameKeyReleased
		// TODO add your handling code here:
		// user name check
		String username = txtUsername.getText();
		user.txtUsernameKeyReleased(username);
	}// GEN-LAST:event_txtUsernameKeyReleased

	private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtEmailKeyReleased
		// TODO add your handling code here:
		String email = txtEmail.getText();
		user.txtEmailKeyReleased(email);
	}// GEN-LAST:event_txtEmailKeyReleased

	private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtPasswordKeyReleased
		// TODO add your handling code here:
		user.jPasswordField1KeyReleased();
	}// GEN-LAST:event_txtPasswordKeyReleased

	private void txtVerifyPasswordKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtVerifyPasswordKeyReleased
		// TODO add your handling code here:
		user.jPasswordField2KeyReleased();
	}// GEN-LAST:event_txtVerifyPasswordKeyReleased

	private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtPhoneKeyReleased
		// TODO add your handling code here:
		String phone = txtPhone.getText();
		user.txtPhoneKeyReleased(phone);
	}// GEN-LAST:event_txtPhoneKeyReleased

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
		// TODO add your handling code here:
		txtCaptchaS.setText(user.createCaptchaValue());
	}// GEN-LAST:event_jLabel1MouseClicked

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SignUp().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnBack;
	private javax.swing.JButton btnSave;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblEmail;
	public static javax.swing.JLabel lblErrorEmail;
	public static javax.swing.JLabel lblErrorPass;
	public static javax.swing.JLabel lblErrorPhone;
	public static javax.swing.JLabel lblErrorUsername;
	private javax.swing.JLabel lblHideEye1;
	private javax.swing.JLabel lblHideEye2;
	private javax.swing.JLabel lblId;
	private javax.swing.JLabel lblOTPCode;
	public static javax.swing.JLabel lblOk1;
	public static javax.swing.JLabel lblOk2;
	public static javax.swing.JLabel lblOk3;
	public static javax.swing.JLabel lblOk4;
	public static javax.swing.JLabel lblOk5;
	private javax.swing.JLabel lblPassword;
	private javax.swing.JLabel lblPhone;
	private javax.swing.JLabel lblSignUp;
	private javax.swing.JLabel lblUsername;
	private javax.swing.JLabel lblVerifyPassword;
	private javax.swing.JLabel lblVisibleEye1;
	private javax.swing.JLabel lblVisibleEye2;
	private javax.swing.JTextField txtCaptchaS;
	private javax.swing.JTextField txtCode;
	public static javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtId;
	public static javax.swing.JPasswordField txtPassword;
	public static javax.swing.JTextField txtPhone;
	public static javax.swing.JTextField txtUsername;
	public static javax.swing.JPasswordField txtVerifyPassword;
	// End of variables declaration//GEN-END:variables
}
