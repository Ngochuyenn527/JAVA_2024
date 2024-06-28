package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MobileManagerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtProduct_id;
	private JTextField txtProduct_name;
	private JTextField txtProduct_price;
	private JTextField txtProduct_total;
	private JTextField txtMobileColor;
	private JTextField txtMobileSS;
	private JTextField txtSearch;
	private JComboBox<String> comboBox_Sort;
	private JComboBox<String> comboBox_Sorted_by;
	private JComboBox<String> comboBox_Search;

	private ArrayList<Mobile> list = new ArrayList<>();
	private MobileManagerImpl mmi;
	private DefaultTableModel defaultTableModel;
	private String[] table_headers = { "ID", "Name", "Price", "Total", "Color", "Screensize" };
	private int index;

	public MobileManagerGUI() {
		initComponents();
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mmi = new MobileManagerImpl();
		list = mmi.generateList(20);

		this.setVisible(true);
		this.setLocationRelativeTo(null); // background center
	}

	// Phương thức tạo ra 1 danh sách
	public void showListData(List<Mobile> list) {
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(defaultTableModel);

		for (int i = 0; i < table_headers.length; i++) {
			defaultTableModel.addColumn(table_headers[i]);
		}

		for (Mobile i : list) {
			defaultTableModel.addRow(new Object[] { i.getProduct_id(), i.getProduct_name(), i.getProduct_price(),
					i.getProduct_total(), i.getColor(), i.getScreensize() });
		}

		table.setVisible(true);
		defaultTableModel.fireTableDataChanged();
		table.repaint();
	}

	// Phương thức cập nhật các JTextField dựa trên dòng được chọn
	private void updateTextFields() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			txtProduct_id.setText(table.getValueAt(selectedRow, 0).toString());
			txtProduct_name.setText(table.getValueAt(selectedRow, 1).toString());
			txtProduct_price.setText(table.getValueAt(selectedRow, 2).toString());
			txtProduct_total.setText(table.getValueAt(selectedRow, 3).toString());
			txtMobileColor.setText(table.getValueAt(selectedRow, 4).toString());
			txtMobileSS.setText(table.getValueAt(selectedRow, 5).toString());
		}
	}

	public void xoaForm() {
		// TODO Auto-generated method stub
		this.txtProduct_id.setText("");
		this.txtProduct_name.setText("");
		this.txtProduct_price.setText("");
		this.txtProduct_total.setText("");
		this.txtMobileColor.setText("");
		this.txtMobileSS.setText("");
	}

	private void initComponents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MobileManagerGUI.class.getResource("/icons/ypp.png")));
		setTitle("Mobile Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MobileManagerGUI2");
		setResizable(false);
		setBounds(100, 100, 1101, 662);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(433, 142, 648, 473);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "ID", "NAME", "PRICE", "TOTAL", "COLOR", "SCREENSIZE" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.Double.class,
					java.lang.Integer.class, java.lang.String.class, java.lang.Double.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(30);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableMouseClicked(evt);
			}
		});
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(10, 81, 413, 355);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Product_id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 64, 138, 25);
		panel.add(lblNewLabel);

		JLabel lblTnSnPhm = new JLabel("Product_name");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnSnPhm.setBounds(10, 105, 138, 25);
		panel.add(lblTnSnPhm);

		JLabel lblGiSnPhm = new JLabel("Product_price");
		lblGiSnPhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiSnPhm.setBounds(10, 146, 138, 25);
		panel.add(lblGiSnPhm);

		JLabel lblSLngSn = new JLabel("Product_total");
		lblSLngSn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLngSn.setBounds(10, 187, 138, 25);
		panel.add(lblSLngSn);

		JLabel lblTnLaptop = new JLabel("Product_color");
		lblTnLaptop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnLaptop.setBounds(10, 228, 138, 25);
		panel.add(lblTnLaptop);

		JLabel lblGiLaptop = new JLabel("Product_screensize");
		lblGiLaptop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiLaptop.setBounds(10, 269, 138, 25);
		panel.add(lblGiLaptop);

		txtProduct_id = new JTextField();
		txtProduct_id.setBounds(171, 56, 232, 30);
		panel.add(txtProduct_id);
		txtProduct_id.setColumns(10);

		txtProduct_name = new JTextField();
		txtProduct_name.setColumns(10);
		txtProduct_name.setBounds(171, 98, 232, 30);
		panel.add(txtProduct_name);

		txtProduct_price = new JTextField();
		txtProduct_price.setColumns(10);
		txtProduct_price.setBounds(171, 140, 232, 30);
		panel.add(txtProduct_price);

		txtProduct_total = new JTextField();
		txtProduct_total.setColumns(10);
		txtProduct_total.setBounds(171, 182, 232, 30);
		panel.add(txtProduct_total);

		txtMobileColor = new JTextField();
		txtMobileColor.setColumns(10);
		txtMobileColor.setBounds(171, 224, 232, 30);
		panel.add(txtMobileColor);

		txtMobileSS = new JTextField();
		txtMobileSS.setColumns(10);
		txtMobileSS.setBounds(171, 266, 232, 30);
		panel.add(txtMobileSS);

		JLabel lblNewLabel_1 = new JLabel("Information");
		lblNewLabel_1.setIcon(
				new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-File-text.16.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(116, 12, 181, 32);
		panel.add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 42, 372, 2);
		panel.add(separator);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(10, 446, 413, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(19, 38, 375, 15);
		panel_1.add(separator_1);

		JLabel lblNewLabel_1_1 = new JLabel("Function");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\ASUS\\Downloads\\Colebemis-Feather-Tool.16.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(116, 10, 181, 32);
		panel_1.add(lblNewLabel_1_1);

//		 Thêm 1 Laptop vào danh sách
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});
		btnAdd.setIcon(
				new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Plus-square.16.png")));
		btnAdd.setBounds(9, 108, 78, 32);
		panel_1.add(btnAdd);

		// Sửa 1 sản phẩm rong danh sách
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnEditActionPerformed(evt);
			}
		});
		btnEdit.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Edit.16.png")));
		btnEdit.setBounds(96, 108, 78, 32);
		panel_1.add(btnEdit);

		// Xóa 1 sản phẩm khỏi danh sách
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDelActionPerformed(evt);
			}
		});
		btnDel.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Trash-2.16.png")));
		btnDel.setBounds(183, 108, 97, 32);
		panel_1.add(btnDel);

		JLabel lblSpXp = new JLabel("Sort");
		lblSpXp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpXp.setBounds(29, 54, 78, 25);
		panel_1.add(lblSpXp);

		// Sắp xếp lại thông tin của bảng
		JButton btnSorted = new JButton("Sort");
		btnSorted.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSortedActionPerformed(evt);
			}
		});

		btnSorted.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Shuffle.16.png")));
		btnSorted.setBounds(296, 52, 109, 32);
		panel_1.add(btnSorted);

		String waytoSort[] = { "Product_id", "Product_name", "Product_price", "Product_total", "Color", "Screensize" };
		comboBox_Sort = new JComboBox(waytoSort);
		comboBox_Sort.setBounds(88, 52, 120, 32);
		panel_1.add(comboBox_Sort);

		String waytoSortby[] = { "Asc", "Des" };
		comboBox_Sorted_by = new JComboBox(waytoSortby);
		comboBox_Sorted_by.setBounds(213, 52, 78, 32);
		panel_1.add(comboBox_Sorted_by);

		// Hiện 1 danh sách có sẵn 20 thông tin
		JButton btnList = new JButton("Show List");
		btnList.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Clipboard.16.png")));
		btnList.setBounds(293, 108, 109, 32);
		panel_1.add(btnList);
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showListData(list);
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(433, 81, 648, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTmKim = new JLabel("Input search:");
		lblTmKim.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));
		lblTmKim.setBounds(10, 14, 126, 25);
		panel_2.add(lblTmKim);
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 14));

		String waytoSearch[] = { "Product_id", "Product_name", "Product_price", "Product_total", "Color",
				"Screensize" };
		comboBox_Search = new JComboBox(waytoSearch);
		comboBox_Search.setBounds(423, 10, 96, 32);
		panel_2.add(comboBox_Search);

		txtSearch = new JTextField();
		txtSearch.setBounds(132, 10, 281, 32);
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});
		btnSearch.setBounds(529, 10, 109, 32);
		panel_2.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(10, 10, 1071, 61);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitle = new JLabel("Mobile Management System");
		lblTitle.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/phonee.png")));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setBounds(10, 0, 433, 61);
		panel_3.add(lblTitle);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackActionPerformed(e);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(MobileManagerGUI.class.getResource("/icons/undo.png")));
		lblNewLabel_2.setBounds(1015, 11, 46, 39);
		panel_3.add(lblNewLabel_2);
	}

	private void btnBackActionPerformed(MouseEvent e) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
        new MainMenu().setVisible(true);
		this.dispose();
	}// GEN-LAST:event_btnBackActionPerformed

	/**
	 * thông tin của row được lấy ra
	 * 
	 * @param evt
	 */
	private void tableMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = table.getSelectedRow();
		updateTextFields();
	}

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		try {
			Mobile m = new Mobile();
			m.setProduct_id(Integer.parseInt(txtProduct_id.getText()));
			m.setProduct_name(txtProduct_name.getText());
			m.setProduct_price(Double.parseDouble(txtProduct_price.getText()));
			m.setProduct_total(Integer.parseInt(txtProduct_total.getText()));
			m.setColor(txtMobileColor.getText());
			m.setScreensize(Double.parseDouble(txtMobileSS.getText()));

			// Thêm máy tính mới vào danh sách
			for (Mobile mobile : this.list) {
				if (mobile.getProduct_id() == m.getProduct_id()) {
					JOptionPane.showMessageDialog(this, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			int c = JOptionPane.showConfirmDialog(this, "Are you sure to ADD this item?");
			if (c == JOptionPane.OK_OPTION) {
				this.list.add(m);
				defaultTableModel.addRow(new Object[] { m.getProduct_id(), m.getProduct_name(), m.getProduct_price(),
						m.getProduct_total(), m.getColor(), m.getScreensize() });
				defaultTableModel.fireTableDataChanged();// cập nhật dữ liệu
				showListData(list);
			} else {
				return;
			}
		} catch (NumberFormatException e) { // bắt lỗi nếu các trường bị để trống
			JOptionPane.showMessageDialog(this, "Please fill out all of these fields", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		xoaForm();
	}

	private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		int selectedRow = table.getSelectedRow(), count = -1;
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(table, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String Product_id = txtProduct_id.getText();
		String Product_name = txtProduct_name.getText();
		String Product_price = txtProduct_price.getText();
		String Product_total = txtProduct_total.getText();
		String MobileColor = txtMobileColor.getText();
		String MobileSS = txtMobileSS.getText();

		if (Product_id.isEmpty() || Product_name.isEmpty() || Product_price.isEmpty() || Product_total.isEmpty()
				|| MobileColor.isEmpty() || MobileSS.isEmpty()) {
			JOptionPane.showMessageDialog(table, "Please fill out all of these fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		int id = Integer.parseInt(Product_id);
		boolean flag = true;
		if (selectedRow != -1) {
			for (Mobile m : this.list) {
				count++;
				if (m.getProduct_id() == id && count != selectedRow) {
					JOptionPane.showMessageDialog(table, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
					// gán cờ nếu có id trùng thì hiển thị thông báo lỗi và ko thêm sản phảm mới vào
					// danh sách
					flag = false;
					return;
				}
			}
		}
		if (flag) {
			double price = Double.parseDouble(Product_price);
			int total = Integer.parseInt(Product_total);
			double ss = Double.parseDouble(MobileSS);

			Mobile m = new Mobile(id, Product_name, price, total, MobileColor, ss);

			int c = JOptionPane.showConfirmDialog(this, "Are you sure to EDIT this item?");
			if (c == JOptionPane.OK_OPTION) {
				// set lại thông tin cho sản phẩm đã sửa
				this.list.set(selectedRow, m);

				// set lại dữ liệu cho các dòng và cột tương ứng <dtm.setValueAt("thong tin", số
				// dòng, số cột)>
				defaultTableModel.setValueAt(Product_id, selectedRow, 0);
				defaultTableModel.setValueAt(Product_name, selectedRow, 1);
				defaultTableModel.setValueAt(Product_price, selectedRow, 2);
				defaultTableModel.setValueAt(Product_total, selectedRow, 3);
				defaultTableModel.setValueAt(MobileColor, selectedRow, 4);
				defaultTableModel.setValueAt(MobileSS, selectedRow, 5);

				xoaForm();
				JOptionPane.showMessageDialog(table, "Edit successfully");
			} else {
				return;
			}
		}
		defaultTableModel.fireTableDataChanged();
	}

	private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to DELETE this item?");
			if (confirm == JOptionPane.YES_OPTION) {
				this.list.remove(row);
				showListData(list);

				// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
				xoaForm();
			}
		}
	}

	private void btnSortedActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String selectedItem = (String) comboBox_Sort.getSelectedItem();
		String sortOption = comboBox_Sorted_by.getSelectedItem().toString();
		boolean flag;

		if (sortOption != null && selectedItem != null) {
			if (sortOption.contains("Asc")) {
				flag = true;
				if (selectedItem.contains("Product_id")) {
					mmi.sortedByProductId(list, flag);
				} else if (selectedItem.contains("Product_name")) {
					mmi.sortedByProductName(list, flag);
				} else if (selectedItem.contains("Product_price")) {
					mmi.sortedByProductPrice(list, flag);
				} else if (selectedItem.contains("Product_total")) {
					mmi.sortedByProductTotal(list, flag);
				} else if (selectedItem.contains("Color")) {
					mmi.sortedByColor(list, flag);
				} else if (selectedItem.contains("Screensize")) {
					mmi.sortedByScreensize(list, flag);
				}
			} else {
				flag = false;
				if (selectedItem.contains("Product_id")) {
					mmi.sortedByProductId(list, flag);
				} else if (selectedItem.contains("Product_name")) {
					mmi.sortedByProductName(list, flag);
				} else if (selectedItem.contains("Product_price")) {
					mmi.sortedByProductPrice(list, flag);
				} else if (selectedItem.contains("Product_total")) {
					mmi.sortedByProductTotal(list, flag);
				} else if (selectedItem.contains("Color")) {
					mmi.sortedByColor(list, flag);
				} else if (selectedItem.contains("Screensize")) {
					mmi.sortedByScreensize(list, flag);
				}
			}
			showListData(list);
		}
	}

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String selectedItem = (String) comboBox_Search.getSelectedItem();
		String searchValue = txtSearch.getText();
		List<Mobile> result = new ArrayList<Mobile>();

		if (searchValue != null && !searchValue.trim().isEmpty()) {
			if (selectedItem.contains("Product_id")) {
				result = mmi.searchMobile_id(Integer.parseInt(searchValue));
			} else if (selectedItem.contains("Product_name")) {
				result = mmi.searchMobile(searchValue);
			} else if (selectedItem.contains("Product_price")) {
				result = mmi.searchMobile_price(Double.parseDouble(searchValue));
			} else if (selectedItem.contains("Product_total")) {
				result = mmi.searchMobile_total(Integer.parseInt(searchValue));
			} else if (selectedItem.contains("Color")) {
				result = mmi.searchMobile_color(searchValue);
			} else if (selectedItem.contains("Screensize")) {
				result = mmi.searchMobile_ss(Double.parseDouble(searchValue));
			}
			showListData(result);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MobileManagerGUI frame = new MobileManagerGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
