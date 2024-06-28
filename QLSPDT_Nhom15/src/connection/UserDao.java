package connection;

import java.awt.Color;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static view.SignUp.*;

public class UserDao {

	Connection con = MyConnection.getConnection();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	// get user table max row
	public int getMaxRow() {
		int row = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select max(uid) from user");
			while (rs.next()) {
				row = rs.getInt(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return row + 1;
	}

	// insert data into user table
	public void insert(int id, String username, String email, String password, String phone) {
		String sql = "insert into user values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, phone);

			if (ps.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "User added successfully");
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// check username phải lớn hơn 5 ký tự và 0 trùng nhau
	public void txtUsernameKeyReleased(String username) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user where uname = '" + username + "' ");
			// username đã tồn tại
			if (rs.next()) {
				lblErrorUsername.setText("Sorry..Username is already exists");
				txtUsername.setForeground(Color.red);
				lblErrorUsername.setVisible(true);
				lblOk1.setVisible(false);
			} // username hợp lệ
			else {
				// kiểm tra tên người dùng phải dài hơn 5 ký tự
				int length = username.length();
				if (length < 5) {
					lblErrorUsername.setText("Username must be longer than 5 char");
					txtUsername.setForeground(Color.red);
					lblErrorUsername.setVisible(true);
					lblOk1.setVisible(false);
				} else {
					lblErrorUsername.setText("");
					txtUsername.setForeground(new Color(0, 102, 51));
					lblErrorUsername.setVisible(false);
					if (username.equalsIgnoreCase("")) {
						lblOk1.setVisible(false);
					} else {
						lblOk1.setVisible(true);
					}
				}
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// check form email và email 0 bị trùng
	public void txtEmailKeyReleased(String email) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from user where uemail = '" + email + "' ");

			// email đã tồn tại
			if (rs.next()) {
				lblErrorEmail.setText("Sorry..Email is already exists");
				txtEmail.setForeground(Color.red);
				lblErrorEmail.setVisible(true);
				lblOk2.setVisible(false);
			}
			// email hợp lệ
			else {
				// kiểm tra đúng form email
				if (!txtEmail.getText().matches("^.+@.+\\..+$")) {
					lblErrorEmail.setText("Invalid email address");
					txtEmail.setForeground(Color.red);
					lblErrorEmail.setVisible(true);
					lblOk2.setVisible(false);
				} else {
					lblErrorEmail.setText("");
					txtEmail.setForeground(new Color(0, 102, 51));
					lblErrorEmail.setVisible(false);
					// khi txtUsername bỏ trống 0 điền gì thì lblOk sẽ biến mất
					if (email.equalsIgnoreCase("")) {
						lblOk2.setVisible(false);
					} else {
						lblOk2.setVisible(true);
					}
				}
			}
		} catch (SQLException ex) {
			java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// check password
	public void jPasswordField1KeyReleased() {
		if (!String.valueOf(txtPassword.getPassword()).equalsIgnoreCase("")) {
			lblOk3.setVisible(true);
		} else {
			lblOk3.setVisible(false);
		}
	}

	// check Verify password match with Password
	public void jPasswordField2KeyReleased() {
		String password1 = String.valueOf(txtPassword.getPassword());
		String password2 = String.valueOf(txtVerifyPassword.getPassword());
		if (!password1.equalsIgnoreCase(password2)) {
			lblErrorPass.setText("Password does not match");
			txtVerifyPassword.setForeground(Color.red);
			lblErrorPass.setVisible(true);
			lblOk4.setVisible(false);

		} else {
			lblErrorPass.setText("");
			txtVerifyPassword.setForeground(new Color(0, 102, 51));
			lblErrorPass.setVisible(false);
			lblOk4.setVisible(true);
		}
	}

	// check phone number phải có 10 số và bắt đầu từ số 0
	public void txtPhoneKeyReleased(String phone) {
		if (!txtPhone.getText().matches("^0\\d{9}$")) {
			lblErrorPhone.setText("Invalid phone number");
			txtPhone.setForeground(Color.red);
			lblErrorPhone.setVisible(true);
			lblOk5.setVisible(false);
		} else {
			lblErrorPhone.setText("");
			txtPhone.setForeground(new Color(0, 102, 51));
			lblErrorPhone.setVisible(false);
			if (phone.equalsIgnoreCase("")) {
				lblOk5.setVisible(false);
			} else {
				lblOk5.setVisible(true);
			}
		}

	}

	/**
	 * generate a captcha String [contains RANDOM LOWERCASE and UPPERCASE letters,
	 * and NUMBERS]
	 *
	 * @return
	 */
	public static String createCaptchaValue() {
		Random random = new Random();
		StringBuffer captchaStrBuffer = new StringBuffer();
		for (int i = 0; i < 5; i++) { // chiều dài bao gồm 5 ký tự
			int baseCharacterNumber = Math.abs(random.nextInt()) % 62; // Tạo một số ngẫu nhiên từ 0 đến 61 để xác định
																		// loại ký tự (chữ hoa, chữ thường hoặc số).
			int characterNumber = 0;
			if (baseCharacterNumber < 26) { // ký tự là chữ hoa.
				characterNumber = 65 + baseCharacterNumber;
			} else if (baseCharacterNumber < 52) { // ký tự là chữ thường.
				characterNumber = 97 + (baseCharacterNumber - 26);
			} else { // ký tự là số.
				characterNumber = 48 + (baseCharacterNumber - 52);
			}
			captchaStrBuffer.append((char) characterNumber);
		}
		return captchaStrBuffer.toString();
	}

}
