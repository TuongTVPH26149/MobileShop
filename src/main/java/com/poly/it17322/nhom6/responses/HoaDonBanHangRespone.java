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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Setter
@Getter
@NoArgsConstructor
public class HoaDonBanHangRespone {

    private UUID id;
    private String ma;
    private Date ngayTao;
    private String nguoiTao;
    private String khachHang;
    private int trangThai;

    public HoaDonBanHangRespone(HoaDon hd) {
        try {
            this.id = hd.getId();
            this.ma = hd.getMa();
            this.ngayTao = hd.getNgayTao();
            this.nguoiTao = hd.getTaiKhoan().getMa();
            this.khachHang = hd.getKhachHang().getHoTen();
            this.trangThai = hd.getTrangThai();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object[] toDataRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return new Object[]{
            ma,
            sdf.format(ngayTao),
            nguoiTao,
            khachHang,
            trangThai == 0 ? "chờ thanh toán" : (trangThai == 1 ? "Chờ giao" : "Đang giao")
        };
    }

}
