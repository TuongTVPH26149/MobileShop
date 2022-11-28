/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.nhom6.responses;

import com.poly.it17322.nhom6.domainmodels.HoaDon;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author LiamTrieu
 */
@Getter
@Setter
@NoArgsConstructor
public class DonHangRespone {
    private UUID id;
    private UUID idKH;
    private UUID idNV;
    private String tenkhachHang;
    private String maHD;
    private String maNV;
    private String diaChi;
    private BigDecimal tongTien;
    private BigDecimal tienMat;
    private BigDecimal chuyenKhoan;
    private BigDecimal giamGia;
    private int hinhThuc;
    private int nhanHang;
    private int trangThai;

    public DonHangRespone(HoaDon h) {
        this.tenkhachHang = h.getKhachHang().getMa()+"-"+h.getKhachHang().getHoTen();
        this.maHD = h.getMa();
        this.maNV = h.getTaiKhoan().getMa()+"-"+h.getTaiKhoan().getHoTen();
        this.giamGia = h.getGiamGia();
        this.hinhThuc = h.getLoaiThanhToan();
        this.nhanHang = h.getTrangThai()==2?1:(h.getTrangThai()==3?1:2);
    }
    
    
}
