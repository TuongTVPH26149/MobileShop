/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17322.nhom6.views;

import com.poly.it17322.nhom6.domainmodels.TaiKhoan;
import com.poly.it17322.nhom6.repositories.TaiKhoanRepository;
import com.poly.it17322.nhom6.responses.NhanVienRespone;
import com.poly.it17322.nhom6.services.INhanVienService;
import com.poly.it17322.nhom6.services.impl.NhanVienServiceImpl;
import com.poly.it17322.nhom6.utilities.GenMa;
import com.poly.it17322.nhom6.utilities.MD5Util;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LiamTrieu
 */
public class FrmNhanVien extends javax.swing.JPanel {

    NhanVienServiceImpl nhanVienServiceImpl = new NhanVienServiceImpl();
//    ArrayList<NhanVienRespone> lstNhanVien = new ArrayList<>();
    ArrayList<TaiKhoan> lstTaiKhoan = new ArrayList<>();
    ArrayList<TaiKhoan> lstTaiKhoan2 = new ArrayList<>();
    List<NhanVienRespone> lstImport = new ArrayList<>();
    int index = -1;

    public FrmNhanVien() {
        try {
            initComponents();
            setBackground(new Color(0, 0, 0, 0));
            tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
            tblNhanVien.getTableHeader().setBackground(new Color(0, 123, 123));
            tblNhanVien.getTableHeader().setForeground(Color.white);
            tblNVNghi.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
            tblNVNghi.getTableHeader().setBackground(new Color(0, 123, 123));
            tblNVNghi.getTableHeader().setForeground(Color.white);

//        lstNhanVien = (ArrayList<NhanVienRespone>) iNhanVienService.getlist();
//        lstTaiKhoan = (ArrayList<TaiKhoan>) iNhanVienService.selectTaiKhoan(0);
            loadTable();
            loadTable2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        index = -1;
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtNgaySinh.setText("");
        txtDiaChi.setText("");
        txtTimKiemDangLam.setText("");
        txtTimKiemNghi.setText("");
        tblNhanVien.setRowSelectionAllowed(false);
        tblNVNghi.setRowSelectionAllowed(false);
    }

    private void loadTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        lstTaiKhoan = new ArrayList<>();
        for (TaiKhoan x : nhanVienServiceImpl.selectTaiKhoan(0)) {
            model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
            lstTaiKhoan.add(x);
        }
    }

    private void loadTable2() {
        DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
        model.setRowCount(0);
        lstTaiKhoan2 = new ArrayList<>();
        for (TaiKhoan x : nhanVienServiceImpl.selectTaiKhoan(1)) {
            model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
            lstTaiKhoan2.add(x);
        }
    }

