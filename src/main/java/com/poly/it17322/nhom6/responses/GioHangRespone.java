/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.ChiTietSP;
import com.poly.it17322.nhom6.domainmodels.HoaDonChiTiet;
import java.math.BigDecimal;
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
public class GioHangRespone {
    private UUID id;
    private String tenSanPham;
    private String manHinh;
    private String cpu;
    private String pin;
    private int soLuong;
    private BigDecimal giaBan;
    private BigDecimal khuyenMai;
    private int trangThai;
    
    public GioHangRespone(HoaDonChiTiet hdct) {
        this.id = hdct.getId();
        this.tenSanPham = hdct.getTenSP();
        this.manHinh = hdct.getChiTietSP().getManHinh().getTen();
        this.cpu = hdct.getChiTietSP().getCpu().getTen();
        this.pin = hdct.getChiTietSP().getPin().getTen();
        this.soLuong = hdct.getSoLuong();
        this.giaBan = hdct.getChiTietSP().getGia();
        this.khuyenMai = new BigDecimal(0);
        this.trangThai = hdct.getTrangThai();
    }
    
    public Object[] toDataRow(){
        return new Object[]{tenSanPham,manHinh,cpu,pin,giaBan,khuyenMai,soLuong};
    }
}
