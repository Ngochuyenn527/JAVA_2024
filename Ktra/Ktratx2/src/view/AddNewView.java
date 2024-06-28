package view;
import model.MobileManagerImpl;
import model.Mobile;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AddNewView extends javax.swing.JFrame {
    private ArrayList<Mobile> list;
    private ViewMobile viewMobile;
    private MobileManagerImpl mmi = new MobileManagerImpl();;
 
    
    public AddNewView(ArrayList<Mobile> inputList, ViewMobile inputViewMobile) {
        initComponents();
        this.list = inputList;
        this.viewMobile = inputViewMobile;
        this.setLocationRelativeTo(null); //căn giữa
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        idtext = new javax.swing.JTextField();
        nametext = new javax.swing.JTextField();
        pricetext = new javax.swing.JTextField();
        totaltext = new javax.swing.JTextField();
        colortext = new javax.swing.JTextField();
        sstext = new javax.swing.JTextField();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ADD MOBILE");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("INPUT ID:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("INPUT NAME:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("INPUT PRICE:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("INPUT TOTAL:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("INPUT COLOR:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("INPUT SCREENSIZE:");

        Add.setBackground(new java.awt.Color(51, 255, 255));
        Add.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Add.setForeground(new java.awt.Color(0, 0, 0));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        idtext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        nametext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        pricetext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        totaltext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        colortext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        sstext.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        Cancel.setBackground(new java.awt.Color(204, 204, 204));
        Cancel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Cancel.setForeground(new java.awt.Color(0, 0, 0));
        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(colortext, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sstext, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(totaltext, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(nametext)
                                    .addComponent(pricetext)
                                    .addComponent(idtext)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idtext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pricetext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(totaltext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(colortext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sstext, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Nhấn vào nút Add hệ thống sẽ thực hiện thêm thuộc tính vào danh sách
     * Bắt lỗi trùng ID đã tồn tại và các trường bị để trống
     * @param evt 
     */
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        try{
            Mobile m = new Mobile();
            m.setProduct_id(Integer.parseInt(idtext.getText()));
            m.setProduct_name(nametext.getText());
            m.setProduct_price(Double.parseDouble(pricetext.getText()));
            m.setProduct_total(Integer.parseInt(totaltext.getText()));
            m.setColor(colortext.getText());
            m.setScreensize(Double.parseDouble(sstext.getText()));

            // Thêm máy tính mới vào danh sách
            for (Mobile mobile : this.list) {
                    if(mobile.getProduct_id() == m.getProduct_id()) {
                        JOptionPane.showMessageDialog(this, "ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
            }
            this.list.add(m);

            int c = JOptionPane.showConfirmDialog(this, "Are you sure to ADD this item?");
            if (c == JOptionPane.OK_OPTION) {
                this.viewMobile.showListData(list);
                this.dispose();         
            } 
            else {
                return;
            }
        }
        catch(NumberFormatException e){ // bắt lỗi nếu các trường bị để trống
             JOptionPane.showMessageDialog(this, "Please fill out all of these fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_AddActionPerformed
    
    
    /**
     * Nhấn vào nút Cancel để hủy thực hiện Add Mobile
     * Khi đó giao diện của AddNewView sẽ được ẩn đi
     * @param evt 
     */
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        // TODO add your handling code here:
        this.viewMobile.showListData(list);
        this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Cancel;
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
