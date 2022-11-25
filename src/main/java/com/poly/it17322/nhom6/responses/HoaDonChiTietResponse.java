/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
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
public class HoaDonChiTietResponse {
    
    private UUID IdHoaDon;
    private UUID IdChiTietSP;
    private String tenSP;
    private BigDecimal gia;
    private int soLuong;
    private Date ngayTao;
    private Date ngayThanhToan;

    public HoaDonChiTietResponse() {
}

    public HoaDonChiTietResponse(HoaDonChiTiet hdct) {
        this.IdHoaDon = hdct.getHoaDon().getId();
        this.IdChiTietSP = hdct.getChiTietSP().getId();
        this.tenSP = hdct.getTenSP();
        this.gia = hdct.getGiaBan();
        this.soLuong = hdct.getSoLuong();
        this.ngayTao = hdct.getCreatedDate();
        this.ngayThanhToan = hdct.getLastModifiedDate();
    }

    public Object[] toDataRow() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return new Object[]{tenSP, soLuong, gia, sdf.format(ngayTao), sdf.format(ngayThanhToan)};
    }
}
