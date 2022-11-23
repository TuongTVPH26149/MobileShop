/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
public class HoaDonBanHangResponse {

    private UUID id;
    private String ma;
    private Date ngayTao;
    private String nhanVien;
    private String khachHang;
    private BigDecimal tongTien;
    private boolean loaiThanhToan;
    private String trangThai;

    public HoaDonBanHangResponse(HoaDon hd) {
        this.id = hd.getId();
        this.nhanVien = hd.getTaiKhoan().getMa();
        this.khachHang = hd.getKhachHang().getMa();
        this.trangThai = hd.getTrangThaiHD().getMa();
        this.ma = hd.getMa();
        this.ngayTao = hd.getCreatedDate();
        this.tongTien = hd.getTongTien();
        this.loaiThanhToan = hd.isLoaiThanhToan();
    }

    public Object[] toDataRow() {
        SimpleDateFormat sdf  = new SimpleDateFormat("dd/MM/yyyy");
        return new Object[]{
            this.ma,
            sdf.format(ngayTao),
            this.nhanVien,
            this.khachHang};
    }
}
