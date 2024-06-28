package view;

import model.Laptop;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LaptopManagerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtProduct_id;
	private JTextField txtProduct_name;
	private JTextField txtProduct_price;
	private JTextField txtProduct_total;
	private JTextField txtLaptop_type;
	private JTextField txtLaptop_ram;
	private JTextField txtSearch;
	private JComboBox<String> comboBox_Sort;
	private JComboBox<String> comboBox_Sorted_by;
	private JComboBox<String> comboBox_Search;
//	private DefaultTableModel tableModel;
	public List<Laptop> list = new ArrayList<Laptop>();

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
			txtLaptop_type.setText(table.getValueAt(selectedRow, 4).toString());
			txtLaptop_ram.setText(table.getValueAt(selectedRow, 5).toString());
		}
	}

	/**
	 * Phưởng thức thêm 1 sản phẩm vào danh sách và bảng
	 */
	public void add() {
//		int selectedRow = table.getSelectedRow();
//
//		if (selectedRow == -1) {
//			JOptionPane.showMessageDialog(table, "Chưa có gì", "Error", JOptionPane.ERROR_MESSAGE);
//			return;
//		}

		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		String tmp = txtProduct_id.getText();
		if (tmp.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Please fill out all of these fields", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int idc = Integer.parseInt(tmp);// idc là id của sản phẩm sắp thêm để check xem đã tồn tại hay chưa

		// lấy thông tin từ các ô
		String Product_id = txtProduct_id.getText();
		String Product_name = txtProduct_name.getText();
		String Product_price = txtProduct_price.getText();
		String Product_total = txtProduct_total.getText();
		String Laptop_type = txtLaptop_type.getText();
		String Laptop_ram = txtLaptop_ram.getText();

		// kiểm tra xem có ô nào chưa nhập thông tin
		if (Product_id.isEmpty() || Product_name.isEmpty() || Product_price.isEmpty() || Product_total.isEmpty()
				|| Laptop_type.isEmpty()  || Laptop_ram.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Please fill out all of these fields", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// kiểm tra xem có id nào đã tồn tại trong danh sách
		for (Laptop laptop : list) {
			if (laptop.getProduct_id() == idc) {
				// hiện thông báo có lỗi khi có ô trùng thông tin
				JOptionPane.showMessageDialog(contentPane, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

		}

		// chuyển các kiểu dữ liệu về dạng đúng của nó
		int pi = Integer.parseInt(Product_id);
		int pt = Integer.parseInt(Product_total);
		int lr = Integer.parseInt(Laptop_ram);
		double pp = Double.parseDouble(Product_price);
		int c = JOptionPane.showConfirmDialog(this, "Are you sure to ADD this item?");
		if (c == JOptionPane.OK_OPTION) {
			// vector chứa thông tin để cho vào bảng
			Vector a = new Vector<Laptop>();
			a.add(Product_id);
			a.add(Product_name);
			a.add(Product_price);
			a.add(Product_total);
			a.add(Laptop_type);
			a.add(Laptop_ram);
			dtm.addRow(a);// thêm dữ liệu vào bảng
			dtm.fireTableDataChanged();// cập nhật dữ liệu

			// thêm vào danh sách
			this.list.add(new Laptop(pi, Product_name, pp, pt, Laptop_type, lr));// thêm vào list (danh sách)
		} else {
			return;
		}
		
		JOptionPane.showMessageDialog(contentPane, "Successfully added");
		// set các ô nhập dữ liệu về trống để tiện cho việc nhập thônng tin mới
		this.txtProduct_id.setText("");
		this.txtProduct_name.setText("");
		this.txtProduct_price.setText("");
		this.txtProduct_total.setText("");
		this.txtLaptop_type.setText("");
		this.txtLaptop_ram.setText("");

	}

	/**
	 * phương thức sửa 1 sản phẩm
	 */
	public void edit() {
		int selectedRow = table.getSelectedRow(), count = -1;

		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(contentPane, "Choose 1 item please!", "Error", JOptionPane.ERROR_MESSAGE);
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
		String Laptop_type = txtLaptop_type.getText();
		String Laptop_ram = txtLaptop_ram.getText();

		if (Product_id.isEmpty() || Product_name.isEmpty() || Product_price.isEmpty() || Product_total.isEmpty()
				|| Laptop_type.isEmpty()  || Laptop_ram.isEmpty()) {
			JOptionPane.showMessageDialog(contentPane, "Please fill out all of these fields", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if (selectedRow != -1) {
			for (Laptop laptop : this.list) {
				count++;
				if (laptop.getProduct_id() == pi && count != selectedRow) {
					JOptionPane.showMessageDialog(contentPane, "ID already exists", "Error",
							JOptionPane.ERROR_MESSAGE);
					// gán cờ nếu có id trùng thì hiển thị thông báo lỗi và ko thêm sản phảm mới vào
					// danh sách
					flag = false;
					return;
				}
			}
		}
		if (flag) {
			int pt = Integer.parseInt(Product_total);
			int lr = Integer.parseInt(Laptop_ram);
			double pp = Double.parseDouble(Product_price);
			int c = JOptionPane.showConfirmDialog(this, "Are you sure to EDIT this item?");
			if (c == JOptionPane.OK_OPTION) {
				Laptop editedLaptop = new Laptop(pi, Product_name, pp, pt, Laptop_type, lr);

				// set lại thông tin cho sản phẩm đã sửa
				this.list.set(selectedRow, editedLaptop);

				// set lại dữ liệu cho các dòng và cột tương ứng <dtm.setValueAt("thong tin", số
				// dòng, số cột)>
				dtm.setValueAt(Product_id, selectedRow, 0);
				dtm.setValueAt(Product_name, selectedRow, 1);
				dtm.setValueAt(Product_price, selectedRow, 2);
				dtm.setValueAt(Product_total, selectedRow, 3);
				dtm.setValueAt(Laptop_type, selectedRow, 4);
				dtm.setValueAt(Laptop_ram, selectedRow, 5);

				JOptionPane.showMessageDialog(contentPane, "Successfully edited");
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
			int c = JOptionPane.showConfirmDialog(contentPane, "Are you sure to DELETE this item?");
			if (c == JOptionPane.OK_OPTION) {
				Laptop laptopRemove = this.list.get(selectedRow);
				dtm.removeRow(selectedRow); // Xóa dòng này khỏi bảng
				this.list.remove(laptopRemove); // xóa laptop khỏi danh sách
			} else {
				return;
			}
			
		} else {
			JOptionPane.showMessageDialog(contentPane, "Choose 1 item please!");
		}
		JOptionPane.showMessageDialog(contentPane, "Successfully deleted");
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
	public List<Laptop> searchByLaptoptype(String name) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
			if (laptop.getLaptop_type().equals(name)) {
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
	public List<Laptop> searchByLaptopRam(int ram) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
			if (laptop.getLaptop_ram() == ram) {
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
	public List<Laptop> searchByProductId(int id) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
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
	public List<Laptop> searchByProductName(String name) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
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
	public List<Laptop> searchByProductTotal(int total) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
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
	public List<Laptop> searchByProductPrice(double price) {
		List<Laptop> results = new ArrayList<Laptop>();
		for (Laptop laptop : this.list) {
			if (laptop.getProduct_price() == price) {
				results.add(laptop);
			}
		}
		return results;
	}

	/**
	 * Phương thức sắp xếp theo tên Laptop
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<Laptop> sortedByLaptopType(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparing(Laptop::getLaptop_type));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	

	/**
	 * Phương thức sắp xếp theo RAM laptop
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<Laptop> sortedByLaptopRam(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(Laptop::getLaptop_ram));
		}
		if (!isSort) {
			Collections.reverse(list1);
		}
		return list1;
	}

	/**
	 * Phương thức sắp xếp theo mã sản phẩm
	 * 
	 * @param list1  danh sách cần sắp xếp
	 * @param isSort tằng hay giảm
	 * @return danh sách đã sắp xếp
	 */
	public List<Laptop> sortedByProductId(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(Laptop::getProduct_id));
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
	public List<Laptop> sortedByProductName(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparing(Laptop::getProduct_name));
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
	public List<Laptop> sortedByProductPrice(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingDouble(Laptop::getProduct_price));
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
	public List<Laptop> sortedByProductTotal(List<Laptop> list1, boolean isSort) {
		if (list1 != null) {
			Collections.sort(list1, Comparator.comparingInt(Laptop::getProduct_total));
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
	public List<Laptop> getTableData() {
		List<Laptop> data = new ArrayList<>();
		int rowCount = table.getRowCount();
		int colCount = table.getColumnCount();

		for (int i = 0; i < rowCount; i++) {

			int Product_id = Integer.parseInt(table.getValueAt(i, 0).toString());
			String Product_name = table.getValueAt(i, 1).toString();
			double Product_price = Double.parseDouble(table.getValueAt(i, 2).toString());
			int Product_total = Integer.parseInt(table.getValueAt(i, 3).toString());

			String Laptop_type = table.getValueAt(i, 4).toString();
			int Laptop_ram = Integer.parseInt(table.getValueAt(i, 5).toString());

			data.add(new Laptop(Product_id, Product_name, Product_price, Product_total, Laptop_type,
					Laptop_ram));
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
		List<Laptop> results = new ArrayList<Laptop>();
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
		case "Laptop Type":
			results = searchByLaptoptype(searchText);
			break;
		case "Laptop's Ram":
			results = searchByLaptopRam(Integer.parseInt(searchText));
			break;
		}
		addData(results);
	}

	/**
	 * Phương thức tìm kiếm
	 * 
	 * @param results danh sách đã đc sắp xếp
	 */
	public void sort(List<Laptop> results) {
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
			case "Laptop Type":
				sortedByLaptopType(results, flag);
				break;
			case "Laptop's Ram":
				sortedByLaptopRam(results, flag);
				break;
			}
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
			case "Laptop Type":
				sortedByLaptopType(results, flag);
				break;
			case "Laptop's Ram":
				sortedByLaptopRam(results, flag);
				break;
			}
		}
		addData(results);
		dtm.fireTableDataChanged();
	}

	/**
	 * Phưởng thức hiển thị thông tin vào bảng
	 * 
	 * @param results
	 */
	public void addData(List<Laptop> results) {
		clearTable();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (Laptop laptop : results) {
			Vector<Object> row = new Vector<Object>();
			row.add(laptop.getProduct_id());
			row.add(laptop.getProduct_name());
			row.add(laptop.getProduct_price());
			row.add(laptop.getProduct_total());
			row.add(laptop.getLaptop_type());
			row.add(laptop.getLaptop_ram());
			dtm.addRow(row);
		}
		dtm.fireTableDataChanged();// cập nhật lại thông tin của bảng
	}

	/**
	 * Phương thức tạo ra 1 danh sách
	 */
	public void create() {
		int n = 20;
		this.list = new ArrayList<Laptop>(n);
		HashMap<Integer, Laptop> tmp = new HashMap<Integer, Laptop>();//
		Laptop l;
		int value;
		while (tmp.size() < n) {
			value = 1 + (int) (Math.random() * 100);
			if (!tmp.containsKey(value)) {
				l = Laptop.createProduct(value);
				tmp.put(value, l);
				this.list.add(l);
			}
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (Laptop laptop : this.list) {

			Vector a = new Vector<Laptop>();
			a.add(laptop.getProduct_id());
			a.add(laptop.getProduct_name());
			a.add(laptop.getProduct_price());
			a.add(laptop.getProduct_total());
			a.add(laptop.getLaptop_type());
			a.add(laptop.getLaptop_ram());
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
	private void btnBackActionPerformed(MouseEvent e) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnBackActionPerformed

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaptopManagerGUI frame = new LaptopManagerGUI();
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
	public LaptopManagerGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LaptopManagerGUI.class.getResource("/icons/ypp.png")));
		setTitle("Laptop Management");
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
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "NAME", "PRICE", "TOTAL", "TYPE", "RAM"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(61);
		table.getColumnModel().getColumn(1).setPreferredWidth(71);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setPreferredWidth(73);
		table.getColumnModel().getColumn(4).setPreferredWidth(71);
		scrollPane.setViewportView(table);
		table.setRowHeight(25); // Đặt chiều cao mặc định của các dòng là 25 pixels
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

		JLabel lblProduct_id = new JLabel("Product ID");
		lblProduct_id.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct_id.setBounds(10, 74, 138, 25);
		panel.add(lblProduct_id);

		JLabel lblProduct_Name = new JLabel("Product Name");
		lblProduct_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct_Name.setBounds(10, 120, 138, 25);
		panel.add(lblProduct_Name);

		JLabel lblProduct_price = new JLabel("Product Price");
		lblProduct_price.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct_price.setBounds(10, 166, 138, 25);
		panel.add(lblProduct_price);

		JLabel lblProduct_total = new JLabel("Product Total");
		lblProduct_total.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProduct_total.setBounds(10, 212, 138, 25);
		panel.add(lblProduct_total);

		JLabel lblLaptoptype = new JLabel("Laptop Type");
		lblLaptoptype.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLaptoptype.setBounds(10, 258, 138, 25);
		panel.add(lblLaptoptype);

		JLabel lblRam = new JLabel("Laptop's Ram");
		lblRam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRam.setBounds(10, 304, 138, 25);
		panel.add(lblRam);

		txtProduct_id = new JTextField();
		txtProduct_id.setBounds(171, 64, 232, 32);
		panel.add(txtProduct_id);
		txtProduct_id.setColumns(10);

		txtProduct_name = new JTextField();
		txtProduct_name.setColumns(10);
		txtProduct_name.setBounds(171, 112, 232, 32);
		panel.add(txtProduct_name);

		txtProduct_price = new JTextField();
		txtProduct_price.setColumns(10);
		txtProduct_price.setBounds(171, 160, 232, 32);
		panel.add(txtProduct_price);

		txtProduct_total = new JTextField();
		txtProduct_total.setColumns(10);
		txtProduct_total.setBounds(171, 208, 232, 32);
		panel.add(txtProduct_total);

		txtLaptop_type = new JTextField();
		txtLaptop_type.setColumns(10);
		txtLaptop_type.setBounds(171, 256, 232, 32);
		panel.add(txtLaptop_type);

		txtLaptop_ram = new JTextField();
		txtLaptop_ram.setColumns(10);
		txtLaptop_ram.setBounds(171, 304, 232, 32);
		panel.add(txtLaptop_ram);

		JLabel lblTitle0 = new JLabel("Information");
		lblTitle0.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-File-text.16.png")));
		lblTitle0.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle0.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle0.setBounds(116, 10, 181, 32);
		panel.add(lblTitle0);

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

		JLabel lblTitle2 = new JLabel("Function");
		lblTitle2.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Tool.16.png")));
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitle2.setBounds(116, 10, 181, 32);
		panel_1.add(lblTitle2);

		JLabel lblSort = new JLabel("Sort");
		lblSort.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSort.setBounds(29, 56, 78, 25);
		panel_1.add(lblSort);

		// Panel 2
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(433, 81, 648, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSearch = new JLabel("Input search");
		lblSearch.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));
		lblSearch.setBounds(10, 14, 138, 25);
		panel_2.add(lblSearch);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtSearch = new JTextField();
		txtSearch.setBounds(134, 10, 251, 32);
		panel_2.add(txtSearch);
		txtSearch.setColumns(10);
		comboBox_Sort = new JComboBox<String>();
		comboBox_Sort.setFont(new Font("Dialog", Font.PLAIN, 12));
		;
		comboBox_Sort.setModel(new DefaultComboBoxModel(new String[] {"Product_id", "Product_name", "Product_price", "Product_total", "Laptop Type", "Laptop's Ram"}));
		comboBox_Sort.setBounds(101, 54, 101, 32);
		panel_1.add(comboBox_Sort);

		comboBox_Search = new JComboBox<String>();
		comboBox_Search.setBounds(395, 10, 124, 32);
		panel_2.add(comboBox_Search);
		comboBox_Search.setModel(new DefaultComboBoxModel(new String[] {"Product_id", "Product_name", "Product_price", "Product_total", "Laptop Type", "Laptop's Ram"}));
		comboBox_Search.setFont(new Font("Dialog", Font.PLAIN, 12));

		comboBox_Sorted_by = new JComboBox<String>();
		comboBox_Sorted_by.setFont(new Font("Dialog", Font.PLAIN, 12));
		comboBox_Sorted_by.setModel(new DefaultComboBoxModel(new String[] {"Asc", "Des"}));
		comboBox_Sorted_by.setBounds(219, 52, 72, 32);
		panel_1.add(comboBox_Sorted_by);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(224, 255, 255));
		panel_3.setBounds(10, 10, 1071, 61);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblTitle = new JLabel(" Laptop Management System");
		lblTitle.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/laptop-screen.png")));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setBounds(10, 0, 522, 61);
		panel_3.add(lblTitle);
		
		JLabel lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnBackActionPerformed(e);
			}
		});
		lblBack.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/undo.png")));
		lblBack.setBounds(1015, 14, 46, 32);
		panel_3.add(lblBack);

		/**
		 * Thêm 1 button với chức năng thêm Laptop vào danh sách
		 */
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBackground(new Color(253, 245, 230));

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = getSize1();
				if (k == 0) {
					clearTable();
				}
				add();
			}
		});
		btnAdd.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Plus-square.16.png")));
		btnAdd.setBounds(5, 108, 91, 32);
		panel_1.add(btnAdd);

		/**
		 * thêm 1 button với chức năng sửa sản phẩm trong danh sách
		 */
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				edit();
			}
		});
		btnEdit.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Sliders.16.png")));
		btnEdit.setBounds(101, 108, 78, 32);
		panel_1.add(btnEdit);

		/**
		 * thêm 1 button với chức năng xóa sản phẩm khỏi danh sách
		 */
		JButton btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				del();
			}
		});
		btnDel.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Trash-2.16.png")));
		btnDel.setBounds(184, 108, 95, 32);
		panel_1.add(btnDel);
		int count1 = 0;

		/**
		 * button với chức năng Sắp xếp lại thông tin của bảng
		 */
		JButton btnSorted = new JButton("Sort");
		btnSorted.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSorted.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<Laptop> results = getTableData();
				sort(results);

			}
		});
		btnSorted.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Shuffle.16.png")));
		btnSorted.setBounds(296, 52, 109, 32);
		panel_1.add(btnSorted);

		/**
		 * Hiện 1 danh sách có sẵn 20 thông tin
		 */

		JButton btnList = new JButton("Show list");
		btnList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnList.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Edit.16.png")));
		btnList.setBounds(284, 108, 120, 32);
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
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTable();
				search();
			}
		});
		btnSearch.setBounds(529, 10, 109, 32);
		panel_2.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(LaptopManagerGUI.class.getResource("/icons/Colebemis-Feather-Search.16.png")));

	}
}
