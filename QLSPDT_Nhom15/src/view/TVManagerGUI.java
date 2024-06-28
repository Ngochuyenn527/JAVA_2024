package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.TV;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TVManagerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtProduct_id;
	private JTextField txtProduct_name;
	private JTextField txtProduct_price;
	private JTextField txtProduct_total;
	private JTextField txtsize;
	private JTextField txtbranch;
	private JTextField txtType;
	private JTextField txtSearch;
	private JComboBox<String> comboBox_Sort;
	private JComboBox<String> comboBox_Sorted_by;
	private JComboBox<String> comboBox_Search;
//	private DefaultTableModel tableModel;
	public List<TV> list = new ArrayList<TV>();

	/**
	 * Phương thức cập nhật các JTextField dựa trên dòng được chọn
	 */
	private void updateTextFields() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			txtProduct_id.setText(table.getValueAt(selectedRow, 0).toString());
			txtProduct_name.setText(table.getValueAt(selectedRow, 1).toString());
			txtProduct_price.setText(table.getValueAt(selectedRow, 2).toString());
			txtProduct_total.setText(table.getValueAt(selectedRow, 3).toString());
			txtsize.setText(table.getValueAt(selectedRow, 4).toString());
			txtbranch.setText(table.getValueAt(selectedRow, 5).toString());
			txtType.setText(table.getValueAt(selectedRow, 6).toString());
		}
	}

	/**
	 * Phưởng thức thêm 1 sản phẩm vào danh sách và bảng
	 */
	public void add() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String tmp = txtProduct_id.getText();
		if (tmp.isEmpty()) {
			JOptionPane.showMessageDialog(table, "Please fill out all of these fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		int idc = Integer.parseInt(tmp);// idc là id của sản phẩm sắp thêm để check xem đã tồn tại hay chưa

		// lấy thông tin từ các ô
		String Product_id = txtProduct_id.getText();
		String Product_name = txtProduct_name.getText();
		String Product_price = txtProduct_price.getText();
		String Product_total = txtProduct_total.getText();
		String size = txtsize.getText();
		String branch = txtbranch.getText();
		String type = txtType.getText();

		// kiểm tra xem có ô nào chưa nhập thông tin
		if (Product_id.isEmpty() || Product_name.isEmpty() || Product_price.isEmpty() || Product_total.isEmpty()
				|| size.isEmpty() || branch.isEmpty() || type.isEmpty()) {
			JOptionPane.showMessageDialog(table, "Please fill out all of these fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// kiểm tra xem có id nào đã tồn tại trong danh sách
		for (TV laptop : list) {
			if (laptop.getProduct_id() == idc) {
				// hiện thông báo có lỗi khi có ô trùng thông tin
				JOptionPane.showMessageDialog(table, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		// chuyển các kiểu dữ liệu về dạng đúng của nó
		int pi = Integer.parseInt(Product_id);
		int pt = Integer.parseInt(Product_total);
//		int lr = Integer.parseInt(Laptop_ram);
		double pp = Double.parseDouble(Product_price);
//		String lp = (Laptop_price);
		int c = JOptionPane.showConfirmDialog(this, "Are you sure to ADD this item?");
		if (c == JOptionPane.OK_OPTION) {
			// vector chứa thông tin để cho vào bảng
			Vector a = new Vector<TV>();
			a.add(Product_id);
			a.add(Product_name);
			a.add(Product_price);
			a.add(Product_total);
			a.add(size);
			a.add(branch);
			a.add(type);
			dtm.addRow(a);// thêm dữ liệu vào bảng
			dtm.fireTableDataChanged();// cập nhật dữ liệu

			// thêm vào danh sách
			this.list.add(new TV(pi, Product_name, pp, pt, size, branch, type));// thêm vào list (danh sách)
		} else {
			return;
		}

		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		this.txtProduct_id.setText("");
		this.txtProduct_name.setText("");
		this.txtProduct_price.setText("");
		this.txtProduct_total.setText("");
		this.txtsize.setText("");
		this.txtbranch.setText("");
		this.txtType.setText("");

	}

	/**
	 * phương thức sửa 1 sản phẩm
	 */
	public void edit() {
		int selectedRow = table.getSelectedRow(), count = -1;

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(table, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String tmp = txtProduct_id.getText();

		int pi = Integer.parseInt(tmp);
		boolean flag = true;

		String Product_id = txtProduct_id.getText();
		String Product_name = txtProduct_name.getText();
		String Product_price = txtProduct_price.getText();
		String Product_total = txtProduct_total.getText();
		String size = txtsize.getText();
		String branch = txtbranch.getText();
		String type = txtType.getText();

		if (Product_id.isEmpty() || Product_name.isEmpty() || Product_price.isEmpty() || Product_total.isEmpty()
				|| size.isEmpty() || branch.isEmpty() || type.isEmpty()) {
			JOptionPane.showMessageDialog(table, "Please fill out all of these fields", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (selectedRow != -1) {
			for (TV laptop : this.list) {
				count++;
				if (laptop.getProduct_id() == pi && count != selectedRow) {
					JOptionPane.showMessageDialog(table, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
					// gán cờ nếu có id trùng thì hiển thị thông báo lỗi và ko thêm sản phảm mới vào
					// danh sách
					flag = false;
					return;
				}
			}
		}
		if (flag) {
			int pt = Integer.parseInt(Product_total);
//			int lr = Integer.parseInt(Laptop_ram);
			double pp = Double.parseDouble(Product_price);
//			double lp = Double.parseDouble(Laptop_price);
			int c = JOptionPane.showConfirmDialog(this, "Are you sure to EDIT this item?");
			if (c == JOptionPane.OK_OPTION) {
				TV editedLaptop = new TV(pi, Product_name, pp, pt, size, branch, type);

				// set lại thông tin cho sản phẩm đã sửa
				this.list.set(selectedRow, editedLaptop);

				// set lại dữ liệu cho các dòng và cột tương ứng <dtm.setValueAt("thong tin", số
				// dòng, số cột)>
				dtm.setValueAt(Product_id, selectedRow, 0);
				dtm.setValueAt(Product_name, selectedRow, 1);
				dtm.setValueAt(Product_price, selectedRow, 2);
				dtm.setValueAt(Product_total, selectedRow, 3);
				dtm.setValueAt(size, selectedRow, 4);
				dtm.setValueAt(branch, selectedRow, 5);
				dtm.setValueAt(type, selectedRow, 6);

				JOptionPane.showMessageDialog(table, "Edit successfully");
			} else {
				return;
			}

		}
		dtm.fireTableDataChanged();
	}

	/**
	 * phương thức xóa 1 sản phẩm
	 */
	public void del() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int selectedRow = table.getSelectedRow();

		if (selectedRow != -1) {
			int c = JOptionPane.showConfirmDialog(this, "Are you sure to DELETE this item?");
			if (c == JOptionPane.OK_OPTION) {
				TV laptopRemove = this.list.get(selectedRow);
				dtm.removeRow(selectedRow); // Xóa dòng này khỏi bảng
				this.list.remove(laptopRemove); // xóa laptop khỏi danh sách
			} else {
				return;
			}

		} else {
			JOptionPane.showMessageDialog(table, "Choose 1 item please!");
		}

		dtm.fireTableDataChanged(); // cập nhật lại thông tin của bảng
	}

	/**
	 * Phương thức xóa toàn bộ thông tin ở bảng (table)
	 */
	public void clearTable() {
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Laptop_name
	 * 
	 * @param tên Laptop cần tìm
	 * @return danh sách cần tìm
	 */
	public List<TV> searchBytvName(String name) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getTV_size().equals(name)) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Laptop_price
	 * 
	 * @param tìm theo giá
	 * @return danh sách cần tìm
	 */
	public List<TV> searchBytvPrice(String type) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getTV_typescreen() == type) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Laptop_ram
	 * 
	 * @param ram cần tìm
	 * @return danh sách ram cần tìm
	 */
	public List<TV> searchBytvRam(String branch) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getTV_brand() == branch) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Product_id
	 * 
	 * @param id của sản phẩm cần tìm
	 * @return danh sách cần tìm
	 */
	public List<TV> searchByProductId(int id) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getProduct_id() == id) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Product_name
	 * 
	 * @param Tên sản phẩm
	 * @return danh sách
	 */
	public List<TV> searchByProductName(String name) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getProduct_name().equals(name)) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Product_total
	 * 
	 * @param total - số lượng cần tìm
	 * @return danh sách cần tìm
	 */
	public List<TV> searchByProductTotal(int total) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getProduct_total() == total) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức danh sách tìm kiếm theo Product_price
	 * 
	 * @param price - giá cần tìm
	 * @return danh sách cần tìm
	 */
	public List<TV> searchByProductPrice(double price) {
		List<TV> results = new ArrayList<TV>();
		for (TV laptop : this.list) {
			if (laptop.getProduct_price() == price) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức sắp xếp theo mã sản phẩm
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<TV> sortedByProductId(List<TV> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(TV::getProduct_id));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	/**
	 * Phương thức sắp xếp theo tên sản phẩm
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<TV> sortedByProductName(List<TV> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparing(TV::getProduct_name));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	/**
	 * Phương thức sắp xếp theo giá sản phẩm
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<TV> sortedByProductPrice(List<TV> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingDouble(TV::getProduct_price));
		}
		return list1;
	}

	/**
	 * Phương thức sắp xếp theo số lượng sản phẩm
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tăng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<TV> sortedByProductTotal(List<TV> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(TV::getProduct_total));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	/**
	 * Phương thức lấy thông tin hiện tại trên JTable
	 * 
	 * @return danh sách sản phẩm từ bảng đang hiển thị thông tin
	 */
	public List<TV> getTableData() {
		List<TV> data = new ArrayList<>();
		int rowCount = table.getRowCount();
		int colCount = table.getColumnCount();

		for (int i = 0; i < rowCount; i++) {

			int Product_id = Integer.parseInt(table.getValueAt(i, 0).toString());
			String Product_name = table.getValueAt(i, 1).toString();
			double Product_price = Double.parseDouble(table.getValueAt(i, 2).toString());
			int Product_total = Integer.parseInt(table.getValueAt(i, 3).toString());

			String size = table.getValueAt(i, 4).toString();
			String branch = (table.getValueAt(i, 5).toString());
			String type = (table.getValueAt(i, 6).toString());

			data.add(new TV(Product_id, Product_name, Product_price, Product_total, size, branch, type));
		}
		return data;
	}

	/**
	 * Phương thức tìm kiếm
	 */
	public void search() {
		String selectedItem = (String) comboBox_Search.getSelectedItem();
		String searchText = txtSearch.getText();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		List<TV> results = new ArrayList<TV>();
		switch (selectedItem) {
		case "Product_id":
			results = searchByProductId(Integer.parseInt(searchText));
			break;
		case "Product_name":
			results = searchByProductName(searchText);
			break;
		case "Product_price":
			results = searchByProductPrice(Double.parseDouble(searchText));
			break;
		case "Product_total":
			results = searchByProductTotal(Integer.parseInt(searchText));
			break;
		}

		addData(results);
	}

	/**
	 * Phương thức tìm kiếm
	 * 
	 * @param results danh sách đã đc sắp xếp
	 */
	public void sort(List<TV> results) {
		String selectedItem = (String) comboBox_Sort.getSelectedItem();
		String selectedItem1 = (String) comboBox_Sorted_by.getSelectedItem();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		boolean flag = true;
		switch (selectedItem1) {
		case "Asc":
			flag = true;
			switch (selectedItem) {
			case "Product_id":
				sortedByProductId(results, flag);
				break;
			case "Product_name":
				sortedByProductName(results, flag);
				break;
			case "Product_price":
				sortedByProductPrice(results, flag);
				break;
			case "Product_total":
				sortedByProductTotal(results, flag);
				break;

			}
			;
			break;
		case "Des":
			flag = false;
			switch (selectedItem) {
			case "Product_id":
				sortedByProductId(results, flag);
				break;
			case "Product_name":
				sortedByProductName(results, flag);
				break;
			case "Product_price":
				sortedByProductPrice(results, flag);
				break;
			case "Product_total":
				sortedByProductTotal(results, flag);
				break;

			}
			;
			break;
		}
		addData(results);
		dtm.fireTableDataChanged();
	}

	/**
	 * Phưởng thức hiển thị thông tin vào bảng
	 * 
	 * @param results
	 */
	public void addData(List<TV> results) {
		clearTable();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (TV laptop : results) {
			Vector<Object> row = new Vector<Object>();
			row.add(laptop.getProduct_id());
			row.add(laptop.getProduct_name());
			row.add(laptop.getProduct_price());
			row.add(laptop.getProduct_total());
			row.add(laptop.getTV_size());
			row.add(laptop.getTV_brand());
			row.add(laptop.getTV_typescreen());
			dtm.addRow(row);
		}
		dtm.fireTableDataChanged();// cập nhật lại thông tin của bảng
	}

	/**
	 * Phương thức tạo ra 1 danh sách
	 */
	public void create() {
		int n = 20;
		this.list = new ArrayList<TV>(n);
		HashMap<Integer, TV> tmp = new HashMap<Integer, TV>();//
		TV l;
		int value;
		while (tmp.size() < n) {
			value = 1 + (int) (Math.random() * 100);
			if (!tmp.containsKey(value)) {
				l = TV.createProduct(value);
				tmp.put(value, l);
				this.list.add(l);
			}
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (TV laptop : this.list) {

			Vector a = new Vector<TV>();
			a.add(laptop.getProduct_id());
			a.add(laptop.getProduct_name());
			a.add(laptop.getProduct_price());
			a.add(laptop.getProduct_total());
			a.add(laptop.getTV_size());
			a.add(laptop.getTV_brand());
			a.add(laptop.getTV_typescreen());
			dtm.addRow(a);// thêm thông tin vào bảng
			dtm.fireTableDataChanged();// cập nhật lại thông tin của bảng

		}
	}

	/**
	 * lấy kích thước của danh sách
	 * 
	 * @return kích thước của danh sách
	 */

	public int getSize1() {
		int k = this.list.size();
		return k;
	}

	private void btnBackActionPerformed(MouseEvent e) {// GEN-FIRST:event_btnBackActionPerformed
		// TODO add your handling code here:
		new MainMenu().setVisible(true);
		this.dispose();

	}// GEN-LAST:event_btnBackActionPerformed

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TVManagerGUI frame = new TVManagerGUI();
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
	public TVManagerGUI() {
		setTitle("Tv Management");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TVManagerGUI.class.getResource("/icons/ypp.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		table.setFont(new Font("Dialog", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, },
				new String[] { "ID", "NAME", "PRICE", "TOTAL", "SCREENSIZE", "MODEL", "TYPE" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(102);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(6).setPreferredWidth(99);
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		// Thêm ListSelectionListener vào bảng để cập nhật JTextField khi chọn dòng
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					updateTextFields();
				}
			}
		});

		// Panel 1
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

		JLabel lblTnLaptop = new JLabel("Product_screensize");
		lblTnLaptop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnLaptop.setBounds(10, 228, 138, 25);
		panel.add(lblTnLaptop);

		JLabel lblGiLaptop = new JLabel("Model");
		lblGiLaptop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiLaptop.setBounds(10, 269, 138, 25);
		panel.add(lblGiLaptop);

		JLabel lblRam = new JLabel("Type of screen");
		lblRam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRam.setBounds(10, 310, 138, 25);
		panel.add(lblRam);

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

		txtsize = new JTextField();
		txtsize.setColumns(10);
		txtsize.setBounds(171, 224, 232, 30);
		panel.add(txtsize);

		txtbranch = new JTextField();
		txtbranch.setColumns(10);
		txtbranch.setBounds(171, 266, 232, 30);
		panel.add(txtbranch);

		txtType = new JTextField();
		txtType.setColumns(10);
		txtType.setBounds(171, 308, 232, 30);
		panel.add(txtType);

		JLabel lblNewLabel_1 = new JLabel("Information");
		lblNewLabel_1
				.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-File-text.16.png")));
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
		lblNewLabel_1_1.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Tool.16.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(116, 10, 181, 32);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblSpXp = new JLabel("Sort");
		lblSpXp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSpXp.setBounds(5, 56, 78, 25);
		panel_1.add(lblSpXp);

		// Panel 2
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(433, 81, 648, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTimKiem = new JLabel("Input search");
		lblTimKiem.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));
		lblTimKiem.setBounds(10, 14, 124, 25);
		panel_2.add(lblTimKiem);
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtSearch = new JTextField();
		txtSearch.setBounds(132, 10, 253, 32);
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);
		comboBox_Sort = new JComboBox<String>();
		comboBox_Sort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		;
		comboBox_Sort.setModel(new DefaultComboBoxModel(
				new String[] { "Product_id", "Product_name", "Product_price", "Product_total" }));
		comboBox_Sort.setBounds(88, 52, 120, 32);
		panel_1.add(comboBox_Sort);

		comboBox_Search = new JComboBox<String>();
		comboBox_Search.setBounds(395, 10, 124, 32);
		panel_2.add(comboBox_Search);
		comboBox_Search.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Product_id", "Product_name", "Product_price", "Product_total" }));
		comboBox_Search.setFont(new Font("Tahoma", Font.PLAIN, 14));

		comboBox_Sorted_by = new JComboBox<String>();
		comboBox_Sorted_by.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Sorted_by.setModel(new DefaultComboBoxModel(new String[] { "Asc", "Des" }));
		comboBox_Sorted_by.setBounds(213, 52, 78, 32);
		panel_1.add(comboBox_Sorted_by);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(10, 10, 1071, 61);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitle = new JLabel(" Tv Management System");
		lblTitle.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/tele.png")));
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
		lblNewLabel_2.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/undo.png")));
		lblNewLabel_2.setBounds(1015, 5, 46, 50);
		panel_3.add(lblNewLabel_2);

		/**
		 * Thêm 1 button với chức năng thêm Laptop vào danh sách
		 */
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdd.setBackground(new Color(0, 153, 255));

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = getSize1();
				if (k == 0) {
					clearTable();
				}
				add();
			}
		});
		btnAdd.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Plus-square.16.png")));
		btnAdd.setBounds(9, 108, 78, 32);
		panel_1.add(btnAdd);

		/**
		 * thêm 1 button với chức năng sửa sản phẩm trong danh sách
		 */
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edit();
			}
		});
		btnEdit.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Sliders.16.png")));
		btnEdit.setBounds(96, 108, 78, 32);
		panel_1.add(btnEdit);

		/**
		 * thêm 1 button với chức năng xóa sản phẩm khỏi danh sách
		 */
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				del();
			}
		});
		btnDel.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Trash-2.16.png")));
		btnDel.setBounds(183, 108, 78, 32);
		panel_1.add(btnDel);
		int count1 = 0;

		/**
		 * button với chức năng Sắp xếp lại thông tin của bảng
		 */
		JButton btnSorted = new JButton("Sort");
		btnSorted.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSorted.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<TV> results = getTableData();
				sort(results);

			}
		});
		btnSorted.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Shuffle.16.png")));
		btnSorted.setBounds(296, 52, 109, 32);
		panel_1.add(btnSorted);

		/**
		 * Hiện 1 danh sách có sẵn 20 thông tin
		 */

		JButton btnList = new JButton("Show list");
		btnList.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Clipboard.16.png")));
		btnList.setBounds(271, 108, 131, 32);
		panel_1.add(btnList);
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearTable();
				create();

			}
		});

		/**
		 * button với chức năng tìm kiếm thông tin
		 */
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTable();
				search();
			}
		});
		btnSearch.setBounds(529, 10, 109, 32);
		panel_2.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(TVManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));

	}
}
