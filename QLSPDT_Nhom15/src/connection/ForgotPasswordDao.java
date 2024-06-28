package connection;

import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static view.ForgotPass.*;

public class ForgotPasswordDao {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    //check email already exist
    public void txtEmailKeyReleased(String email) {
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from user where uemail = '" + email + "' ");
			if (txtEmailF.getText().matches("^.+@.+\\..+$")) {
				if (rs.next()) {
                    lblErrorEmailF.setText("");
                    txtEmailF.setForeground(new Color(0, 102, 51));
                    lblErrorEmailF.setVisible(false);
                    lblOk2F.setVisible(true);
                }
            }
            else{
                lblErrorEmailF.setText("Invalid email address");
                    txtEmailF.setForeground(Color.red);
                    lblErrorEmailF.setVisible(true);
                    lblOk2F.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //check password
    public void jPasswordField1KeyReleased() {
        if (!String.valueOf(txtPasswordF.getPassword()).equalsIgnoreCase("")) {
            lblOk3F.setVisible(true);
        } else {
            lblOk3F.setVisible(false);

        }
    }

    //check Verify password match with Password
    public void jPasswordField2KeyReleased() {
        String password1 = String.valueOf(txtPasswordF.getPassword());
        String password2 = String.valueOf(txtVerifyPasswordF.getPassword());
        if (!password1.equalsIgnoreCase(password2)) {
            lblErrorPassF.setText("Password does not match");
            txtVerifyPasswordF.setForeground(Color.red);
            lblErrorPassF.setVisible(true);
            lblOk4F.setVisible(false);

        } else {
            lblErrorPassF.setText("");
            txtVerifyPasswordF.setForeground(new Color(0, 102, 51));
            lblErrorPassF.setVisible(false);
            lblOk4F.setVisible(true);
        }
    }

    public void setNewPassword(String email, String pass) {
        String sql = "update user set upassword = ? where uemail = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Password successfully updated!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
