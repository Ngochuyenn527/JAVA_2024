package view;

import model.MobileManagerImpl;
import model.Mobile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditView extends javax.swing.JFrame {
    private ArrayList<Mobile> list;
    private ViewMobile viewMobile;
    private MobileManagerImpl mmi = new MobileManagerImpl();;
    private int index;

    
    public EditView(ArrayList<Mobile> inputList, ViewMobile inputViewMobile, int index) {
        initComponents();
        this.list = inputList;
        this.viewMobile = inputViewMobile;
        this.index = index;
        this.setLocationRelativeTo(null); //căn giữa
    }
  
    /**
     * thêm thông tin Mobile của row được chọn vào jFrame EditView để chỉnh sửa
     * @param inputValue 
     */
    public void setValue(Mobile m) {
        idtext.setText(Integer.toString(m.getProduct_id()));
        nametext.setText(m.getProduct_name());
        pricetext.setText(Double.toString(m.getProduct_price()));
        totaltext.setText(Integer.toString(m.getProduct_total()));
        colortext.setText(m.getColor());
        sstext.setText(Double.toString(m.getScreensize()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Edit = new javax.swing.JButton();
        idtext = new javax.swing.JTextField();
        nametext = new javax.swing.JTextField();
        pricetext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        totaltext = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        colortext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sstext = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Edit.setBackground(new java.awt.Color(255, 204, 0));
        Edit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Edit.setForeground(new java.awt.Color(0, 0, 0));
        Edit.setText("Edit");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        idtext.setEditable(false);
        idtext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        nametext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        pricetext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("EDIT MOBILE");

        totaltext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("INPUT ID:");

        colortext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("INPUT NAME:");

        sstext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("INPUT PRICE:");

        Cancel.setBackground(new java.awt.Color(204, 204, 204));
        Cancel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(0, 0, 0));
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("INPUT TOTAL:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("INPUT COLOR:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("INPUT SCREENSIZE:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(Cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nametext)
                            .addComponent(idtext)
                            .addComponent(pricetext)
                            .addComponent(totaltext)
                            .addComponent(colortext, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sstext, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(182, 182, 182))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel4)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel6)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(sstext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(pricetext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(totaltext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(colortext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nhấn vào nút Edit hệ thống sẽ cập nhật lại thông tin của Mobile vào danh sách
     * Không được chỉnh sửa ID
     * @param evt 
     */
    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        // TODO add your handling code here:
        Mobile m = new Mobile();
        int id = Integer.parseInt(idtext.getText());
        String name =(nametext.getText());
        double price =(Double.parseDouble(pricetext.getText()));
        int total =(Integer.parseInt(totaltext.getText()));
        String color =(colortext.getText());
        double ss =(Double.parseDouble(sstext.getText()));
        
        this.list.get(index).setProduct_id(id);
        this.list.get(index).setProduct_name(name);
        this.list.get(index).setProduct_price(price);
        this.list.get(index).setProduct_total(total);
        this.list.get(index).setColor(color);
        this.list.get(index).setScreensize(ss);
        
        int c = JOptionPane.showConfirmDialog(this, "Are you sure to EDIT this item?");
        if (c == JOptionPane.OK_OPTION) {
            this.viewMobile.showListData(list);
            this.dispose();         
        } 
        else {
            return;
        }
    }//GEN-LAST:event_EditActionPerformed

    
    /**
     * Nhấn vào nút Cancel để hủy thực hiện Edit Mobile
     * Khi đó giao diện của EditView sẽ được ẩn đi
     * @param evt 
     */
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        new ViewMobile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField colortext;
    private javax.swing.JTextField idtext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nametext;
    private javax.swing.JTextField pricetext;
    private javax.swing.JTextField sstext;
    private javax.swing.JTextField totaltext;
    // End of variables declaration//GEN-END:variables
}
