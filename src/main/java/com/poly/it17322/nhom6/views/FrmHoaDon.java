/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17322.nhom6.views;
import com.poly.it17322.nhom6.responses.HoaDonChiTietResponse;
import com.poly.it17322.nhom6.responses.HoaDonResponse;
import com.poly.it17322.nhom6.responses.KhachHangResponse;
import com.poly.it17322.nhom6.services.IChiTietHoaDonService;
import com.poly.it17322.nhom6.services.IHoaDonService;
import com.poly.it17322.nhom6.services.IKhachHangService;
import com.poly.it17322.nhom6.services.impl.ChiTietHoaDonImpl;
import com.poly.it17322.nhom6.services.impl.HoaDonServiceImpl;
import com.poly.it17322.nhom6.services.impl.KhachHangService;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.jdbc.Work;
/**
 *
 * @author LiamTrieu
 */
public class FrmHoaDon extends javax.swing.JPanel {

    private IHoaDonService hoadonService;
    private DefaultTableModel dtm;
    private DefaultTableModel dtmCT;
    private List<HoaDonResponse> hoaDonReponses;

    public FrmHoaDon() {
        initComponents();
        hoadonService = new HoaDonServiceImpl();
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtmCT = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        hoaDonReponses = hoadonService.SelectHoaDon();
        showDataTable(hoaDonReponses);
        setBackground(new Color(0, 0, 0, 0));
        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        tblHoaDon.getTableHeader().setBackground(new Color(0, 123, 123));
        tblHoaDon.getTableHeader().setForeground(Color.white);
        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblHoaDon.getTableHeader().setBackground(new Color(0, 123, 123));
        tblHoaDon.getTableHeader().setForeground(Color.white);
        tblHoaDonChiTiet.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        tblHoaDonChiTiet.getTableHeader().setBackground(new Color(0, 123, 123));
        tblHoaDonChiTiet.getTableHeader().setForeground(Color.white);
        tblHoaDonChiTiet.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblHoaDonChiTiet.getTableHeader().setBackground(new Color(0, 123, 123));
        tblHoaDonChiTiet.getTableHeader().setForeground(Color.white);
        jDateChooser1.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("foreground".equals(e.getPropertyName())) {
                    loadTableHDbyMa();
                }
            }
        });

        jDateChooser2.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("foreground".equals(e.getPropertyName())) {
                    loadTableHDbyMa();
                }
            }
        });

    }
    public void resetTableCT() {
        if (tblHoaDonChiTiet.getRowCount() > 0) {
            dtmCT.setRowCount(0);
        }
    }
    private void showDataTable(List<HoaDonResponse> lists) {
           dtm.setRowCount(0);
        for (HoaDonResponse x : lists) {
            dtm.addRow(x.toDataRow());
        }
        jLabel3.setText("Tổng hóa đơn:" + lists.size());        
    }

    private void showDataTableCTHoaDon(List<HoaDonChiTietResponse> ctHoaDon, DefaultTableModel dtm) {
        for (HoaDonChiTietResponse x : ctHoaDon) {
            dtm.addRow(x.toDataRow());
        }

    }

    private void find(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tblHoaDon.setRowSorter(tr);
        if (query != "Tất cả") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            tblHoaDon.setRowSorter(tr);
        }
      
    }
    
    public void loadTableHDbyMa() {
        dtm.setRowCount(0);
        Date from = null;
        if (jDateChooser1.getCalendar() != null) {
            from = jDateChooser1.getCalendar().getTime();
        }
        Date to = new Date();
        if (jDateChooser2.getCalendar() != null) {
            to = jDateChooser2.getCalendar().getTime();
        }
        if (cboNgay.getSelectedIndex() == 0) {
            hoaDonReponses = hoadonService.getByCodeAndCreateDate(txtTim.getText(), from, to);
        }
        if (cboNgay.getSelectedIndex() == 1) {jDateChooser1.setDate(null);
            hoaDonReponses = hoadonService.getByCodeAndUpdateDate(txtTim.getText(), from, to);
        }
        for (HoaDonResponse x : hoaDonReponses) {
            dtm.addRow(x.toDataRow());
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboThanhToan = new javax.swing.JComboBox<>();
        cboNgay = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboTT = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnXuat = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Hóa đơn");

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HĐ", "Khách hàng", "SĐT KH", "Địa chỉ", "Mã NV", "Tên NV", "Ngày tạo", "Ngày thanh toán", "Loại thanh toán", "Tổng tiền", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Loại thanh toán");

        cboThanhToan.setBackground(new java.awt.Color(0, 153, 153));
        cboThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tiền mặt", "Chuyển khoản", " " }));
        cboThanhToan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThanhToanItemStateChanged(evt);
            }
        });

        cboNgay.setBackground(new java.awt.Color(0, 153, 153));
        cboNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày tạo ", "Ngày thanh toán", " " }));

        jDateChooser1.setDateFormatString("MMM, d y");

        jDateChooser2.setDateFormatString("MMM, d y");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Từ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Đến");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Trạng thái hóa đơn");

        cboTT.setBackground(new java.awt.Color(0, 153, 153));
        cboTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cboTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chờ thanh toán", "Chờ giao", "Đang giao", "Đã thanh toán", "Đã giao" }));
        cboTT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTTItemStateChanged(evt);
            }
        });
        cboTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTTActionPerformed(evt);
            }
        });

        tblHoaDonChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá bán", "Giảm giá", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Hóa đơn chi tiết");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnXuat.setBackground(new java.awt.Color(0, 0, 153));
        btnXuat.setIcon(new ImageIcon("src/main/resource/icon/excelsanpham.png"));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1046, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap(27, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cboThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cboNgay, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        int row = tblHoaDon.getSelectedRow();
        HoaDonResponse hoaDon = hoaDonReponses.get(row);
        UUID IdHoaDon = hoaDon.getId();
        List<HoaDonChiTietResponse> ctHoaDon = hoadonService.SelectByHoaDonCTID(IdHoaDon);
        DefaultTableModel dtmCTHoaDon = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        dtmCTHoaDon.setRowCount(0);
        showDataTableCTHoaDon(ctHoaDon, dtmCTHoaDon);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        resetTableCT();
        try {
            loadTableHDbyMa();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimCaretUpdate

    private void cboThanhToanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThanhToanItemStateChanged
        resetTableCT();
        String query = cboThanhToan.getSelectedItem().toString();
        find(query);
    }//GEN-LAST:event_cboThanhToanItemStateChanged

    private void cboTTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTTItemStateChanged
        resetTableCT();
        String query = cboTT.getSelectedItem().toString();
        find(query);
    }//GEN-LAST:event_cboTTItemStateChanged

    private void cboTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTTActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed

        try {
        
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Hóa đơn");
            sheet.setDefaultColumnWidth(16);
            CellStyle style = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeight((short) 250);
            style.setFont(font);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

            int rowNum = 0;
            Row firstRow = sheet.createRow(rowNum++);

            Cell firstCell1 = firstRow.createCell(0);

            Cell firstCell2 = firstRow.createCell(1);
            Cell firstCell3 = firstRow.createCell(2);
            Cell firstCell4 = firstRow.createCell(3);
            Cell firstCell5 = firstRow.createCell(4);
            Cell firstCell6 = firstRow.createCell(5);
            Cell firstCell7 = firstRow.createCell(6);
            Cell firstCell8 = firstRow.createCell(7);
            Cell firstCell9 = firstRow.createCell(8);
            Cell firstCell10 = firstRow.createCell(9);
            Cell firstCell11 = firstRow.createCell(10);

            firstCell1.setCellValue("Mã HĐ");
            firstCell1.setCellStyle(style);
            firstCell2.setCellValue("Khách hàng");
            firstCell2.setCellStyle(style);
            firstCell3.setCellValue("SĐT KH");
            firstCell3.setCellStyle(style);
            firstCell4.setCellValue("Địa chỉ");
            firstCell4.setCellStyle(style);
            firstCell5.setCellValue("Mã NV");
            firstCell5.setCellStyle(style);
            firstCell6.setCellValue("Tên NV");
            firstCell6.setCellStyle(style);
            firstCell7.setCellValue("Ngày tạo ");
            firstCell7.setCellStyle(style);
            firstCell8.setCellValue("Ngày thanh toán");
            firstCell8.setCellStyle(style);
            firstCell9.setCellValue("Loại thanh toán");
            firstCell9.setCellStyle(style);
            firstCell10.setCellValue("Tổng tiền");
            firstCell10.setCellStyle(style);
            firstCell11.setCellValue("Trạng thái");
            firstCell11.setCellStyle(style);
            for (HoaDonResponse xx : hoaDonReponses) {
                Row row = sheet.createRow(rowNum++);

                Cell cell1 = row.createCell(0);
                cell1.setCellValue(xx.getMa());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(xx.getHoTen());

                Cell cell3 = row.createCell(2);
                cell3.setCellValue(xx.getSdt());
                Cell cell4 = row.createCell(3);
                cell4.setCellValue(xx.getDiaChi());

                Cell cell5 = row.createCell(4);
                cell5.setCellValue(xx.getMaNV());

                Cell cell6 = row.createCell(5);
                cell6.setCellValue(xx.getTenNV());

                Cell cell7 = row.createCell(6);

                cell7.setCellValue(xx.getNgayTao() + "");

                Cell cell8 = row.createCell(7);

                cell8.setCellValue(xx.getNgayThanhToan() + "");

                Cell cell9 = row.createCell(8);
                cell9.setCellValue(xx.getloaiThanhToan());

                Cell cell10 = row.createCell(9);
                cell10.setCellValue(xx.getTongTien() + "");

                Cell cell11 = row.createCell(10);
                cell11.setCellValue(xx.getTrangThai());

            }
            try {
                File f = new File("E://hoadon.xlsx");
                FileOutputStream fos = new FileOutputStream(f);
                workbook.write(fos);
                workbook.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Xuất danh sách hóa đơn thành công");

        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Xuất thất bại");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboNgay;
    private javax.swing.JComboBox<String> cboTT;
    private javax.swing.JComboBox<String> cboThanhToan;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
