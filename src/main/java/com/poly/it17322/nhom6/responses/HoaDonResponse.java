/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rùa
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

    public HoaDonResponse() {
    }

    public HoaDonResponse(HoaDon hd) {
        this.Id = hd.getId();
        this.ma = hd.getMa();
        this.hoTen = hd.getKhachHang().getHoTen();
        this.sdt = hd.getKhachHang().getSdt();
        this.tongTien = hd.getTongTien();
        this.ngayTao = hd.getCreatedDate();
        this.ngayThanhToan = hd.getLastModifiedDate();

    }

    public Object[] toDataRow() {
        return new Object[]{Id, ma, hoTen, sdt, tongTien, ngayTao, ngayThanhToan};
    }
}
