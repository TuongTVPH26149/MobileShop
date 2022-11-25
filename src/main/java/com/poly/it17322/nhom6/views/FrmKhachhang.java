/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17322.nhom6.views;

import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.services.impl.KhachHangService;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author LiamTrieu
 */
public class FrmKhachhang extends javax.swing.JPanel {

    ArrayList<KhachHangResponse> listkh = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    private KhachHangService KHSer;
    public int index = -1;

    public FrmKhachhang() {
        initComponents();
        KHSer = new KhachHangService();

        setBackground(new Color(0, 0, 0, 0));
        tblkhachhang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblkhachhang.getTableHeader().setBackground(new Color(32, 136, 203));
        tblkhachhang.getTableHeader().setForeground(Color.white);
        tbldaxoa.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tbldaxoa.getTableHeader().setBackground(new Color(32, 136, 203));
        tbldaxoa.getTableHeader().setForeground(Color.white);
        filltiTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txttimkiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttimkiemngaysinh = new javax.swing.JTextField();
        cbolocgioitinh = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbldaxoa = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttimkiemngaysinh1 = new javax.swing.JTextField();
        cbolocgioitinh1 = new javax.swing.JComboBox<>();
        txttimkiem1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        txtngaysinh = new javax.swing.JTextField();
        rdonam = new javax.swing.JRadioButton();
        rdonu = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdiachi = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btntimkiem = new javax.swing.JButton();
        btnstart = new javax.swing.JButton();
        btnlen = new javax.swing.JButton();
        btnxuong = new javax.swing.JButton();
        btnend = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));

        jTabbedPane1.setBackground(new java.awt.Color(51, 102, 255));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "SĐT", "Địa chỉ", "Ngày sinh", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblkhachhang.setFocusable(false);
        tblkhachhang.setGridColor(new java.awt.Color(0, 0, 0));
        tblkhachhang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblkhachhang.setRowHeight(30);
        tblkhachhang.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachhangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblkhachhang);

        jLabel9.setText("Tìm Kiếm:");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Giới tính:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ngày Sinh:");

        txttimkiemngaysinh.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbolocgioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txttimkiemngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(cbolocgioitinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(cbolocgioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimkiemngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Khách hàng", jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        tbldaxoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "SĐT", "Địa chỉ", "Ngày sinh", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbldaxoa.setFocusable(false);
        tbldaxoa.setGridColor(new java.awt.Color(0, 0, 0));
        tbldaxoa.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbldaxoa.setRowHeight(30);
        tbldaxoa.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tbldaxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldaxoaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbldaxoa);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc"));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Giới tính:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Ngày Sinh:");

        txttimkiemngaysinh1.setBorder(null);

        cbolocgioitinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txttimkiemngaysinh1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(cbolocgioitinh1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(cbolocgioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttimkiemngaysinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel12.setText("Tìm Kiếm:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttimkiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Đã xóa", jPanel4);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Mã:");

        txtma.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Họ tên:");

        txthoten.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Ngày sinh:");

        txtsdt.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtngaysinh.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        rdonam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");
        rdonam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        rdonu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdonu);
        rdonu.setText("Nữ");
        rdonu.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        rdonu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rdonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonuActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Giới tính:");

        txtdiachi.setColumns(20);
        txtdiachi.setRows(5);
        jScrollPane2.setViewportView(txtdiachi);

        btnthem.setBackground(new java.awt.Color(255, 255, 255));
        btnthem.setIcon(new ImageIcon("src/main/resource/icon/add.png"));
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(255, 255, 255));
        btnsua.setIcon(new ImageIcon("src/main/resource/icon/update.png"));
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btntimkiem.setBackground(new java.awt.Color(255, 255, 255));
        btntimkiem.setIcon(new ImageIcon("src/main/resource/icon/clear.png"));
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnthem, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdonam)
                        .addGap(71, 71, 71)
                        .addComponent(rdonu))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                        .addComponent(txtma, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(126, 126, 126)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdonam)
                            .addComponent(rdonu))
                        .addGap(64, 64, 64)))
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnstart.setBackground(new java.awt.Color(255, 255, 255));
        btnstart.setIcon(new ImageIcon("src/main/resource/icon/start.png"));
        btnstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstartActionPerformed(evt);
            }
        });

        btnlen.setBackground(new java.awt.Color(255, 255, 255));
        btnlen.setIcon(new ImageIcon("src/main/resource/icon/up.png"));
        btnlen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlenActionPerformed(evt);
            }
        });

        btnxuong.setBackground(new java.awt.Color(255, 255, 255));
        btnxuong.setIcon(new ImageIcon("src/main/resource/icon/down.png"));
        btnxuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuongActionPerformed(evt);
            }
        });

        btnend.setBackground(new java.awt.Color(255, 255, 255));
        btnend.setForeground(new java.awt.Color(255, 255, 255));
        btnend.setIcon(new ImageIcon("src/main/resource/icon/end.png"));
        btnend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnstart, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnlen)
                        .addGap(37, 37, 37)
                        .addComponent(btnxuong)
                        .addGap(33, 33, 33)
                        .addComponent(btnend))
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnend, btnlen, btnstart, btnxuong});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnstart)
                    .addComponent(btnlen)
                    .addComponent(btnxuong)
                    .addComponent(btnend, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnend, btnlen, btnstart, btnxuong});

    }// </editor-fold>//GEN-END:initComponents

    private void rdonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonuActionPerformed

    private void btnendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnendActionPerformed
        index = listkh.size() - 1;
        writeForm();
    }//GEN-LAST:event_btnendActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        try {
            Insert();
            JOptionPane.showMessageDialog(this, "Insert Thanh Cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Insert That bai");
            return;
        }


    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        try {
            Update();
            JOptionPane.showMessageDialog(this, "Update Thanh Cong");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update That bai");
            return;
        }


    }//GEN-LAST:event_btnsuaActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        clearForm();
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btnxuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuongActionPerformed
        index++;
        writeForm();
    }//GEN-LAST:event_btnxuongActionPerformed

    private void btnlenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlenActionPerformed
        index--;
        writeForm();
    }//GEN-LAST:event_btnlenActionPerformed

    private void btnstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstartActionPerformed
        index = 0;
        writeForm();
    }//GEN-LAST:event_btnstartActionPerformed

    private void tblkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangMouseClicked
        index = tblkhachhang.getSelectedRow();
        showdetail();
    }//GEN-LAST:event_tblkhachhangMouseClicked

    private void tbldaxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldaxoaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldaxoaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnend;
    private javax.swing.JButton btnlen;
    private javax.swing.JButton btnstart;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxuong;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbolocgioitinh;
    private javax.swing.JComboBox<String> cbolocgioitinh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JRadioButton rdonu;
    private javax.swing.JTable tbldaxoa;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTextArea txtdiachi;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttimkiem1;
    private javax.swing.JTextField txttimkiemngaysinh;
    private javax.swing.JTextField txttimkiemngaysinh1;
    // End of variables declaration//GEN-END:variables

    private void filltiTable() {
        model = (DefaultTableModel) tblkhachhang.getModel();
        model.setRowCount(0);
        for (KhachHangResponse x : KHSer.getlist()) {
            model.addRow(new Object[]{x.getMa(), x.getHoten(), x.getGioitinh()==0?"Nam":"Nữ", x.getSdt(), x.getDiachi(), x.getNgaysinh()});
            listkh.add(x);
        }

    }

    private void showdetail() {
        txtma.setText(tblkhachhang.getValueAt(index, 0).toString());
        txthoten.setText(tblkhachhang.getValueAt(index, 1).toString());
        txtsdt.setText(tblkhachhang.getValueAt(index, 3).toString());
        txtdiachi.setText(tblkhachhang.getValueAt(index, 4).toString());
        txtngaysinh.setText(tblkhachhang.getValueAt(index, 5).toString());
        if (tblkhachhang.getValueAt(index, 2).equals("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }

    }

    private void Insert() {
        String ma = txtma.getText().trim();
        String hoten = txthoten.getText().trim();
        int gioitinh = rdonu.isSelected() ? 1 : 0;
        String sdt = txtsdt.getText().trim();
        String diachi = txtdiachi.getText().trim();
        Date ngaysinh = Date.valueOf(txtngaysinh.getText().trim());
        if (ma.length() == 0 || hoten.length() == 0 || rdonam.isSelected() || rdonu.isSelected() || sdt.length() == 0 || diachi.length() == 0 || ngaysinh.equals("")) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong");
            return;
        }
        KhachHangResponse kh = new KhachHangResponse();
        kh.setMa(ma);
        kh.setHoten(hoten);
        kh.setGioitinh(gioitinh);
        kh.setSdt(sdt);
        kh.setDiachi(diachi);
        kh.setNgaysinh(ngaysinh);

        KHSer.Insert(kh);
        clearForm();
        filltiTable();

    }

    private void Update() {
        String ma = txtma.getText().trim();
        String hoten = txthoten.getText().trim();
        int gioitinh = rdonu.isSelected() ? 1 : 0;
        String sdt = txtsdt.getText().trim();
        String diachi = txtdiachi.getText().trim();
        Date ngaysinh = Date.valueOf(txtngaysinh.getText().trim());
        if (ma.length() == 0 || hoten.length() == 0 || rdonam.isSelected() || rdonu.isSelected()  || diachi.length() == 0 || ngaysinh.equals("")) {
            JOptionPane.showMessageDialog(this, "Khong duoc de trong");
            return;
        }
        KhachHangResponse kh = new KhachHangResponse();
        index = tblkhachhang.getSelectedRow();
        kh.setId(listkh.get(index).getId());
        kh.setMa(ma);
        kh.setHoten(hoten);
        kh.setGioitinh(gioitinh);
        kh.setSdt(sdt);
        kh.setDiachi(diachi);
        kh.setNgaysinh(ngaysinh);

        KHSer.Update(kh);
        clearForm();
        filltiTable();
    }

    private void writeForm() {
        txtma.setText(tblkhachhang.getValueAt(index, 0).toString());
        txthoten.setText(tblkhachhang.getValueAt(index, 1).toString());
        txtsdt.setText(tblkhachhang.getValueAt(index, 3).toString());
        txtdiachi.setText(tblkhachhang.getValueAt(index, 4).toString());
        txtngaysinh.setText(tblkhachhang.getValueAt(index, 5).toString());
        if (tblkhachhang.getValueAt(index, 2).toString().equals("Nam")) {
            rdonam.setSelected(true);
        } else {
            rdonu.setSelected(true);
        }
        tblkhachhang.setRowSelectionInterval(index, index);

    }

    private void clearForm() {
        txtdiachi.setText("");
        txthoten.setText("");
        txtma.setText("");
        txtngaysinh.setText("");
        txtsdt.setText("");
    }

}
