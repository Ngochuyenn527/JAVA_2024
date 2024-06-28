package view;

import model.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;


public class ViewMobile extends javax.swing.JFrame {
    private ArrayList<Mobile> list = new ArrayList<>();
    private MobileManagerImpl mmi;
    private DefaultTableModel defaultTableModel;
    private String[] table_headers = {"ID", "Name", "Price", "Total", "Color", "Screensize"};

    public ViewMobile() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mmi = new MobileManagerImpl();
        list = mmi.generateList(4);
        
        this.setVisible(true);
        this.setLocationRelativeTo(null); //background center
        showListData(list);
    }
    
    
    /**
     * show list
     * @param list 
     */
    public void showListData(List<Mobile> list) {
             defaultTableModel = new DefaultTableModel(){
            //nhằm 0 cho phép người dùng sửa dữ liệu trong bảng
            //tạo 1 class con extend đến class chính là defaulttable và overide lại hàm iscelledittable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };     
        tableView.setModel(defaultTableModel);
              
        for(int i=0; i<table_headers.length; i++){
            defaultTableModel.addColumn(table_headers[i]);
        }
        
        for (Mobile i : list) {
              defaultTableModel.addRow(new Object[] {i.getProduct_id(), i.getProduct_name(), i.getProduct_price(), i.getProduct_total(), i.getColor(), i.getScreensize()});
        }
        
        tableView.setVisible(true);
        //cập nhật dữ liệu trong bảng và muốn đảm bảo rằng bảng hiển thị dữ liệu mới nhất.
        defaultTableModel.fireTableDataChanged();
        tableView.repaint();
    }
    
    
    /**
     * Lấy thông tin của row từ bảng khi được onclick vào
     * @param row 
     */
    public void showRow(int row) {
        Mobile mobile = list.get(row);
        idtext.setText(String.valueOf(mobile.getProduct_id()));
        nametext.setText(mobile.getProduct_name());
        pricetext.setText(String.valueOf(mobile.getProduct_price()));
        totaltext.setText(String.valueOf(mobile.getProduct_total()));
        colortext.setText(mobile.getColor());
        sstext.setText(String.valueOf(mobile.getScreensize()));
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        jComboBox_Sort = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Edit = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        idtext = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nametext = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        totaltext = new javax.swing.JTextField();
        pricetext = new javax.swing.JTextField();
        colortext = new javax.swing.JTextField();
        sstext = new javax.swing.JTextField();
        Sort = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_Search = new javax.swing.JComboBox<>();
        input = new javax.swing.JTextField();
        Save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("MOBILE MANAGER");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Input Search :");

        Search.setBackground(new java.awt.Color(102, 255, 102));
        Search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Search.setForeground(new java.awt.Color(0, 0, 0));
        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jComboBox_Sort.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_Sort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Asc", "Des" }));

        tableView.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "PRICE", "TOTAL", "COLOR", "SCREENSIZE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableView.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableView.setRowHeight(30);
        tableView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableView);

        Add.setBackground(new java.awt.Color(51, 255, 255));
        Add.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(0, 0, 0));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Edit.setBackground(new java.awt.Color(255, 204, 0));
        Edit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Edit.setForeground(new java.awt.Color(0, 0, 0));
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(255, 51, 51));
        Delete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Delete.setForeground(new java.awt.Color(0, 0, 0));
        Delete.setText("Delele");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("ID:");

        idtext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("NAME:");

        nametext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("PRICE:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("COLOR:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("SCREENSIZE:");

        totaltext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        pricetext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        colortext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        sstext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        Sort.setBackground(new java.awt.Color(153, 153, 255));
        Sort.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Sort.setForeground(new java.awt.Color(0, 0, 0));
        Sort.setText("Sort");
        Sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Choose the sort type:");

        jComboBox_Search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jComboBox_Search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Price", "Color" }));

        Save.setBackground(new java.awt.Color(255, 0, 255));
        Save.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Save.setText("Save To File");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idtext)
                            .addComponent(nametext)
                            .addComponent(totaltext, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pricetext)
                                    .addComponent(colortext)
                                    .addComponent(sstext, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158)
                                .addComponent(Delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Save))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox_Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGap(407, 407, 407)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox_Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sort, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricetext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colortext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(totaltext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(sstext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * thông tin của row được lấy ra
     * @param evt 
     */
    private void tableViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableViewMouseClicked
        // TODO add your handling code here:
        int row = tableView.getSelectedRow();
        showRow(row);
    }//GEN-LAST:event_tableViewMouseClicked
    
    
    /**
     * Nhấn vào nút Add hệ thống sẽ display ra giao diện AddNewView
     * Thực hiện các thuộc tính và phương thức của AddNewView
     * @param evt 
     */
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        AddNewView addView = new AddNewView(list, this);
        addView.setVisible(true);
        addView.repaint();
    }//GEN-LAST:event_AddActionPerformed
    
    
    
    /**
     * Nhấn vào nút Edit hệ thống sẽ display ra giao diện EditView
     * Thực hiện các thuộc tính và phương thức của EditView
     * @param evt 
     */
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        int row = tableView.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Choose 1 item please!","Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            EditView editView = new EditView(list, this, row );
            editView.setValue(this.list.get(row));
            editView.setVisible(true);
            editView.repaint();
        }  
    }//GEN-LAST:event_EditActionPerformed
    
    
    /**
     * Nhấn vào nút Delete, hàng được chọn sẽ được xóa
     * Sau khi xóa thì các ô display cũng sẽ biến mất
     * @param evt 
     */
    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        // TODO add your handling code here:
        int row = tableView.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Choose 1 item please!","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure to DELETE this item?");
            if(confirm == JOptionPane.YES_OPTION){
                this.list.remove(row);
                showListData(list);
                
                //set rỗng các ô display
                idtext.setText("");
		nametext.setText("");
		pricetext.setText("");
		totaltext.setText("");
		colortext.setText("");
		sstext.setText("");
            }
        }
    }//GEN-LAST:event_DeleteActionPerformed
    
    
    /**
     * Nhấn vào nút Sort và chọn trình tự muốn sắp xếp
     * @param evt 
     */
    private void SortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortActionPerformed
        // TODO add your handling code here:
        String sortOption = jComboBox_Sort.getSelectedItem().toString();
        List<Mobile> sortResults;
        if (sortOption.contains("Asc")) {
           sortResults= mmi.sortedMobile(1); //tăng
        } else {
           sortResults = mmi.sortedMobile(0); //giảm
        }
        showListData(sortResults);
    }//GEN-LAST:event_SortActionPerformed

    
    /**
     * Nhấn vào nút Search và chọn thuộc tính muốn sắp xếp
     * Bảng sẽ hiện ra kết quả tìm kiếm được 
     * @param evt 
     */
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        String searchOption = jComboBox_Search.getSelectedItem().toString();
        String keyword = input.getText();
        List<Mobile> searchResults;
        if(searchOption.contains("Name")){
            searchResults = mmi.searchMobile(keyword);
            showListData(searchResults);
        }
        else if(searchOption.contains("Price")){
            searchResults = mmi.searchMobile_price(Double.parseDouble(keyword));
            showListData(searchResults);
        }
        else{
            searchResults = mmi.searchMobile_color(keyword);
            showListData(searchResults);
        }
        
    }//GEN-LAST:event_SearchActionPerformed
    
    
    /**
     * ghi dữ liệu ra file Mobile.bin
     * @throws IOException
     * @param evt 
     */
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        try {
            FileOutputStream of = new FileOutputStream("Mobile.bin");
            ObjectOutputStream out = new ObjectOutputStream(of);
            out.writeInt(2); // số lượng bản ghi trợ giúp đọc
            // Lặp qua từng hàng trong bảng
            for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                // Lấy giá trị từng ô trong hàng
                int id = (int) defaultTableModel.getValueAt(i, 0);
                String name = (String) defaultTableModel.getValueAt(i, 1);
                double price = (double) defaultTableModel.getValueAt(i, 2);
                int total = (int) defaultTableModel.getValueAt(i, 3);
                String color = (String) defaultTableModel.getValueAt(i, 4);
                double ss = (double) defaultTableModel.getValueAt(i, 5);

                // Tạo đối tượng từ các giá trị lấy được
                Mobile m = new Mobile(id, name, price, total, color, ss);
                // Ghi đối tượng vào file
                out.writeObject(m);
            }
            out.close();
            JOptionPane.showMessageDialog(this, "Save file successful!");
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_SaveActionPerformed

    
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                try {
                    ViewMobile viewMobile = new ViewMobile();
                    viewMobile.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
		}
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Edit;
    private javax.swing.JButton Save;
    private javax.swing.JButton Search;
    private javax.swing.JButton Sort;
    private javax.swing.JTextField colortext;
    private javax.swing.JTextField idtext;
    private javax.swing.JTextField input;
    private javax.swing.JComboBox<String> jComboBox_Search;
    private javax.swing.JComboBox<String> jComboBox_Sort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametext;
    private javax.swing.JTextField pricetext;
    private javax.swing.JTextField sstext;
    private javax.swing.JTable tableView;
    private javax.swing.JTextField totaltext;
    // End of variables declaration//GEN-END:variables
}
