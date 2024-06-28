package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/icons/ypp.png")));
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		try {
			// Thiết lập giao diện theo hệ điều hành
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 1085, 177);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/LOGOYP.png")));
		lblNewLabel.setBounds(0, 0, 214, 169);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Electronic products management system");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1.setBounds(242, 42, 741, 93);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(0, 174, 1085, 440);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/laptop.png")));
		lblNewLabel_2.setBounds(94, 103, 136, 145);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/mobile.png")));
		lblNewLabel_3.setBounds(412, 103, 166, 145);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/tv.png")));
		lblNewLabel_4.setBounds(731, 98, 136, 150);
		panel_1.add(lblNewLabel_4);

		JButton btnMobile = new JButton("Mobile");
		btnMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMobileActionPerformed(e);
			}
		});
		btnMobile.setBackground(new Color(255, 250, 240));
		btnMobile.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnMobile.setBounds(416, 278, 136, 33);
		panel_1.add(btnMobile);

		JButton btnTv = new JButton("Television");
		btnTv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTvActionPerformed(e);
			}
		});
		btnTv.setBackground(new Color(255, 250, 240));
		btnTv.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnTv.setBounds(719, 278, 166, 33);
		panel_1.add(btnTv);

		JLabel lblLogout = new JLabel("Log out");
		lblLogout.setForeground(new Color(255, 255, 255));
		lblLogout.setBackground(new Color(255, 51, 0));
		lblLogout.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblLogout.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/cancel.png")));
		lblLogout.setBounds(916, 29, 147, 51);
		panel_1.add(lblLogout);
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogoutMouseClicked(e);
			}
		});

		JButton btnLaptop = new JButton("Laptop");
		btnLaptop.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnLaptop.setBackground(new Color(255, 250, 240));
		btnLaptop.setBounds(94, 278, 136, 33);
		panel_1.add(btnLaptop);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/menu.png")));
		lblNewLabel_5.setBounds(0, -11, 1085, 460);
		panel_1.add(lblNewLabel_5);
		btnLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLaptopActionPerformed(e);
			}
		});

	}

	private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LogoutMouseClicked
		// TODO add your handling code here:
		int a = JOptionPane.showConfirmDialog(this, "Do you want to log out now?", "Logout", JOptionPane.YES_NO_OPTION);
		if (a == 0) {
			new Login().setVisible(true);
			this.dispose();
		}
	}// GEN-LAST:event_LogoutMouseClicked

	private void btnTvActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		TVManagerGUI tv = new TVManagerGUI();
		tv.setVisible(true);
		this.dispose();
	}// GEN-LAST:event_btnBackActionPerformed

	private void btnMobileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		MobileManagerGUI m = new MobileManagerGUI();
		m.setVisible(true);
		this.dispose();

	}// GEN-LAST:event_btnBackActionPerformed

	private void btnLaptopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		LaptopManagerGUI l = new LaptopManagerGUI();
		l.setVisible(true);
		this.dispose();

	}// GEN-LAST:event_btnBackActionPerformed
}