    private void insert() {
        try {
            if (txtNgaySinh.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return;
            }
            if (txtTen.getText().trim().equals("")
                    || txtSDT.getText().trim().equals("")
                    || txtEmail.getText().trim().equals("")
                    || txtDiaChi.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return;
            }

            Double chkSdt;
            try {
                chkSdt = Double.parseDouble(txtSDT.getText().trim());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "SDT phải là số");
                return;
            }

            String chkDinhDangSdt = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
            boolean kt = txtSDT.getText().trim().matches(chkDinhDangSdt);
            if (kt == false) {
                JOptionPane.showMessageDialog(this, "SDT không đúng định dạng");
                return;
            }

            for (NhanVienRespone x : nhanVienServiceImpl.getlist()) {
                if (txtSDT.getText().trim().equalsIgnoreCase(x.getSdt())) {
                    JOptionPane.showMessageDialog(this, "SDT này đã tồn tại");
                    return;
                }
            }

            String chkMail = "\\w+@\\w+\\.\\w+";
            if (!txtEmail.getText().trim().matches(chkMail)) {
                JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
                return;
            }

            for (NhanVienRespone x : nhanVienServiceImpl.getlist()) {
                if (txtEmail.getText().trim().equalsIgnoreCase(x.getEmail())) {
                    JOptionPane.showMessageDialog(this, "Mail này đã tồn tại");
                    return;
                }
            }

            String ma;
            if (nhanVienServiceImpl.getlist().size() < 9) {
                ma = "NV00" + (nhanVienServiceImpl.getlist().size() + 1);
            } else if (nhanVienServiceImpl.getlist().size() < 99) {
                ma = "NV0" + (nhanVienServiceImpl.getlist().size() + 1);
            } else {
                ma = "NV" + (nhanVienServiceImpl.getlist().size() + 1);
            }
            String hoTen = txtTen.getText().trim();
            String sdt = txtSDT.getText().trim();
            String email = txtEmail.getText().trim();
            String ngaySinhStr = txtNgaySinh.getText().trim();
            String diaChi = txtDiaChi.getText().trim();
            int gioiTinh = rdoNam.isSelected() ? 0 : 1;
            int chucVu = rdoNhanVien.isSelected() ? 0 : 1;
            Date ngaySinh = Date.valueOf(ngaySinhStr);

            try {
                NhanVienRespone nvrp = new NhanVienRespone();
                nvrp.setMa(ma);
                nvrp.setTen(hoTen);
                nvrp.setSdt(sdt);
                nvrp.setEmail(email);
                nvrp.setNgaySinh(ngaySinh);
                nvrp.setDiaChi(diaChi);
                nvrp.setGioiTinh(gioiTinh);
                nvrp.setChucVu(chucVu);
                nvrp.setMatKhau(MD5Util.md5EnCode(nhanVienServiceImpl.genPass()));
                nhanVienServiceImpl.Insert(nvrp);
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                sendMail(email);
                clear();
                loadTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    private void update() {
        try {
            if (txtNgaySinh.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return;
            }
            if (txtTen.getText().trim().equals("")
                    || txtSDT.getText().trim().equals("")
                    || txtEmail.getText().trim().equals("")
                    || txtDiaChi.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Không được để trống");
                return;
            }

            Double chkSdt;
            try {
                chkSdt = Double.parseDouble(txtSDT.getText().trim());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "SDT phải là số");
                return;
            }

            String chkDinhDangSdt = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
            boolean kt = txtSDT.getText().trim().matches(chkDinhDangSdt);
            if (kt == false) {
                JOptionPane.showMessageDialog(this, "SDT không đúng định dạng");
                return;
            }

            String chkMail = "\\w+@\\w+\\.\\w+";
            if (!txtEmail.getText().trim().matches(chkMail)) {
                JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
                return;
            }

            index = tblNhanVien.getSelectedRow();
            String ma = txtMa.getText().trim();
            String hoTen = txtTen.getText().trim();
            String sdt = txtSDT.getText().trim();
            String email = txtEmail.getText().trim();
            String ngaySinhStr = txtNgaySinh.getText().trim();
            String diaChi = txtDiaChi.getText().trim();
            int gioiTinh = rdoNam.isSelected() ? 0 : 1;
            int chucVu = rdoNhanVien.isSelected() ? 0 : 1;
            Date ngaySinh = Date.valueOf(ngaySinhStr);

            try {
                NhanVienRespone nvrp = new NhanVienRespone();
                nvrp.setId(lstTaiKhoan.get(index).getId());
                nvrp.setMa(ma);
                nvrp.setTen(hoTen);
                nvrp.setSdt(sdt);
                nvrp.setEmail(email);
                nvrp.setNgaySinh(ngaySinh);
                nvrp.setDiaChi(diaChi);
                nvrp.setGioiTinh(gioiTinh);
                nhanVienServiceImpl.Update(nvrp);
                clear();
                loadTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    private void writeForm() {
        try {
            txtMa.setText(tblNhanVien.getValueAt(index, 0).toString());
            txtTen.setText(tblNhanVien.getValueAt(index, 1).toString());
            if (tblNhanVien.getValueAt(index, 2).equals("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtNgaySinh.setText(tblNhanVien.getValueAt(index, 3).toString());
            txtDiaChi.setText(tblNhanVien.getValueAt(index, 4).toString());
            txtSDT.setText(tblNhanVien.getValueAt(index, 5).toString());
            txtEmail.setText(tblNhanVien.getValueAt(index, 6).toString());
            if (tblNhanVien.getValueAt(index, 7).equals("Nhân viên")) {
                rdoNhanVien.setSelected(true);
            } else {
                rdoQuanLy.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeForm2() {
        try {
            txtMa.setText(tblNVNghi.getValueAt(index, 0).toString());
            txtTen.setText(tblNVNghi.getValueAt(index, 1).toString());
            if (tblNVNghi.getValueAt(index, 2).equals("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
            txtNgaySinh.setText(tblNVNghi.getValueAt(index, 3).toString());
            txtDiaChi.setText(tblNVNghi.getValueAt(index, 4).toString());
            txtSDT.setText(tblNVNghi.getValueAt(index, 5).toString());
            txtEmail.setText(tblNVNghi.getValueAt(index, 6).toString());
            if (tblNVNghi.getValueAt(index, 7).equals("Nhân viên")) {
                rdoNhanVien.setSelected(true);
            } else {
                rdoQuanLy.setSelected(true);
            }
        } catch (Exception e) {

        }
    }

    private void timKiem1() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (TaiKhoan x : nhanVienServiceImpl.timKiem(txtTimKiemDangLam.getText(), 0)) {
            model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
        }
    }

    private void timKiem2() {
        DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
        model.setRowCount(0);
        for (TaiKhoan x : nhanVienServiceImpl.timKiem(txtTimKiemNghi.getText(), 1)) {
            model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
        }
    }

    private void sendMail(String mail) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);

            String accountName = "tuannaph26113@fpt.edu.vn";
            String accountPass = "tuan123asg";

            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPass);
                }
            });

            String from = accountName;
            String to = mail;
            String subject = "Mat khau dang nhap MobiKing";
            String body = "Dear bạn! Mat khau dang nhap phan mem MobiKing cua ban la " + nhanVienServiceImpl.genPass();

            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            MimeBodyPart contenPart = new MimeBodyPart();
            contenPart.setContent(body, "text/html; charset=utf-8");

            msg.setSubject(subject);
            msg.setText(body);

            Transport.send(msg);

        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    private void sendMultiMail(ArrayList lst) {
        for (int i = 0; i <= lst.size(); i++) {
            try {
                Properties p = new Properties();
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.port", 587);

                String accountName = "tuannaph26113@fpt.edu.vn";
                String accountPass = "tuan123asg";

                Session s = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(accountName, accountPass);
                    }
                });

                String from = accountName;
                String to = lst.get(i).toString();
                String subject = "Mat khau dang nhap MobiKing";
                String body = "Dear bạn! Mat khau dang nhap phan mem MobiKing cua ban la 12345";

                Message msg = new MimeMessage(s);
                msg.setFrom(new InternetAddress(from));
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

                MimeBodyPart contenPart = new MimeBodyPart();
                contenPart.setContent(body, "text/html; charset=utf-8");

                msg.setSubject(subject);
                msg.setText(body);

                Transport.send(msg);

            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

    private void importExcel() {

        try {
            JFileChooser fc = new JFileChooser();
            int chon = fc.showSaveDialog(this);
            if (chon == JFileChooser.APPROVE_OPTION) {
                String filename = fc.getSelectedFile().getAbsolutePath();

                FileInputStream fis = new FileInputStream(filename);
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        if (formula.evaluate(cell).getCellType() != null) {
                            NhanVienRespone nvr = new NhanVienRespone();
                            nvr.setTen(cell.getStringCellValue());
                            nvr.setGioiTinh(Integer.parseInt(cell.getStringCellValue()));
                            nvr.setNgaySinh(cell.getDateCellValue());
                            nvr.setDiaChi(cell.getStringCellValue());
                            nvr.setSdt(cell.getStringCellValue());
                            nvr.setEmail(cell.getStringCellValue());
                            nvr.setChucVu(Integer.parseInt(cell.getStringCellValue()));
                            lstImport.add(nvr);
                        }
                    }
                }
                fis.read();
                wb.close();
                fis.close();
                JOptionPane.showMessageDialog(this, "Insert thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnNhanVien = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblTimKiem = new javax.swing.JLabel();
        txtTimKiemDangLam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnChonAll = new javax.swing.JButton();
        btnBoAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiemNghi = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNVNghi = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboGioiTinhLam = new javax.swing.JComboBox<>();
        cboChucVuLam = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cboGioiTinhNghi = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cboChucVuNghi = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));

        pnNhanVien.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblTimKiem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTimKiem.setText("Tìm Kiếm");

        txtTimKiemDangLam.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemDangLamCaretUpdate(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Email", "Chức vụ", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblNhanVien.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblNhanVien.setRowHeight(30);
        tblNhanVien.setShowVerticalLines(false);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        btnDelete.setBackground(new java.awt.Color(0, 123, 123));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Nghỉ");
        btnDelete.setPreferredSize(new java.awt.Dimension(95, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnChonAll.setBackground(new java.awt.Color(0, 123, 123));
        btnChonAll.setForeground(new java.awt.Color(255, 255, 255));
        btnChonAll.setText("Chọn Tất Cả");
        btnChonAll.setPreferredSize(new java.awt.Dimension(95, 23));
        btnChonAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAllActionPerformed(evt);
            }
        });

        btnBoAll.setBackground(new java.awt.Color(0, 123, 123));
        btnBoAll.setForeground(new java.awt.Color(255, 255, 255));
        btnBoAll.setText("Bỏ chọn");
        btnBoAll.setPreferredSize(new java.awt.Dimension(95, 23));
        btnBoAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtTimKiemDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBoAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChonAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTimKiem)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemDangLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBoAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pnNhanVien.addTab("DANH SÁCH NHÂN VIÊN ĐANG LÀM VIỆC", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tìm Kiếm");

        txtTimKiemNghi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemNghiCaretUpdate(evt);
            }
        });
        txtTimKiemNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemNghiActionPerformed(evt);
            }
        });

        tblNVNghi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Email", "Chức vụ"
            }
        ));
        tblNVNghi.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblNVNghi.setRowHeight(30);
        tblNVNghi.setShowVerticalLines(false);
        tblNVNghi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVNghiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNVNghi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtTimKiemNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 339, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(10, 10, 10)
                .addComponent(txtTimKiemNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pnNhanVien.addTab("DANH SÁCH NHÂN VIÊN ĐÃ NGHỈ VIỆC", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Mã nhân viên");

        txtMa.setEnabled(false);
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel3.setText("Họ tên");

        jLabel4.setText("Giới tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel5.setText("SDT");

        jLabel6.setText("Ngày sinh");

        jLabel7.setText("Email");

        jLabel8.setText("Địa chỉ");

        jLabel10.setText("Chúc vụ");

        buttonGroup2.add(rdoNhanVien);
        rdoNhanVien.setSelected(true);
        rdoNhanVien.setText("Nhân viên");

        buttonGroup2.add(rdoQuanLy);
        rdoQuanLy.setText("Quản lý");

        btnThem.setBackground(new java.awt.Color(0, 123, 123));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new ImageIcon("src/main/resource/icon/addkh.png"));
        btnThem.setText("Thêm");
        btnThem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 123, 123));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new ImageIcon("src/main/resource/icon/updatekh.png"));
        btnSua.setText("Sửa");
        btnSua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(0, 123, 123));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new ImageIcon("src/main/resource/icon/clearkh.png"));
        btnClear.setText("Clear");
        btnClear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(0, 123, 123));
        btnXuat.setIcon(new ImageIcon("src/main/resource/icon/xuatexcel.png"));
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgaySinh)
                            .addComponent(txtSDT)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(rdoNhanVien)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(rdoQuanLy)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)
                                .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                .addComponent(txtDiaChi))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNu))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(134, 134, 134)
                                .addComponent(jLabel8))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNhanVien)
                            .addComponent(rdoQuanLy)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc NV làm"));
        jPanel3.setMaximumSize(new java.awt.Dimension(110, 20));
        jPanel3.setMinimumSize(new java.awt.Dimension(110, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 20));

        jLabel2.setText("Giới tính");

        jLabel11.setText("Chức vụ");

        cboGioiTinhLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));
        cboGioiTinhLam.setMaximumSize(new java.awt.Dimension(110, 20));
        cboGioiTinhLam.setMinimumSize(new java.awt.Dimension(110, 20));
        cboGioiTinhLam.setPreferredSize(new java.awt.Dimension(110, 20));
        cboGioiTinhLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhLamActionPerformed(evt);
            }
        });

        cboChucVuLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nhân viên", "Quản lý" }));
        cboChucVuLam.setMaximumSize(new java.awt.Dimension(110, 20));
        cboChucVuLam.setMinimumSize(new java.awt.Dimension(110, 20));
        cboChucVuLam.setPreferredSize(new java.awt.Dimension(110, 20));
        cboChucVuLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuLamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboChucVuLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cboGioiTinhLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboGioiTinhLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboChucVuLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc NV nghỉ"));
        jPanel4.setPreferredSize(new java.awt.Dimension(110, 20));

        jLabel12.setText("Giới tính");

        cboGioiTinhNghi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nam", "Nữ" }));
        cboGioiTinhNghi.setMaximumSize(new java.awt.Dimension(110, 20));
        cboGioiTinhNghi.setMinimumSize(new java.awt.Dimension(110, 20));
        cboGioiTinhNghi.setPreferredSize(new java.awt.Dimension(110, 20));
        cboGioiTinhNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGioiTinhNghiActionPerformed(evt);
            }
        });

        jLabel13.setText("Chúc vụ");

        cboChucVuNghi.setEditable(true);
        cboChucVuNghi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Nhân viên", "Quản lý" }));
        cboChucVuNghi.setPreferredSize(new java.awt.Dimension(110, 20));
        cboChucVuNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChucVuNghiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cboGioiTinhNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboChucVuNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboGioiTinhNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboChucVuNghi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnNhanVien))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert();

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        tblNhanVien.setRowSelectionAllowed(true);
        index = tblNhanVien.getSelectedRow();
        writeForm();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtTimKiemDangLamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemDangLamCaretUpdate
        timKiem1();
    }//GEN-LAST:event_txtTimKiemDangLamCaretUpdate

    private void tblNVNghiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVNghiMouseClicked
        tblNVNghi.setRowSelectionAllowed(true);
        index = tblNVNghi.getSelectedRow();
        writeForm2();
    }//GEN-LAST:event_tblNVNghiMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tblNhanVien.getRowCount() > 0) {
                for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
                    boolean bl = Boolean.parseBoolean(tblNhanVien.getValueAt(i, 8).toString());
                    if (bl) {
                        NhanVienRespone nvrp = new NhanVienRespone();
                        nvrp.setId(lstTaiKhoan.get(i).getId());
                        nvrp.setTrangThai(1);
                        nhanVienServiceImpl.Delete(nvrp);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không còn nhân viên đang làm việc");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear();
        loadTable();
        loadTable2();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtTimKiemNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemNghiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemNghiActionPerformed

    private void txtTimKiemNghiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemNghiCaretUpdate
        timKiem2();
    }//GEN-LAST:event_txtTimKiemNghiCaretUpdate

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {
            XSSFWorkbook wordbook = new XSSFWorkbook();
            XSSFSheet sheet = wordbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ma");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Tên");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ngày sinh");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Giới tính");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Địa chỉ");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Sdt");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Email");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Chức vụ");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Trạng thái");

            for (int i = 0; i < nhanVienServiceImpl.getlist().size(); i++) {
                row = sheet.createRow(1 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getMa());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getTen());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getNgaySinh());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getGioiTinh() == 0 ? "Nam" : "Nữ");

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getDiaChi());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getSdt());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getEmail());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getChucVu() == 0 ? "Nhân viên" : "Quản lý");

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(nhanVienServiceImpl.getlist().get(i).getTrangThai() == 0 ? "Đang làm" : "Đã nghỉ");

            }
                File file = new File("D:/NV" + new GenMa().getMa() + ".xlsx");
                FileOutputStream fis = new FileOutputStream(file);
                wordbook.write(fis);
                fis.close();
                JOptionPane.showMessageDialog(this, "Xuất thành công");
                try {
                    if (!Desktop.isDesktopSupported()) {
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if (file.exists()) {
                        desktop.open(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnChonAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAllActionPerformed
        try {
            if (tblNhanVien.getRowCount() > 0) {
                for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
                    tblNhanVien.setValueAt(true, i, 8);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không còn nhân viên đang làm việc");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnChonAllActionPerformed

    private void btnBoAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoAllActionPerformed
        try {
            if (tblNhanVien.getRowCount() > 0) {
                for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
                    tblNhanVien.setValueAt(false, i, 8);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không còn nhân viên đang làm việc");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBoAllActionPerformed

    private void cboGioiTinhLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhLamActionPerformed
        try {
            if (cboGioiTinhLam.getSelectedIndex() == 0) {
                loadTable();
            } else if (cboGioiTinhLam.getSelectedIndex() == 1) {
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locGioiTinh(0, 0)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locGioiTinh(1, 0)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboGioiTinhLamActionPerformed

    private void cboChucVuLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuLamActionPerformed
        try {
            if (cboChucVuLam.getSelectedIndex() == 0) {
                loadTable();
            } else if (cboChucVuLam.getSelectedIndex() == 1) {
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locChucVu(0, 0)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locChucVu(1, 0)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboChucVuLamActionPerformed

    private void cboGioiTinhNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGioiTinhNghiActionPerformed
        try {
            if (cboGioiTinhLam.getSelectedIndex() == 0) {
                loadTable2();
            } else if (cboGioiTinhLam.getSelectedIndex() == 1) {
                DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locGioiTinh(0, 1)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locGioiTinh(1, 1)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboGioiTinhNghiActionPerformed

    private void cboChucVuNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChucVuNghiActionPerformed
        try {
            if (cboGioiTinhLam.getSelectedIndex() == 0) {
                loadTable2();
            } else if (cboGioiTinhLam.getSelectedIndex() == 1) {
                DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locChucVu(0, 1)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            } else {
                DefaultTableModel model = (DefaultTableModel) tblNVNghi.getModel();
                model.setRowCount(0);
                for (TaiKhoan x : nhanVienServiceImpl.locChucVu(1, 1)) {
                    model.addRow(new Object[]{x.getMa(), x.getHoTen(), x.getGioiTinh() == 0 ? "Nam" : "Nữ", x.getNgaySinh(), x.getDiaChi(), x.getSdt(), x.getEmail(), x.getChucVu() == 0 ? "Nhân viên" : "Quản lý"});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboChucVuNghiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoAll;
    private javax.swing.JButton btnChonAll;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXuat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChucVuLam;
    private javax.swing.JComboBox<String> cboChucVuNghi;
    private javax.swing.JComboBox<String> cboGioiTinhLam;
    private javax.swing.JComboBox<String> cboGioiTinhNghi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JTabbedPane pnNhanVien;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblNVNghi;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiemDangLam;
    private javax.swing.JTextField txtTimKiemNghi;
    // End of variables declaration//GEN-END:variables
}
