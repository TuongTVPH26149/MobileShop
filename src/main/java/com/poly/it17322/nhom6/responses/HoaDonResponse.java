/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class HoaDonResponse {
    
    private UUID Id;
    private String ma;
    private String hoTen;
    private String sdt;
    private BigDecimal tongTien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int loaiThanhToan;
    private String nhanVien;

    public HoaDonResponse() {
}

    public HoaDonResponse(HoaDon hd) {
        this.Id = hd.getId();
        this.ma = hd.getMa();
        this.hoTen = hd.getKhachHang().getHoTen();
        this.sdt = hd.getKhachHang().getSdt();
        this.tongTien = hd.getTongTien();
        this.ngayTao = hd.getNgayTao();
        this.ngayThanhToan = hd.getLastModifiedDate();
        this.loaiThanhToan = hd.getLoaiThanhToan();
        this.nhanVien = hd.getTaiKhoan().getMa();
    }

    public String getloaiThanhToan() {
        return loaiThanhToan == 0 ? "Tiền mặt" : "Chuyển khoản";
    }

    public Object[] toDataRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new Object[]{ma, hoTen, sdt, nhanVien,
            sdf.format(ngayTao), sdf.format(ngayThanhToan), getloaiThanhToan(), tongTien};
    }
}
